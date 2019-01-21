package com.diyasylum.encryption.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

public class EncryptedMessage {
  private byte[] encryptedMessage;
  private byte[] salt;
  private byte[] nonce;

  @JsonCreator
  public EncryptedMessage(
      @JsonProperty("encryptedMessage") byte[] encryptedMessage,
      @JsonProperty("salt") byte[] salt,
      @JsonProperty("nonce") byte[] nonce) {
    this.encryptedMessage = encryptedMessage;
    this.salt = salt;
    this.nonce = nonce;
  }

  public byte[] getEncryptedMessage() {
    return encryptedMessage;
  }

  public byte[] getSalt() {
    return salt;
  }

  public byte[] getNonce() {
    return nonce;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EncryptedMessage message = (EncryptedMessage) o;
    return Arrays.equals(encryptedMessage, message.encryptedMessage)
        && Arrays.equals(salt, message.salt)
        && Arrays.equals(nonce, message.nonce);
  }
}
