# AWS credentials are automatically loaded from the default AWS CLI configuration
provider "aws" {}

# Fetches the data from ECR for the "frontend" Docker registry
# Assumes that such a registry already exists
data "aws_ecr_repository" "diy-ecr-fe" {
  name = "frontend"
}

data "aws_ecr_repository" "diy-ecr-be" {
  name = "backend"
}

# Creates IAM policies with permissions suitable for running ECS tasks
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

# Security groups which restrict access as much as possible
resource "aws_security_group" "egress_all" {
  name        = "egress_all"
  description = "Allow all outbound traffic"
  vpc_id      = "${aws_vpc.main.id}"

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_security_group" "fe_lb_security" {
  name        = "fe_lb_security"
  description = "Allow all inbound HTTPS traffic"
  vpc_id      = "${aws_vpc.main.id}"

  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

variable "frontend_port" {}

resource "aws_security_group" "fe_ecs_security" {
  name        = "fe_ecs_security"
  description = "Allow inbound traffic from FE load balancer"
  vpc_id      = "${aws_vpc.main.id}"

  ingress {
    from_port       = "${var.frontend_port}"
    to_port         = "${var.frontend_port}"
    protocol        = "tcp"
    security_groups = ["${aws_security_group.fe_lb_security.id}"]
  }
}

resource "aws_security_group_rule" "traffic_from_fe_lb_to_ecs" {
  type                     = "egress"
  from_port                = "${var.frontend_port}"
  to_port                  = "${var.frontend_port}"
  protocol                 = "tcp"
  source_security_group_id = "${aws_security_group.fe_ecs_security.id}"
  security_group_id        = "${aws_security_group.fe_lb_security.id}"
}

resource "aws_security_group" "be_lb_security" {
  name        = "be_lb_security"
  description = "Allow inbound traffic from FE"
  vpc_id      = "${aws_vpc.main.id}"

  ingress {
    from_port       = 80
    to_port         = 80
    protocol        = "tcp"
    security_groups = ["${aws_security_group.fe_ecs_security.id}"]
  }
}

variable "backend_port" {}

resource "aws_security_group" "be_ecs_security" {
  name        = "be_ecs_security"
  description = "Allow inbound traffic from BE load balancer"
  vpc_id      = "${aws_vpc.main.id}"

  ingress {
    from_port       = "${var.backend_port}"
    to_port         = "${var.backend_port}"
    protocol        = "tcp"
    security_groups = ["${aws_security_group.be_lb_security.id}"]
  }
}

resource "aws_security_group_rule" "traffic_from_be_lb_to_ecs" {
  type                     = "egress"
  from_port                = "${var.backend_port}"
  to_port                  = "${var.backend_port}"
  protocol                 = "tcp"
  source_security_group_id = "${aws_security_group.be_ecs_security.id}"
  security_group_id        = "${aws_security_group.be_lb_security.id}"
}

# Create private VPC to host our service.
resource "aws_vpc" "main" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
}

# Declare subnets in which our service will be hosted.
# Private subnets will contain the servers running our code.
# Corresponding public subnets will be used for public facing load balancers
# and for NAT gateways which give our servers the ability to access the public internet.
resource "aws_subnet" "public_subnet_1" {
  vpc_id                  = "${aws_vpc.main.id}"
  cidr_block              = "10.0.0.0/26"
  map_public_ip_on_launch = "true"
  availability_zone       = "us-east-1a"
}

resource "aws_subnet" "public_subnet_2" {
  vpc_id                  = "${aws_vpc.main.id}"
  cidr_block              = "10.0.0.64/26"
  map_public_ip_on_launch = "true"
  availability_zone       = "us-east-1b"
}

resource "aws_subnet" "private_subnet_1" {
  vpc_id                  = "${aws_vpc.main.id}"
  cidr_block              = "10.0.0.128/26"
  map_public_ip_on_launch = "false"
  availability_zone       = "us-east-1a"
}

resource "aws_subnet" "private_subnet_2" {
  vpc_id                  = "${aws_vpc.main.id}"
  cidr_block              = "10.0.0.192/26"
  map_public_ip_on_launch = "false"
  availability_zone       = "us-east-1b"
}

# Internet gateway to give our public subnets access to the internet
resource "aws_internet_gateway" "gw" {
  vpc_id = "${aws_vpc.main.id}"
}

resource "aws_route_table" "public_egress" {
  vpc_id = "${aws_vpc.main.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }
}

resource "aws_route_table_association" "public_egress_route_1" {
  subnet_id      = "${aws_subnet.public_subnet_1.id}"
  route_table_id = "${aws_route_table.public_egress.id}"
}

resource "aws_route_table_association" "public_egress_route_2" {
  subnet_id      = "${aws_subnet.public_subnet_2.id}"
  route_table_id = "${aws_route_table.public_egress.id}"
}

# NAT gateway to give our private subnets access to the public internet
resource "aws_eip" "public_eip_1" {
  vpc = true
}

resource "aws_nat_gateway" "nat" {
  subnet_id     = "${aws_subnet.public_subnet_1.id}"
  allocation_id = "${aws_eip.public_eip_1.id}"
  depends_on    = ["aws_internet_gateway.gw"]
}

resource "aws_route_table" "nat_route" {
  vpc_id = "${aws_vpc.main.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_nat_gateway.nat.id}"
  }
}

resource "aws_route_table_association" "subnet_1_association" {
  subnet_id      = "${aws_subnet.private_subnet_1.id}"
  route_table_id = "${aws_route_table.nat_route.id}"
}

resource "aws_route_table_association" "subnet_2_association" {
  subnet_id      = "${aws_subnet.private_subnet_2.id}"
  route_table_id = "${aws_route_table.nat_route.id}"
}

# Create target groups for load balancing.
# One each for FE and BE services
resource "aws_lb_target_group" "fe-target-group" {
  name        = "diyasylum-fe"
  port        = "${var.frontend_port}"
  protocol    = "HTTP"
  target_type = "ip"
  vpc_id      = "${aws_vpc.main.id}"
}

resource "aws_lb_target_group" "be-target-group" {
  name        = "diyasylum-be"
  port        = "${var.backend_port}"
  protocol    = "HTTP"
  target_type = "ip"
  vpc_id      = "${aws_vpc.main.id}"
}

# Create load balancers.
# Note that the FE load balancer is in the public subnets
# while the BE load balancer is in the private subnets and is internal.
resource "aws_lb" "fe-load-balancer" {
  name            = "fe-load-balancer"
  security_groups = ["${aws_security_group.fe_lb_security.id}"]
  subnets         = ["${aws_subnet.public_subnet_1.id}", "${aws_subnet.public_subnet_2.id}"]
  internal        = false

  tags {
    Name = "fe-load-balancer"
  }
}

resource "aws_lb" "be-load-balancer" {
  name            = "be-load-balancer"
  security_groups = ["${aws_security_group.be_lb_security.id}"]
  subnets         = ["${aws_subnet.private_subnet_1.id}", "${aws_subnet.private_subnet_2.id}"]
  internal        = true

  tags {
    Name = "be-load-balancer"
  }
}

# Set up public and private DNS
data "aws_route53_zone" "diyasylum_public" {
  name         = "diyasylum.com."
  private_zone = false
}

resource "aws_route53_zone" "diyasylum_private" {
  name = "diyasylum.com"

  vpc {
    vpc_id = "${aws_vpc.main.id}"
  }
}

variable "fe_dns" {}

resource "aws_route53_record" "public_fe_dev_dns" {
  zone_id = "${data.aws_route53_zone.diyasylum_public.zone_id}"
  name    = "${var.fe_dns}"
  type    = "A"

  alias {
    name                   = "${aws_lb.fe-load-balancer.dns_name}"
    zone_id                = "${aws_lb.fe-load-balancer.zone_id}"
    evaluate_target_health = true
  }
}

resource "aws_route53_record" "private_be_dev_dns" {
  zone_id = "${aws_route53_zone.diyasylum_private.zone_id}"
  name    = "formfiller.diyasylum.com"
  type    = "A"

  alias {
    name                   = "${aws_lb.be-load-balancer.dns_name}"
    zone_id                = "${aws_lb.be-load-balancer.zone_id}"
    evaluate_target_health = true
  }
}

# We assume that an ACM certificate has been independently issued
# Validation with Terraform is TBD
resource "aws_acm_certificate" "diyasylum_cert" {
  domain_name       = "*.diyasylum.com"
  validation_method = "DNS"
}

resource "aws_route53_record" "diyasylum_cert_validation" {
  name    = "${aws_acm_certificate.diyasylum_cert.domain_validation_options.0.resource_record_name}"
  type    = "${aws_acm_certificate.diyasylum_cert.domain_validation_options.0.resource_record_type}"
  zone_id = "${data.aws_route53_zone.diyasylum_public.zone_id}"
  records = ["${aws_acm_certificate.diyasylum_cert.domain_validation_options.0.resource_record_value}"]
  ttl     = 60
}

resource "aws_acm_certificate_validation" "diyasylum_cert_validation" {
  certificate_arn         = "${aws_acm_certificate.diyasylum_cert.arn}"
  validation_record_fqdns = ["${aws_route53_record.diyasylum_cert_validation.fqdn}"]
}

# Direct load balancers to forward to target groups.
# FE LB uses SSL whereas BE does not, since traffic is protected in our VPC
# FE redirects HTTP requests to HTTPS
resource "aws_lb_listener" "fe-listener" {
  load_balancer_arn = "${aws_lb.fe-load-balancer.arn}"
  port              = "443"
  protocol          = "HTTPS"
  ssl_policy        = "ELBSecurityPolicy-2015-05"
  certificate_arn   = "${aws_acm_certificate.diyasylum_cert.arn}"

  default_action {
    target_group_arn = "${aws_lb_target_group.fe-target-group.arn}"
    type             = "forward"
  }

  depends_on = ["aws_acm_certificate_validation.diyasylum_cert_validation"]
}

resource "aws_lb_listener" "fe-redirect-http-to-https" {
  load_balancer_arn = "${aws_lb.fe-load-balancer.arn}"
  port              = "80"
  protocol          = "HTTP"

  default_action {
    target_group_arn = "${aws_lb_target_group.fe-target-group.arn}"
    type             = "redirect"

    redirect {
      port        = "443"
      protocol    = "HTTPS"
      status_code = "HTTP_301"
    }
  }
}

resource "aws_lb_listener" "be-listener" {
  load_balancer_arn = "${aws_lb.be-load-balancer.arn}"
  port              = "80"
  protocol          = "HTTP"

  default_action {
    target_group_arn = "${aws_lb_target_group.be-target-group.arn}"
    type             = "forward"
  }
}

# Print load balancer DNS when deployment is complete.
output "fe_dns" {
  value = "${aws_route53_record.public_fe_dev_dns.name}"
}

output "be_dns" {
  value = "${aws_route53_record.private_be_dev_dns.name}"
}

# Define parameters of ECS task. Indicates the Docker container which will be run,
# port mappings, required compute resources, and permissions.
# Host for BE service is defined as an environment variable in the FE task.
resource "aws_ecs_task_definition" "diyasylum-fe" {
  family                   = "diyasylum-fe"
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
                    "containerPort": ${var.frontend_port},
                    "hostPort": ${var.frontend_port}
                }
            ],
    "environment" : [
      { "name" : "BE_HOST", "value" : "http://${aws_route53_record.private_be_dev_dns.name}" }
  ]
  }
]
DEFINITION

  depends_on = ["aws_iam_role_policy.ecs_execution_policy"]
}

resource "aws_ecs_task_definition" "diyasylum-be" {
  family                   = "diyasylum-be"
  network_mode             = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  cpu                      = 1024
  memory                   = 4096
  execution_role_arn       = "${aws_iam_role.ecs_execution_role.arn}"

  container_definitions = <<DEFINITION
[
  {
    "essential": true,
    "image": "${data.aws_ecr_repository.diy-ecr-be.repository_url}:latest",
    "name": "diyasylum-be",
    "portMappings": [
                {
                    "containerPort": ${var.backend_port},
                    "hostPort": ${var.backend_port}
                }
            ]
  }
]
DEFINITION

  depends_on = ["aws_iam_role_policy.ecs_execution_policy"]
}

# Create ECS cluster.
resource "aws_ecs_cluster" "diyasylum" {
  name = "diyasylum"
}

# Create ECS service to run the task defined above. 
# Services are private and do not have a public IP. 
# The FE service is publicly accesible via the load balancer defined above. 
resource "aws_ecs_service" "diyasylum-fe" {
  name          = "diyasylum-fe"
  cluster       = "${aws_ecs_cluster.diyasylum.id}"
  desired_count = 2
  launch_type   = "FARGATE"

  network_configuration {
    assign_public_ip = false
    security_groups  = ["${aws_security_group.egress_all.id}", "${aws_security_group.fe_ecs_security.id}"]
    subnets          = ["${aws_subnet.private_subnet_1.id}", "${aws_subnet.private_subnet_2.id}"]
  }

  task_definition = "${aws_ecs_task_definition.diyasylum-fe.family}"

  load_balancer {
    target_group_arn = "${aws_lb_target_group.fe-target-group.arn}"
    container_name   = "diyasylum-fe"
    container_port   = "${var.frontend_port}"
  }

  depends_on = ["aws_lb_listener.fe-listener"]
}

# The BE service is internally accessible via the load balancer.
# Access is restricted to the FE ECS cluster. 
resource "aws_ecs_service" "diyasylum-be" {
  name          = "diyasylum-be"
  cluster       = "${aws_ecs_cluster.diyasylum.id}"
  desired_count = 2
  launch_type   = "FARGATE"

  network_configuration {
    assign_public_ip = false
    security_groups  = ["${aws_security_group.egress_all.id}", "${aws_security_group.be_ecs_security.id}"]
    subnets          = ["${aws_subnet.private_subnet_1.id}", "${aws_subnet.private_subnet_2.id}"]
  }

  task_definition = "${aws_ecs_task_definition.diyasylum-be.family}"

  load_balancer {
    target_group_arn = "${aws_lb_target_group.be-target-group.arn}"
    container_name   = "diyasylum-be"
    container_port   = "${var.backend_port}"
  }

  depends_on = ["aws_lb_listener.be-listener"]
}
