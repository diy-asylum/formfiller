package com.diyasylum.formfiller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Objects;

public class Main {
  public static void main(String[] args) throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    I589Filler i589Filler =
        I589Filler.fromi589PdfBytes(
            Objects.requireNonNull(classloader.getResourceAsStream("i-589.pdf")).readAllBytes());
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(
        objectMapper
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(i589Filler.extractFields()));
  }
}
