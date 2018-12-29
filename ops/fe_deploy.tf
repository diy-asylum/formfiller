provider "aws" {}

data "aws_ecr_repository" "diy-ecr-fe" {
  name = "frontend"
}

resource "aws_iam_role" "ecs_execution_role" {
  name = "ecs_execution_role"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "ecs-tasks.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
EOF
}

resource "aws_iam_role_policy" "ecs_execution_policy" {
  name = "ecs_execution_policy"
  role = "${aws_iam_role.ecs_execution_role.id}"

  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "ecr:GetAuthorizationToken",
        "ecr:BatchCheckLayerAvailability",
        "ecr:GetDownloadUrlForLayer",
        "ecr:BatchGetImage",
        "logs:CreateLogStream",
        "logs:PutLogEvents"
      ],
      "Resource": "*"
    }
  ]
}
EOF
}

resource "aws_ecs_cluster" "diyasylum" {
  name = "diyasylum"
}

resource "aws_ecs_task_definition" "diyasylum-fe" {
  family                   = "diyasylum-fe"
  depends_on               = ["aws_iam_role_policy.ecs_execution_policy"]
  network_mode             = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  cpu                      = 1024
  memory                   = 4096
  execution_role_arn       = "${aws_iam_role.ecs_execution_role.arn}"

  container_definitions = <<DEFINITION
[
  {
    "essential": true,
    "image": "${data.aws_ecr_repository.diy-ecr-fe.repository_url}:latest",
    "name": "diyasylum-fe",
    "portMappings": [
                {
                    "containerPort": 3000,
                    "hostPort": 3000
                }
            ]
  }
]
DEFINITION
}

resource "aws_vpc" "main" {
  cidr_block = "10.0.0.0/16"
}

resource "aws_internet_gateway" "gw" {
  vpc_id = "${aws_vpc.main.id}"
}

resource "aws_security_group" "allow_all" {
  name        = "allow_all"
  description = "Allow all inbound traffic"
  vpc_id      = "${aws_vpc.main.id}"

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 3000
    to_port     = 3000
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_subnet" "subnet_1" {
  vpc_id            = "${aws_security_group.allow_all.vpc_id}"
  cidr_block        = "10.0.0.0/25"
  availability_zone = "us-east-1a"
}

resource "aws_subnet" "subnet_2" {
  vpc_id            = "${aws_security_group.allow_all.vpc_id}"
  cidr_block        = "10.0.0.128/25"
  availability_zone = "us-east-1b"
}

resource "aws_route_table" "nat_route_1" {
  vpc_id = "${aws_vpc.main.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }
}

resource "aws_route_table" "nat_route_2" {
  vpc_id = "${aws_vpc.main.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }
}

resource "aws_route_table_association" "subnet_1_association" {
  subnet_id      = "${aws_subnet.subnet_1.id}"
  route_table_id = "${aws_route_table.nat_route_1.id}"
}

resource "aws_route_table_association" "subnet_2_association" {
  subnet_id      = "${aws_subnet.subnet_2.id}"
  route_table_id = "${aws_route_table.nat_route_2.id}"
}

resource "aws_lb_target_group" "ecs-target-group" {
  name        = "diyasylum-fe"
  port        = 3000
  protocol    = "HTTP"
  target_type = "ip"
  vpc_id      = "${aws_vpc.main.id}"
}

resource "aws_lb" "ecs-load-balancer" {
  name            = "ecs-load-balancer"
  security_groups = ["${aws_security_group.allow_all.id}"]
  subnets         = ["${aws_subnet.subnet_1.id}", "${aws_subnet.subnet_2.id}"]

  tags {
    Name = "ecs-load-balancer"
  }
}

resource "aws_lb_listener" "lb-listener" {
  load_balancer_arn = "${aws_lb.ecs-load-balancer.arn}"
  port              = "80"
  protocol          = "HTTP"

  default_action {
    target_group_arn = "${aws_lb_target_group.ecs-target-group.arn}"
    type             = "forward"
  }
}

resource "aws_ecs_service" "diyasylum-fe" {
  name          = "diyasylum-fe"
  cluster       = "${aws_ecs_cluster.diyasylum.id}"
  desired_count = 1
  launch_type   = "FARGATE"

  network_configuration {
    assign_public_ip = true
    security_groups  = ["${aws_security_group.allow_all.id}"]
    subnets          = ["${aws_subnet.subnet_1.id}", "${aws_subnet.subnet_2.id}"]
  }

  # Track the latest ACTIVE revision
  task_definition = "${aws_ecs_task_definition.diyasylum-fe.family}"

  load_balancer {
    target_group_arn = "${aws_lb_target_group.ecs-target-group.arn}"
    container_name   = "diyasylum-fe"
    container_port   = 3000
  }

  depends_on = ["aws_lb_listener.lb-listener"]
}
