This module contains the code we use to encrypt and decrypt
people's data. We do not store the data ourselves but we allow
people to save their progress by encrypting the data they have filled in
and giving it to them as a file.

If you are developing this module or are using the server you
will need to install the libsodium library. You can follow [Their docs here](https://download.libsodium.org/doc/)

You can also try installing the library with the provided script. This script was intended for CI but it should work locally as well

From the root of the module. You may need root but try without it first

```bash
scripts/installLibSodium.sh
```
