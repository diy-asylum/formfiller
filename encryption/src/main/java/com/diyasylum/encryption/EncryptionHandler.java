package com.diyasylum.encryption;

import com.diyasylum.encryption.exceptions.DecryptionFailedException;
import com.diyasylum.encryption.exceptions.EncryptionFailedException;
import com.diyasylum.encryption.models.EncryptedMessage;
import com.diyasylum.encryption.models.EncryptionPackage;
import com.diyasylum.encryption.models.UnencryptedMessage;
import java.util.Optional;

public class EncryptionHandler {
  // Is there a better way to handle missing values here / propagate errors?
  public static EncryptionPackage handleEncryption(UnencryptedMessage message)
      throws EncryptionFailedException {
    String password = PasswordGenerator.getPassword();
    SecretBox box = new SecretBox(password);
    Optional<EncryptedMessage> encryptedMessage = box.encrypt(message.getMessage());
    if (!encryptedMessage.isPresent()) {
      throw new EncryptionFailedException("Encryption failed.");
    }
    return new EncryptionPackage(encryptedMessage.get(), password);
  }

  public static UnencryptedMessage handleDecryption(EncryptionPackage encryptionPackage)
      throws DecryptionFailedException {
    String password = encryptionPackage.getPassword();
    EncryptedMessage encryptedMessage = encryptionPackage.getMessage();
    SecretBox box = new SecretBox(password);
    Optional<String> decryptedMessage = box.decrypt(encryptedMessage);
    if (!decryptedMessage.isPresent()) {
      throw new DecryptionFailedException("Decryption failed.");
    }
    return new UnencryptedMessage(decryptedMessage.get());
  }
}
