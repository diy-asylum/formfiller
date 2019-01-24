package com.diyasylum.encryption.exceptions;

public class DecryptionFailedException extends RuntimeException {
  public DecryptionFailedException(String errorMessage) {
    super(errorMessage);
  }
}
