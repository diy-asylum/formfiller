package com.diyasylum.encryption;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.muquit.libsodiumjna.SodiumLibrary;
import com.muquit.libsodiumjna.exceptions.SodiumLibraryException;
import com.sun.jna.Platform;
import java.util.Optional;

public class SecretBox {
  private String password;

  public SecretBox(String password) {
    LibsodiumLibrary.initialize();
    this.password = password;
  }

  public Optional<EncryptedMessage> encrypt(String message) {
    try {
      byte[] salt = SodiumLibrary.randomBytes(SodiumLibrary.cryptoPwhashSaltBytes());
      byte[] key = SodiumLibrary.cryptoPwhashArgon2i(password.getBytes(), salt);
      byte[] nonce = SodiumLibrary.randomBytes(SodiumLibrary.cryptoBoxNonceBytes().intValue());
      byte[] encryptedMessage = SodiumLibrary.cryptoSecretBoxEasy(message.getBytes(), nonce, key);
      return Optional.of(new EncryptedMessage(encryptedMessage, salt, nonce));
    } catch (SodiumLibraryException e) {
      System.out.println("Sodium could not encrypt message.");
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public Optional<String> decrypt(EncryptedMessage encryptedMessage) {
    try {
      // TODO: Add input validation
      byte[] key =
          SodiumLibrary.cryptoPwhashArgon2i(password.getBytes(), encryptedMessage.getSalt());
      byte[] message =
          SodiumLibrary.cryptoSecretBoxOpenEasy(
              encryptedMessage.getEncryptedMessage(), encryptedMessage.getNonce(), key);
      return Optional.of(new String(message));
    } catch (SodiumLibraryException e) {
      System.out.println("Sodium could not decrypt message.");
      e.printStackTrace();
      return Optional.empty();
    }
  }
}

class LibsodiumLibrary {
  private static boolean isInitialized = false;

  private static void loadLibrary() {
    String libraryPath;
    if (Platform.isMac()) {
      libraryPath = "/usr/local/lib/libsodium.dylib";
    } else if (Platform.isWindows()) {
      libraryPath = "C:/libsodium/libsodium.dll";
    } else {
      libraryPath = "/usr/local/lib/libsodium.so";
    }

    SodiumLibrary.setLibraryPath(libraryPath);
  }

  public static void initialize() {
    if (!isInitialized) {
      loadLibrary();
      isInitialized = true;
    }
  }
}
