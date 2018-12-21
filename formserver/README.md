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

Right now the api is very raw (see the formfiller module for details). However, here is an example request

```bash
curl -X POST localhost:8080/i589/fillraw -H "Content-Type: application/json" --data '[{
        "description": "Part. A. 1. Information About You. 2. Enter U. S. Social Security Number, if any.",
        "absolutePath": "form1[0].#subform[0].TextField1[0]",
        "relativePath": "TextField1[0]",
        "fieldType": "TEXT",
        "value": "Batman"
    }]' > test.pdf
```

This will fill in one field of the pdf with the text batman and pipe the result into a file
