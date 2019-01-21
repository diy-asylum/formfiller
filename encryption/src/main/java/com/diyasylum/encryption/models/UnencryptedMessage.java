package com.diyasylum.encryption.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnencryptedMessage {
  private String message;

  @JsonCreator
  public UnencryptedMessage(@JsonProperty("message") String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
