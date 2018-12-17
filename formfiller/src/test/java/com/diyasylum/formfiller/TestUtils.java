package com.diyasylum.formfiller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
  public static byte[] getCurrentFormFromResources() throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("i-589.pdf");
    assertNotNull(is);
    return is.readAllBytes();
  }
}
