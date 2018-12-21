# formfiler
[![Build Status](https://travis-ci.org/diy-asylum/formfiller.svg?branch=master)](https://travis-ci.org/diy-asylum/formfiller)
[![Coverage Status](https://coveralls.io/repos/github/diy-asylum/formfiller/badge.svg?branch=master)](https://coveralls.io/github/diy-asylum/formfiller?branch=master)


the DIY asylum monorepo

Repo uses the gradle wrapper for its builds

While gradle is a tool that can be installed it is *highly* recommended to use the included
gradle wrapper. This will ensure you are running the right version of gradle.

## TLDR

Just make sure you run `./gradlew spotlessApply` before committing.
If you want to run the sever just run `./gradlew bootRun` which will run the server till you kill it with ctrl-c
If you want to build the command line app run `./gradlew shadowJar` and grab it from `formfiller/formfiller/build/libs/formfiller-1.0-SNAPSHOT-all.jar`

Any artifacts from builds are put in either the root `build` dir or the subprojects `build.dir`

## PR build

When a PR is made 3 checks are made

Travis Push
   Runs the build in the context of the branch
Travis PR
   Runs the build as if it was merged to master. Ensures a clean merge
Coveralls report
   Runs to verify coverage. Right now it should not fail until we decide on a threshold for failure for the project as a whole.
   Travis could fail since both java modules are expected to maintain at least 80% coverage
   

The travis build is defined in [The Travis config](.travis.yml) 

It will automatically see the gradle file and run the `check` task. This will run the
style enforcement checks, compile the java code, run npm install, run the java tests, run the js tests.

If all that passes it will then collect the coverage results for all the modules. Combine them, and upload them to coveralls.

If something goes wrong with the build (that is not an obvious test failure) your best bet is to view the output on travis.

[View PR builds](https://travis-ci.org/diy-asylum/formfiller)

In the output of the build a link will be posted to a detailed report on the build. 
This will go over in detail what the build did and how long each step took. Look for a url pointing to scans.gradle.com

For more information see [The Travis Docs](https://docs.travis-ci.com/user/languages/java/) and [The Coveralls Docs](https://docs.coveralls.io/)

## That's fine but what is all this gradle stuff

So this is a monorepo. Gradle is the glue that builds the project as one. We are using a gradle "multiproject" build To understand gradle better I suggest
[This](https://guides.gradle.org/building-java-applications/) and [This](https://guides.gradle.org/creating-multi-project-builds/)
 
Gradle is a vast and powerful system and im sure there is stuff thats not quite right in the build but lets walk though what we are trying to do.

The build has a root project and three subprojects. (formfiller, formserver, diy_asylum_frontend)

The root projects all have a `build.gradle` file. In addition some projects have a `settings.gradle` file which define what projects a
particular project depends on. For example: formserver declares formfiller as a dependency since formserver relies on formfiller to work with the pdf

[The root build.gradle](build.gradle) defines what is common to all the projects (Style, and how to run java tests). It also 
can drive all the subprojects if you desire. Run `./gradlew tasks` from the root project to see everything. 

```
------------------------------------------------------------
All tasks runnable from root project
------------------------------------------------------------

Application tasks
-----------------
bootRun - Runs this project as a Spring Boot application.

Build tasks
-----------
assemble - Assembles the outputs of this project.
bootJar - Assembles an executable jar archive containing the main classes and their dependencies.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
classes - Assembles main classes.
clean - Deletes the build directory.
jar - Assembles a jar archive containing the main classes.
testClasses - Assembles test classes.

Build scan tasks
----------------
buildScanPublishPrevious - Publishes the data captured by the last build to the build scan server.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Documentation tasks
-------------------
javadoc - Generates Javadoc API documentation for the main source code.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'diy_asylum'.
components - Displays the components produced by root project 'diy_asylum'. [incubating]
dependencies - Displays all dependencies declared in root project 'diy_asylum'.
dependencyInsight - Displays the insight into a specific dependency in root project 'diy_asylum'.
dependencyManagement - Displays the dependency management declared in project ':formserver'.
dependentComponents - Displays the dependent components of components in root project 'diy_asylum'. [incubating]
help - Displays a help message.
model - Displays the configuration model of root project 'diy_asylum'. [incubating]
projects - Displays the sub-projects of root project 'diy_asylum'.
properties - Displays the properties of root project 'diy_asylum'.
tasks - Displays the tasks runnable from root project 'diy_asylum' (some of the displayed tasks may belong to subprojects).

Shadow tasks
------------
knows - Do you know who knows?
shadowJar - Create a combined JAR of project and runtime dependencies

Verification tasks
------------------
check - Runs all checks.
jacocoTestCoverageVerification - Verifies code coverage metrics based on specified rules for the test task.
jacocoTestReport - Generates code coverage report for the test task.
spotlessApply - Applies code formatting steps to sourcecode in-place.
spotlessCheck - Checks that sourcecode satisfies formatting steps.
test - Runs the unit tests.

Rules
-----
Pattern: clean<TaskName>: Cleans the output files of a task.
Pattern: build<ConfigurationName>: Assembles the artifacts of a configuration.
Pattern: upload<ConfigurationName>: Assembles and uploads the artifacts belonging to a configuration.

To see all tasks and more detail, run gradlew tasks --all

To see more detail about a task, run gradlew help --task <task>
```

Each module has its own `build.gradle` defining information specific to that project.

If you don't understand a particular task just ask gradle. 

```
./gradlew help --task bootRun

> Task :help
Detailed task information for bootRun

Path
     :formserver:bootRun

Type
     BootRun (org.springframework.boot.gradle.tasks.run.BootRun)

Options
     --args     Command line arguments passed to the main class. [INCUBATING]

     --debug-jvm     Enable debugging for the process. The process is started suspended and listening on port 5005.

Description
     Runs this project as a Spring Boot application.

Group
     application

Deprecated Gradle features were used in this build, making it incompatible with Gradle 6.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/5.0/userguide/command_line_interface.html#sec:command_line_warnings
```

the `diy_asylum_frontend` is unique in that its JS. The build file simply 
defines a few tasks that run node commands and tells gradle when to run them. You are not required to use gradle
to work with the JS its just here for CI

