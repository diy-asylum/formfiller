package com.diyasylum.formfiller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.diyasylum.formfiller.application.models.*;
import java.io.*;
import java.util.*;

public class TestUtils {
  public static I589Application exampleApplication() {
    // This is a nonsense application. Mostly designed to fill in every field
    return new I589Application(
        new ApplicantInfoBuilder()
            .setAliases(List.of("Spider-man"))
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
            .setOtherLanguages(Arrays.asList("English", "Spanish"))
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
                    .createAddress())
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
                    .createAddress())
            .createApplicantInfo(),
        new UsTravelHistoryBuilder()
            .setDateStatusExpires("12/12/2018")
            .setI94Number("123456789 01")
            .setDateStatusExpires("4/2/2022")
            .setLastLeftHomeCountry("1/1/2018")
            .setTravelEvents(
                Arrays.asList(
                    new UsTravelEventBuilder()
                        .setDate("12/12/2015")
                        .setPlace("New York")
                        .setStatus("visitor")
                        .createUsTravelEvent(),
                    new UsTravelEventBuilder()
                        .setDate("12/12/2016")
                        .setPlace("New York")
                        .setStatus("visitor")
                        .createUsTravelEvent(),
                    new UsTravelEventBuilder()
                        .setDate("12/12/2017")
                        .setPlace("New York")
                        .setStatus("visitor")
                        .createUsTravelEvent()))
            .createUsTravelHistory());
  }

  public static byte[] getCurrenti589FormFromResources() throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("i-589.pdf");
    assertNotNull(is);
    return is.readAllBytes();
  }

  /** @param filename filename for a resource that is a TSV with no headers */
  public static Map<String, String> loadMapFromTSVInResources(String filename) throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    BufferedReader reader =
        new BufferedReader(
            new InputStreamReader(
                Objects.requireNonNull(classloader.getResourceAsStream(filename))));
    String line;
    String[] parts;
    Map<String, String> result = new HashMap<>();
    while ((line = reader.readLine()) != null) {
      parts = line.split("\t");
      String value = parts.length > 1 ? parts[1] : "";
      result.put(parts[0], value);
    }
    return result;
  }
}
