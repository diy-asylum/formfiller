package com.diyasylum.encryption;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.encryption.models.EncryptedMessage;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class secretBoxTest {

  @Test
  void encryptAndDecrypt() {
    SecretBox box = new SecretBox("the time has come");
    String secretMessage = "don't tell";
    Optional<EncryptedMessage> secret = box.encrypt(secretMessage);
    assertTrue(secret.isPresent(), "Message could not be encrypted.");
    Optional<String> decryptedMessage = box.decrypt(secret.get());
    assertTrue(decryptedMessage.isPresent(), "Message could not be decrypted.");
    assertEquals(decryptedMessage.get(), secretMessage);
  }

  @Test
  void decryptionFailsOnWrongPassword() {
    SecretBox box = new SecretBox("the walrus said");
    String secretMessage = "you have been locked out of your account";
    Optional<EncryptedMessage> secret = box.encrypt(secretMessage);
    assertTrue(secret.isPresent(), "Message could not be encrypted.");
    SecretBox hackBox = new SecretBox("to talk of many things");
    Optional<String> decryptedMessage = hackBox.decrypt(secret.get());
    assertFalse(decryptedMessage.isPresent(), "Message could be decrypted with wrong password.");
  }

  @Test
  void decryptionFailsOnWrongSalt() {
    SecretBox box = new SecretBox("to talk of many things");
    String secretMessage = "salty";
    Optional<EncryptedMessage> secret = box.encrypt(secretMessage);
    assertTrue(secret.isPresent(), "Message could not be encrypted.");
    EncryptedMessage trueSecret = secret.get();
    byte[] newSalt = trueSecret.getSalt();
    newSalt[0] = (byte) (newSalt[0] + (byte) 1);
    EncryptedMessage modifiedSecret =
        new EncryptedMessage(trueSecret.getEncryptedMessage(), newSalt, trueSecret.getNonce());
    Optional<String> decryptedMessage = box.decrypt(modifiedSecret);
    assertFalse(decryptedMessage.isPresent(), "Message could be decrypted with wrong salt.");
  }

  @Test
  void decryptionFailsOnWrongNonce() {
    SecretBox box = new SecretBox("of shoes and ships and sailing wax");
    String secretMessage = "nonce upon a time";
    Optional<EncryptedMessage> secret = box.encrypt(secretMessage);
    assertTrue(secret.isPresent(), "Message could not be encrypted.");
    EncryptedMessage trueSecret = secret.get();
    byte[] newNonce = trueSecret.getNonce();
    newNonce[0] = (byte) (newNonce[0] + (byte) 1);
    EncryptedMessage modifiedSecret =
        new EncryptedMessage(trueSecret.getEncryptedMessage(), trueSecret.getSalt(), newNonce);
    Optional<String> decryptedMessage = box.decrypt(modifiedSecret);
    assertFalse(decryptedMessage.isPresent(), "Message could be decrypted with wrong nonce.");
  }

  @Test
  void decryptionFailsOnModifiedInput() {
    SecretBox box = new SecretBox("of cabbages and kings");
    String secretMessage = "can't touch this";
    Optional<EncryptedMessage> secret = box.encrypt(secretMessage);
    assertTrue(secret.isPresent(), "Message could not be encrypted.");
    EncryptedMessage trueSecret = secret.get();
    byte[] newMessage = trueSecret.getEncryptedMessage();
    newMessage[0] = (byte) (newMessage[0] + (byte) 1);
    EncryptedMessage modifiedSecret =
        new EncryptedMessage(newMessage, trueSecret.getSalt(), trueSecret.getNonce());
    Optional<String> decryptedMessage = box.decrypt(modifiedSecret);
    assertFalse(decryptedMessage.isPresent(), "Message could be decrypted despite being modified.");
  }
}
