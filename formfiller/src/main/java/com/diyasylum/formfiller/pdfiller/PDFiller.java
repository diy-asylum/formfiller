package com.diyasylum.formfiller.pdfiller;

import com.diyasylum.formfiller.application.models.I589Application;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;

public class PDFiller {
  private final PDDocument pdDocument;

  public static PDFiller fromIncludedForm() throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    return PDFiller.fromPdfBytes(
        Objects.requireNonNull(classloader.getResourceAsStream("i-589.pdf")).readAllBytes());
  }

  static PDFiller fromPDDocument(PDDocument pdDocument) {
    return new PDFiller(pdDocument);
  }

  /**
   * Creates a filler based on a provided byte array representing a pdf calling this removes any
   * existing security on the document
   */
  static PDFiller fromPdfBytes(byte[] pdfBytes) throws IOException {
    PDDocument pdDoc = PDDocument.load(pdfBytes);
    pdDoc.setAllSecurityToBeRemoved(true);
    return new PDFiller(pdDoc);
  }

  private PDFiller(PDDocument pdDocument) {
    this.pdDocument = pdDocument;
  }

  /*
   I like the idea of the passed in document being immutable.
   So for filling in I would prefer to use a new document.
   If this proves stupid slow I can scrap the idea
  */
  private PDDocument cloneDocument() throws IOException {
    ByteArrayOutputStream copyStream = new ByteArrayOutputStream();
    pdDocument.save(copyStream);
    return PDDocument.load(copyStream.toByteArray());
  }

  /**
   * Method makes a best faith effort to fill in the form based on the fields provided. This
   * operation clears out the original security of the form
   *
   * @param fields list of fields in the document. Unrecognized fields will be ignored. Method will
   *     fill in any field it can.
   * @return byte[] with the contents of the form.
   * @throws IOException if there are problems working with the pdf
   */
  public byte[] fillInForm(List<SimplePdField> fields) throws IOException {
    return fillInForm(
        fields
            .stream()
            .collect(Collectors.toMap(SimplePdField::getAbsolutePath, SimplePdField::getValue)));
  }

  // The generic here may make you think that this method is too specific. But my thinking is
  // any form be it the I589 or a supplemental form we make will (at its root) have a
  // Mapper<I589Application>
  // as that object represents all the data were provided by the user
  public byte[] fillInForm(I589Application application, AbstractMapper<I589Application> fieldMapper)
      throws IOException {
    Map<String, String> fieldToValue =
        fieldMapper
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(application)));
    return fillInForm(fieldToValue);
  }

  private byte[] fillInForm(Map<String, String> fieldToValue) throws IOException {
    PDDocument filledInForm = cloneDocument();

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

  List<SimplePdField> extractFields() {
    List<SimplePdField> fields = new ArrayList<>();
    for (PDField pdField : pdDocument.getDocumentCatalog().getAcroForm().getFieldTree()) {
      if (pdField instanceof PDTerminalField) {
        fields.add(SimplePdField.fromPdField(pdField));
      }
    }
    return fields;
  }
}
