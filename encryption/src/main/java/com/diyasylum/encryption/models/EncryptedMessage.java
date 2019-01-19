package com.diyasylum.encryption.models;

public class EncryptedMessage {
  private byte[] encryptedMessage;
  private byte[] salt;
  private byte[] nonce;

  public EncryptedMessage(byte[] encryptedMessage, byte[] salt, byte[] nonce) {
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
}
