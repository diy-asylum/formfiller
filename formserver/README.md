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

*Make sure you run this from the root of the monorepo as the dockerfile builds the jar*

```bash
docker build -t diyasylum/formserver -f formserver/Dockerfile .
docker run -p 8080:8080 -t diyasylum/formserver
```

You can test it by running the curl command from above

## Encryption endpoints

This module also contains endpoints for encryption and decryption of user state, so that they can safely save and resume their progress. The user state is sent as a string to the encryption endpoint, which generates a password for the user and encrypts their state using the password. A sample encryption request looks like:

```bash
curl -X POST localhost:8080/encryption/v1 -H "Content-Type: application/json" --data '{
        "message": "user state"
    }'
```

The user receives a payload which looks like:

```bash
{
   "message":{
      "encryptedMessage":"A4SqpsrYEf2a3XWdYQ5h3SukMZEQZWbd1VU=",
      "salt":"63zV+FGiXDCewU4BqSQgkg==",
      "nonce":"7KxHxQSmDlHdI2+tsZp5BpaZswKPayYx"
   },
   "password":"YdkNfIEro2aokq5l"
}
```

When the user wants to resume their progress, they can send this payload back to the decryption endpoint to recover their state:

```bash
curl -X POST localhost:8080/decryption/v1 -H "Content-Type: application/json" --data '{
   "message":{
      "encryptedMessage":"A4SqpsrYEf2a3XWdYQ5h3SukMZEQZWbd1VU=",
      "salt":"63zV+FGiXDCewU4BqSQgkg==",
      "nonce":"7KxHxQSmDlHdI2+tsZp5BpaZswKPayYx"
   },
   "password":"YdkNfIEro2aokq5l"
}'
```
