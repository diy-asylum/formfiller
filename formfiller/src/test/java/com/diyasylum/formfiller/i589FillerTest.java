package com.diyasylum.formfiller;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.models.FieldType;
import com.diyasylum.formfiller.models.I589Field;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.*;
import org.junit.jupiter.api.Test;

class i589FillerTest {

  private byte[] getCurrentFormFromWebsite() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(I589Filler.FORM_URL)).build();
    HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
    assertEquals(200, response.statusCode());
    return response.body();
  }

  private PDDocument createForm() throws IOException {
    try (PDDocument document = new PDDocument()) {
      PDPage page = new PDPage(PDRectangle.A4);
      document.addPage(page);

      PDFont font = PDType1Font.HELVETICA;
      PDResources resources = new PDResources();
      resources.put(COSName.getPDFName("Helv"), font);

      PDAcroForm acroForm = new PDAcroForm(document);
      document.getDocumentCatalog().setAcroForm(acroForm);

      acroForm.setDefaultResources(resources);

      String defaultAppearanceString = "/Helv 0 Tf 0 g";
      acroForm.setDefaultAppearance(defaultAppearanceString);

      PDNonTerminalField group = new PDNonTerminalField(acroForm);
      group.setPartialName("Group");

      PDTextField textBox = new PDTextField(acroForm);
      textBox.setPartialName("field 1");
      textBox.setAlternateFieldName("Im such a field omg");

      PDButton button = new PDCheckBox(acroForm);
      button.setPartialName("button1");
      button.setAlternateFieldName("Im a button");

      group.setChildren(Arrays.asList(textBox, button));

      defaultAppearanceString = "/Helv 12 Tf 0 0 0 rg";
      textBox.setDefaultAppearance(defaultAppearanceString);
      acroForm.getFields().add(group);
      return document;
    }
  }

  @Test
  void assertVersionIsCurrent() throws IOException, InterruptedException {
    // This code is functionally useless if it is out of sync with the current form
    String savedPdfSha = DigestUtils.sha256Hex(TestUtils.getCurrentFormFromResources());
    byte[] downloadedPdf = getCurrentFormFromWebsite();
    String downloadedPdfSha = DigestUtils.sha256Hex(downloadedPdf);
    assertEquals(savedPdfSha, downloadedPdfSha, "The website checksum does not match!");
    Optional<String> extractedRevisionDate =
        I589Filler.fromi589PdfBytes(downloadedPdf).extractRevisionDate();
    assertTrue(extractedRevisionDate.isPresent(), "Could not find the revision date");
    assertEquals(I589Filler.SUPPORTED_FORM_REVISION, extractedRevisionDate.get());
  }

  @Test
  void testFieldExtraction() throws IOException {
    List<I589Field> expectedFields =
        Arrays.asList(
            new I589Field("Im such a field omg", "Group.field 1", "field 1", FieldType.TEXT, ""),
            new I589Field("Im a button", "Group.button1", "button1", FieldType.BUTTON, "Off"));
    I589Filler filler = I589Filler.fromPDDocument(createForm());
    assertEquals(expectedFields, filler.extractFields());
  }

  @Test
  void testFillingInDocument() throws IOException {
    I589Filler filler = I589Filler.fromi589PdfBytes(TestUtils.getCurrentFormFromResources());
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
    PDDocument result = PDDocument.load(filler.fillInForm(filledIn));
    assertEquals(
        "BATMAN",
        result
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[53]")
            .getValueAsString());
    assertEquals(
        "ROBIN",
        result
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[54]")
            .getValueAsString());

    // Pass in nothing to get the original doc to prove it was unModified
    PDDocument unFilled = PDDocument.load(filler.fillInForm(Collections.emptyList()));
    assertEquals(
        "",
        unFilled
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[53]")
            .getValueAsString());
    assertEquals(
        "",
        unFilled
            .getDocumentCatalog()
            .getAcroForm()
            .getField("form1[0].#subform[4].TextField13[54]")
            .getValueAsString());
  }
}