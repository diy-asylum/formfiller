package com.diyasylum.encryption.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptionPackage {
  private EncryptedMessage message;
  private String password;

  @JsonCreator
  public EncryptionPackage(
      @JsonProperty("message") EncryptedMessage message,
      @JsonProperty("password") String password) {
    this.message = message;
    this.password = password;
  }

  public EncryptedMessage getMessage() {
    return message;
  }

  public String getPassword() {
    return password;
  }
}
