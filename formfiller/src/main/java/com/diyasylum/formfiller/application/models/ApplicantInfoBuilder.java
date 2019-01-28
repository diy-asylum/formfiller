package com.diyasylum.formfiller.application.models;

import java.util.List;

public class ApplicantInfoBuilder {
  private boolean alsoApplyingConventionAgainstTorture;
  private String alienRegistrationNumber;
  private String socialSecurityNumber;
  private String usisAccountNumber;
  private String lastName;
  private String firstName;
  private String middleName;
  private List<String> aliases;
  private Address usResidence;
  private Address usMailingAddress;
  private Gender gender;
  private MaritalStatus maritalStatus;
  private String dateOfBirth;
  private String cityOfBirth;
  private String countryOfBirth;
  private String presentNationality;
  private String nationalityAtBirth;
  private String raceEthnicOrTribalGroup;
  private String religion;
  private ImmigrationCourtHistory immigrationCourtHistory;
  private String countryWhoLastIssuedPassport;
  private String passportNumber;
  private String travelDocumentNumber;
  private String travelDocumentExpirationDate;
  private String nativeLanguage;
  private boolean fluentInEnglish;
  private List<String> otherLanguages;

  public ApplicantInfoBuilder setAlsoApplyingConventionAgainstTorture(
      boolean alsoApplyingConventionAgainstTorture) {
    this.alsoApplyingConventionAgainstTorture = alsoApplyingConventionAgainstTorture;
    return this;
  }

  public ApplicantInfoBuilder setAlienRegistrationNumber(String alienRegistrationNumber) {
    this.alienRegistrationNumber = alienRegistrationNumber;
    return this;
  }

  public ApplicantInfoBuilder setSocialSecurityNumber(String socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
    return this;
  }

  public ApplicantInfoBuilder setUSISAccountNumber(String usisAccountNumber) {
    this.usisAccountNumber = usisAccountNumber;
    return this;
  }

  public ApplicantInfoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ApplicantInfoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ApplicantInfoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ApplicantInfoBuilder setAliases(List<String> aliases) {
    this.aliases = aliases;
    return this;
  }

  public ApplicantInfoBuilder setUsResidence(Address usResidence) {
    this.usResidence = usResidence;
    return this;
  }

  public ApplicantInfoBuilder setUsMailingAddress(Address usMailingAddress) {
    this.usMailingAddress = usMailingAddress;
    return this;
  }

  public ApplicantInfoBuilder setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public ApplicantInfoBuilder setMaritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  public ApplicantInfoBuilder setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public ApplicantInfoBuilder setCityOfBirth(String cityOfBirth) {
    this.cityOfBirth = cityOfBirth;
    return this;
  }

  public ApplicantInfoBuilder setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  public ApplicantInfoBuilder setPresentNationality(String presentNationality) {
    this.presentNationality = presentNationality;
    return this;
  }

  public ApplicantInfoBuilder setNationalityAtBirth(String nationalityAtBirth) {
    this.nationalityAtBirth = nationalityAtBirth;
    return this;
  }

  public ApplicantInfoBuilder setRaceEthnicOrTribalGroup(String raceEthnicOrTribalGroup) {
    this.raceEthnicOrTribalGroup = raceEthnicOrTribalGroup;
    return this;
  }

  public ApplicantInfoBuilder setReligion(String religion) {
    this.religion = religion;
    return this;
  }

  public ApplicantInfoBuilder setImmigrationCourtHistory(
      ImmigrationCourtHistory immigrationCourtHistory) {
    this.immigrationCourtHistory = immigrationCourtHistory;
    return this;
  }

  public ApplicantInfoBuilder setCountryWhoLastIssuedPassport(String countryWhoLastIssuedPassport) {
    this.countryWhoLastIssuedPassport = countryWhoLastIssuedPassport;
    return this;
  }

  public ApplicantInfoBuilder setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  public ApplicantInfoBuilder setTravelDocumentNumber(String travelDocumentNumber) {
    this.travelDocumentNumber = travelDocumentNumber;
    return this;
  }

  public ApplicantInfoBuilder setTravelDocumentExpirationDate(String travelDocumentExpirationDate) {
    this.travelDocumentExpirationDate = travelDocumentExpirationDate;
    return this;
  }

  public ApplicantInfoBuilder setNativeLanguage(String nativeLanguage) {
    this.nativeLanguage = nativeLanguage;
    return this;
  }

  public ApplicantInfoBuilder setFluentInEnglish(boolean fluentInEnglish) {
    this.fluentInEnglish = fluentInEnglish;
    return this;
  }

  public ApplicantInfoBuilder setOtherLanguages(List<String> otherLanguages) {
    this.otherLanguages = otherLanguages;
    return this;
  }

  public ApplicantInfo createApplicantInfo() {
    return new ApplicantInfo(
        alsoApplyingConventionAgainstTorture,
        alienRegistrationNumber,
        socialSecurityNumber,
        usisAccountNumber,
        lastName,
        firstName,
        middleName,
        aliases,
        usResidence,
        usMailingAddress,
        gender,
        maritalStatus,
        dateOfBirth,
        cityOfBirth,
        countryOfBirth,
        presentNationality,
        nationalityAtBirth,
        raceEthnicOrTribalGroup,
        religion,
        immigrationCourtHistory,
        countryWhoLastIssuedPassport,
        passportNumber,
        travelDocumentNumber,
        travelDocumentExpirationDate,
        nativeLanguage,
        fluentInEnglish,
        otherLanguages);
  }
}
