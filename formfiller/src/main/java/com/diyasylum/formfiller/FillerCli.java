package com.diyasylum.formfiller;

import com.diyasylum.formfiller.application.models.I589Application;
import com.diyasylum.formfiller.mappings.i589.I589ApplicationMapper;
import com.diyasylum.formfiller.pdfiller.PDFiller;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "Fill In i589", mixinStandardHelpOptions = true)
public class FillerCli implements Runnable {
  @Parameters(
    index = "0",
    paramLabel = "applicationJson",
    description = "the I589Application serialized as JSON"
  )
  private File applicationJson;

  @Parameters(index = "1", paramLabel = "outputPath", description = "Where to save the result")
  private String outputPath;

  private PDFiller formFiller;

  public FillerCli(PDFiller formFiller) {
    this.formFiller = formFiller;
  }

  public void run() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String json = Files.readString(applicationJson.toPath());
      I589Application i589Application = objectMapper.readValue(json, I589Application.class);
      byte[] result = formFiller.fillInForm(i589Application, new I589ApplicationMapper());
      Files.write(Paths.get(outputPath), result);
    } catch (IOException e) {
      System.out.println("Failed to fill in form");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    CommandLine.run(new FillerCli(PDFiller.fromIncludedForm()), args);
  }
}
