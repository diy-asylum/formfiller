# formfiler Server

This module contains the spring boot server for the application.

Its job is to accept requests, validate them and then pass them to the formfiller module to fill
in the final document.

Business logic involving the PDF should **Not** live in this module.

To start the server simply run this from the root of the repo

```bash
./gradlew :formserver:bootRun
```

This command will not "complete" until you ctrl-c so dont wait for the progress bar.

If you are using an IDE like intellij simply run the FormServerApplication Main method

Here is an example request

The example request assumes you have a file in your current directory `data.json` which contains the data
to use to fill in the file. This is a jackson serialized I589Application object.

An example `data.json` is in /formfiller/src/test/resources/data.json

```bash
curl -X POST localhost:8080/i589/fill-H "Content-Type: application/json" --data '@data.json' > test.pdf
```

This will fill in one field of the pdf with the text batman and pipe the result into a file

## building and running the dockerfile

This module includes a dockerfile for its deployment. You can build and run the server with the following commands

```bash
./gradlew :formserver:build :formserver:docker
docker run -p 8080:8080 -t diyasylum/formserver
```

You can test it by running the curl command from above
