package com.diyasylum.formfiller.i589;

import com.diyasylum.formfiller.application.models.I589Application;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.diyasylum.formfiller.mappings.i589.I589ApplicationMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;
import org.apache.pdfbox.text.PDFTextStripper;

// I think we could generalise this to just be a generic form filler
// which will nice when we build supplemental forms
public class I589Filler {
  static final String FORM_URL =
      "https://www.uscis.gov/system/files_force/files/form/i-589.pdf?download=1";
  static final String SUPPORTED_FORM_REVISION = "Form I-589 (Rev. 05/16/17) N";

  private final PDDocument i589Pdf;
  private final I589ApplicationMapper i589ApplicationMapper;

  public static I589Filler fromIncludedForm() throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    return I589Filler.fromi589PdfBytes(
        Objects.requireNonNull(classloader.getResourceAsStream("i-589.pdf")).readAllBytes());
  }

  static I589Filler fromPDDocument(PDDocument pdDocument) {
    return new I589Filler(pdDocument);
  }

  /**
   * Creates a filler based on a provided byte array representing a pdf calling this removes any
   * existing security on the document
   */
  static I589Filler fromi589PdfBytes(byte[] i589pdf) throws IOException {
    PDDocument pdDoc = PDDocument.load(i589pdf);
    pdDoc.setAllSecurityToBeRemoved(true);
    return new I589Filler(pdDoc);
  }

  private I589Filler(PDDocument i589pdf) {
    this.i589Pdf = i589pdf;
    this.i589ApplicationMapper = new I589ApplicationMapper();
  }

  /*
   I like the idea of the passed in document being immutable.
   So for filling in I would prefer to use a new document.
   If this proves stupid slow I can scrap the idea
  */
  private PDDocument cloneI589() throws IOException {
    ByteArrayOutputStream copyStream = new ByteArrayOutputStream();
    i589Pdf.save(copyStream);
    return PDDocument.load(copyStream.toByteArray());
  }

  /**
   * Method makes a best faith effort to fill in the form based on the fields provided. This
   * operation clears out the original security of the form
   *
   * @param fields list of I589 fields. Unrecognized fields will be ignored. Method will fill in any
   *     field it can.
   * @return byte[] with the contents of the form.
   * @throws IOException if there are problems working with the pdf
   */
  public byte[] fillInForm(List<I589Field> fields) throws IOException {
    return fillInForm(
        fields.stream().collect(Collectors.toMap(I589Field::getAbsolutePath, I589Field::getValue)));
  }

  public byte[] fillInForm(I589Application application) throws IOException {
    Map<String, String> fieldToValue =
        i589ApplicationMapper.getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(application)));
    return fillInForm(fieldToValue);
  }

  private byte[] fillInForm(Map<String, String> fieldToValue) throws IOException {
    PDDocument filledInForm = cloneI589();

    for (PDField pdField : filledInForm.getDocumentCatalog().getAcroForm().getFieldTree()) {
      if (fieldToValue.containsKey(pdField.getFullyQualifiedName())) {
        pdField.setValue(fieldToValue.get(pdField.getFullyQualifiedName()));
      }
    }

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    filledInForm.save(byteArrayOutputStream);
    filledInForm.close();
    return byteArrayOutputStream.toByteArray();
  }

  List<I589Field> extractFields() {
    List<I589Field> fields = new ArrayList<>();
    for (PDField pdField : i589Pdf.getDocumentCatalog().getAcroForm().getFieldTree()) {
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
