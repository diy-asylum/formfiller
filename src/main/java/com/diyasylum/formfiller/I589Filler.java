package com.diyasylum.formfiller;

import com.diyasylum.formfiller.models.I589Field;
import java.io.IOException;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;
import org.apache.pdfbox.text.PDFTextStripper;

class I589Filler {
  static final String FORM_URL =
      "https://www.uscis.gov/system/files_force/files/form/i-589.pdf?download=1";
  static final String SUPPORTED_FORM_REVISION = "Form I-589 (Rev. 05/16/17) N";

  private final PDDocument i589Pdf;

  static I589Filler fromPDDocument(PDDocument pdDocument) {
    return new I589Filler(pdDocument);
  }

  static I589Filler fromi589PdfBytes(byte[] i589pdf) throws IOException {
    PDDocument pdDoc = PDDocument.load(i589pdf);
    return new I589Filler(pdDoc);
  }

  private I589Filler(PDDocument i589pdf) {
    this.i589Pdf = i589pdf;
  }

  List<I589Field> extractFields() {
    List<I589Field> fields = new ArrayList<>();
    PDDocumentCatalog pdCatalog = i589Pdf.getDocumentCatalog();
    PDAcroForm pdAcroForm = pdCatalog.getAcroForm();
    for (PDField pdField : pdAcroForm.getFieldTree()) {
      if (pdField instanceof PDTerminalField) {
        fields.add(I589Field.fromPdField(pdField));
      }
    }
    return fields;
  }

  Optional<String> extractRevisionDate() throws IOException {
    PDFTextStripper tStripper = new PDFTextStripper();
    String pdfFileInText = tStripper.getText(this.i589Pdf);
    return Arrays.stream(pdfFileInText.split("\n"))
        .filter(s -> s.startsWith("Form I-589 (Rev. "))
        .findFirst();
  }
}
