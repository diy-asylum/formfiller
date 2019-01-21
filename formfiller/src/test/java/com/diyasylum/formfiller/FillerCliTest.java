package com.diyasylum.formfiller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.diyasylum.formfiller.mappings.i589.I589ApplicationMapper;
import com.diyasylum.formfiller.pdfiller.PDFiller;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.TempDirectory;
import picocli.CommandLine;

class FillerCliTest {

  @Test
  @ExtendWith(TempDirectory.class)
  void run(@TempDirectory.TempDir Path tempDir) throws IOException {
    Path request = tempDir.resolve("request.json");
    FileWriter fileWriter = new FileWriter(request.toFile());
    ObjectMapper objectMapper = new ObjectMapper();
    fileWriter.write(objectMapper.writeValueAsString(TestUtils.exampleApplication()));
    fileWriter.close();

    Path resultingPdf = tempDir.resolve("output.pdf");
    PDFiller mockPDFiller = mock(PDFiller.class);
    when(mockPDFiller.fillInForm(
            eq(TestUtils.exampleApplication()), any(I589ApplicationMapper.class)))
        .thenReturn(
            "This test is not testing the filler itself. Just the pipes"
                .getBytes(StandardCharsets.UTF_8));
    CommandLine.run(new FillerCli(mockPDFiller), request.toString(), resultingPdf.toString());
  }
}
