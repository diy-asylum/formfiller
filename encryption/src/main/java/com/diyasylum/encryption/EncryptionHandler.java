package com.diyasylum.encryption;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.diyasylum.encryption.models.EncryptionPackage;
import com.diyasylum.encryption.models.UnencryptedMessage;

public class EncryptionHandler {

  public static EncryptionPackage handleEncryption(UnencryptedMessage message) {
    String password = PasswordGenerator.getPassword();
    SecretBox box = new SecretBox(password);
    EncryptedMessage encryptedMessage = box.encrypt(message.getMessage()).get();
    return new EncryptionPackage(encryptedMessage, password);
  }

  public static UnencryptedMessage handleDecryption(EncryptionPackage encryptionPackage) {
    String password = encryptionPackage.getPassword();
    EncryptedMessage encryptedMessage = encryptionPackage.getMessage();
    SecretBox box = new SecretBox(password);
    return new UnencryptedMessage(box.decrypt(encryptedMessage).get());
  }
}
