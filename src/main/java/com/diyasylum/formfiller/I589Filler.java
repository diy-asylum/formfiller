package com.diyasylum.formfiller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

class I589Filler {
  static final String FORM_URL =
      "https://www.uscis.gov/system/files_force/files/form/i-589.pdf?download=1";
  static final String SUPPORTED_FORM_REVISION = "Form I-589 (Rev. 05/16/17) N";

  private final PDDocument i589Pdf;

  static I589Filler fromi589PdfBytes(byte[] i589pdf) throws IOException {
    PDDocument pdDoc = PDDocument.load(i589pdf);
    return new I589Filler(pdDoc);
  }

  private I589Filler(PDDocument i589pdf) {
    this.i589Pdf = i589pdf;
  }

  Optional<String> extractRevisionDate() throws IOException {
    PDFTextStripper tStripper = new PDFTextStripper();
    String pdfFileInText = tStripper.getText(this.i589Pdf);
    return Arrays.stream(pdfFileInText.split("\n"))
        .filter(s -> s.startsWith("Form I-589 (Rev. "))
        .findFirst();
  }
}
