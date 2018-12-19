package com.diyasylum.formfiller;

import com.diyasylum.formfiller.models.I589Field;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "Fill In i589", mixinStandardHelpOptions = true)
public class FillerCli implements Runnable {
  @Parameters(
    index = "0",
    paramLabel = "fieldsJson",
    description = "Json telling me what fields to fill in with what"
  )
  private File fieldsJson;

  @Parameters(index = "1", paramLabel = "outputPath", description = "Where to save the result")
  private String outputPath;

  public void run() {
    try {
      I589Filler i589Filler = I589Filler.fromIncludedForm();
      ObjectMapper objectMapper = new ObjectMapper();
      String json = Files.readString(fieldsJson.toPath());
      I589Field[] inputFields = objectMapper.readValue(json, I589Field[].class);
      byte[] result = i589Filler.fillInForm(Arrays.asList(inputFields));
      Files.write(Paths.get(outputPath), result);
    } catch (IOException e) {
      System.out.println("Failed to fill in form");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    CommandLine.run(new FillerCli(), args);
  }
}
