# formfiler
Mostly a spike repo for experimenting with filling in Asylum forms


Repo uses the gradle wrapper for its builds

To build and run the tests simply use the included wrapper script

```bash
./gradlew check
```

This will build the project, run its tests, and verify the coverage for you.

This repo is configured to enforce Google's code style. I did not pick it for any particular reason.
I mostly dont like having to think or argue about code style. Spotless will fail anything that does
not conform to the style, it can also reformat your code automatically.
