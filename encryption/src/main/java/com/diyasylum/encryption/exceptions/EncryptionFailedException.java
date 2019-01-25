package com.diyasylum.encryption.exceptions;

public class EncryptionFailedException extends RuntimeException {
  public EncryptionFailedException(String errorMessage) {
    super(errorMessage);
  }
}
