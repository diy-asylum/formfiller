package com.diyasylum.formfiller.i589;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.TestUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import com.diyasylum.formfiller.application.models.*;
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

  @Test
  void fillInFromModel() throws IOException {
    I589Filler filler = I589Filler.fromi589PdfBytes(TestUtils.getCurrentFormFromResources());
    // This is a nonsense application
    I589Application application = new I589Application(
            new ApplicantInfoBuilder()
                    .setAliases(Set.of("Spider-man"))
                    .setAlienRegistrationNumber("4234912")
                    .setAlsoApplyingConventionAgainstTorture(true)
                    .setCityOfBirth("Beijing")
                    .setCountryOfBirth("China")
                    .setCountryWhoLastIssuedPassport("China")
                    .setFirstName("Peter")
                    .setLastName("Parker")
                    .setDateOfBirth("8/10/1962")
                    .setFluentInEnglish(true)
                    .setGender(Gender.MALE)
                    .setImmigrationCourtHistory(ImmigrationCourtHistory.NEVER)
                    .setMiddleName("Benjamin")
                    .setMaritalStatus(MaritalStatus.MARRIED)
                    .setNationalityAtBirth("Chinese")
                    .setNativeLanguage("Chinese")
                    .setOtherLanguages(Set.of("English", "Spanish"))
                    .setPassportNumber("999999999")
                    .setPresentNationality("Chinese")
                    .setRaceEthnicOrTribalGroup("Asian")
                    .setUSISAccountNumber("A012345678")
                    .setReligion("Christian")
                    .setSocialSecurityNumber("234-22-1113")
                    .setTravelDocumentExpirationDate("12-12-9999")
                    .setTravelDocumentNumber("29312")
                    .setUsResidence(
                            new AddressBuilder()
                                    .setApartmentNumber("6")
                                    .setAreaCode("212")
                                    .setCity("New York")
                                    .setPhoneNumber("3230122")
                                    .setState("New York")
                                    .setStreetName("50th Street")
                                    .setStreetNumber("135 W.")
                                    .setZipCode("10020")
                            .createAddress()
                    )
                    .setUsMailingAddress(
                            new AddressBuilder()
                                    .setApartmentNumber("6")
                                    .setAreaCode("212")
                                    .setCity("New York")
                                    .setPhoneNumber("3230122")
                                    .setState("New York")
                                    .setStreetName("34th street")
                                    .setStreetNumber("7")
                                    .setInCareOf("May Parker")
                                    .setZipCode("10020")
                                    .createAddress()
                    )
                    .createApplicantInfo(),
            new UsTravelHistoryBuilder()
                    .setDateStatusExpires("12/12/2018")
                    .setI94Number("123456789 01")
                    .setDateStatusExpires("4/2/2022")
                    .setLastLeftHomeCountry("1/1/2018")
                    .setTravelEvents(Arrays.asList(
                            new UsTravelEventBuilder()
                                    .setDate("12/12/2015")
                                    .setPlace("New York")
                                    .setStatus("visitor").createUsTravelEvent(),
                            new UsTravelEventBuilder()
                                    .setDate("12/12/2016")
                                    .setPlace("New York")
                                    .setStatus("visitor").createUsTravelEvent(),
                            new UsTravelEventBuilder()
                                    .setDate("12/12/2017")
                                    .setPlace("New York")
                                    .setStatus("visitor").createUsTravelEvent()

                    ))
                    .createUsTravelHistory()
    );
    byte[] filled = filler.fillInForm(application);
  }
}
