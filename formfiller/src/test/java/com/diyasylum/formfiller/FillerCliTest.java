package com.diyasylum.formfiller;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.i589.FieldType;
import com.diyasylum.formfiller.i589.I589Field;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.TempDirectory;
import picocli.CommandLine;

class FillerCliTest {

  @Test
  @ExtendWith(TempDirectory.class)
  void run(@TempDirectory.TempDir Path tempDir) throws IOException {
    Path fields = tempDir.resolve("fields.json");
    FileWriter fileWriter = new FileWriter(fields.toFile());
    ObjectMapper objectMapper = new ObjectMapper();
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
                "ROBIN"));
    fileWriter.write(objectMapper.writeValueAsString(filledIn));
    fileWriter.close();

    Path result = tempDir.resolve("output.pdf");
    CommandLine.run(new FillerCli(), fields.toString(), result.toString());

    PDDocument document = PDDocument.load(result.toFile());
    assertEquals(
        "BATMAN",
        document
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[53]")
            .getValueAsString());
    assertEquals(
        "ROBIN",
        document
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[54]")
            .getValueAsString());
  }
}
