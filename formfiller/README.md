# formfiller CLI

This repo contains a CLI application which can provide a filled in I589 form.

It is where any logic involving the PDFs should live.

To create the jar first run

```bash
❯ ./gradlew shadowJar

BUILD SUCCESSFUL in 1s
3 actionable tasks: 1 executed, 2 up-to-date
```

this will create an independent executable for the app

```bash
❯ cd build/libs
❯ java -jar formfiller-1.0-SNAPSHOT-all.jar
Missing required parameters: fieldsJson, outputPath
Usage: Fill In i589 [-hV] fieldsJson outputPath
      fieldsJson   Json telling me what fields to fill in with what
      outputPath   Where to save the result
  -h, --help       Show this help message and exit.
  -V, --version    Print version information and exit.
```

Simply provide it two args. One pointing to a json file with the fields to fill
and another telling it what file to make for the new pdf

```bash
java -jar formfiller-1.0-SNAPSHOT-all.jar ~/Desktop/fields.json ./out.pdf
```

See /formfiller/formfiller/src/main/resources/fields.json

For a blank template check out [Fields.json](src/main/resources/fields.json). Not all fields
need to be there. The app will work with what its given.

There is a known gotcha around checkboxes. Only specific inputs will work. This is still
an alpha and we will improve and rework this over time.
