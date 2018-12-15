package com.diyasylum.formfiller;

import com.diyasylum.formfiller.models.FieldType;
import com.diyasylum.formfiller.models.I589Field;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

    List<I589Field> filledIn =
        Arrays.asList(
            new I589Field(
                "",
                "form1[0].#subform[4].TextField13[53]",
                "TextField13[53]",
                FieldType.TEXT,
                "BATMAN"),
            new I589Field(
                "",
                "form1[0].#subform[4].TextField13[54]",
                "TextField13[54]",
                FieldType.TEXT,
                "BATMAN"));
    try (FileOutputStream fos = new FileOutputStream("/users/Bachmann/Desktop/yes.pdf")) {
      fos.write(i589Filler.fillInForm(filledIn));
    }
  }
}
