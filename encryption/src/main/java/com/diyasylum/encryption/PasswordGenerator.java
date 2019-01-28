package com.diyasylum.encryption;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.syncope.common.lib.SecureTextRandomProvider;

public class PasswordGenerator {

  private static char[][] range = {{'a', 'z'}, {'0', '9'}, {'A', 'Z'}};
  private static RandomStringGenerator generator =
      new RandomStringGenerator.Builder()
          .withinRange(range)
          .usingRandom(new SecureTextRandomProvider())
          .build();
  private static int passwordLength = 16;

  public static String getPassword() {
    return generator.generate(passwordLength);
  }
}
