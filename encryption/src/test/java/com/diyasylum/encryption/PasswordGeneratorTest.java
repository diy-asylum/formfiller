package com.diyasylum.encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordGeneratorTest {

  @Test
  void passwordHasCorrectLength() {
    String password = PasswordGenerator.getPassword();
    assertEquals(password.length(), 16);
  }

  @Test
  void passwordUsesAlphanumericChars() {
    String password = PasswordGenerator.getPassword();
    String alphaNum = "[a-zA-Z0-9]".repeat(16);
    assertTrue(password.matches(alphaNum));
  }
}
