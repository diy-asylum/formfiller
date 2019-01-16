package com.diyasylum.formfiller.application.models;

import java.util.Objects;
import java.util.Set;

public class ApplicantInfo {
  private final String lastName;
  private final String firstName;
  private final String middleName;
  private final Set<String> aliases;
  private final Address usResidence;
  private final Address usMailingAddress;
  private final Gender gender;
  private final MaritalStatus maritalStatus;
  private final String dateOfBirth; // mm/dd/yyyy
  private final String cityOfBirth;
  private final String countryOfBirth;
  private final String presentNationality;
  private final String nationalityAtBirth;
  private final String raceEthnicOrTribalGroup;
  private final String religion;
  private final String nativeLanguage;
  private final boolean fluentInEnglish;
  private final Set<String> otherLanguages;
  private final boolean alsoApplyingConventionAgainstTorture;
  private final String alienRegistrationNumber;
  private final String socialSecurityNumber;
  private final String USISAccountNumber;
  private final ImmigrationCourtHistory immigrationCourtHistory;
  private final String countryWhoLastIssuedPassport;
  private final String passportNumber;
  private final String travelDocumentNumber;
  private final String travelDocumentExpirationDate;

  ApplicantInfo(
      boolean alsoApplyingConventionAgainstTorture,
      String alienRegistrationNumber,
      String socialSecurityNumber,
      String USISAccountNumber,
      String lastName,
      String firstName,
      String middleName,
      Set<String> aliases,
      Address usResidence,
      Address usMailingAddress,
      Gender gender,
      MaritalStatus maritalStatus,
      String dateOfBirth,
      String cityOfBirth,
      String countryOfBirth,
      String presentNationality,
      String nationalityAtBirth,
      String raceEthnicOrTribalGroup,
      String religion,
      ImmigrationCourtHistory immigrationCourtHistory,
      String countryWhoLastIssuedPassport,
      String passportNumber,
      String travelDocumentNumber,
      String travelDocumentExpirationDate,
      String nativeLanguage,
      boolean fluentInEnglish,
      Set<String> otherLanguages) {
    this.alsoApplyingConventionAgainstTorture = alsoApplyingConventionAgainstTorture;
    this.alienRegistrationNumber = alienRegistrationNumber;
    this.socialSecurityNumber = socialSecurityNumber;
    this.USISAccountNumber = USISAccountNumber;
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.aliases = aliases;
    this.usResidence = usResidence;
    this.usMailingAddress = usMailingAddress;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
    this.dateOfBirth = dateOfBirth;
    this.cityOfBirth = cityOfBirth;
    this.countryOfBirth = countryOfBirth;
    this.presentNationality = presentNationality;
    this.nationalityAtBirth = nationalityAtBirth;
    this.raceEthnicOrTribalGroup = raceEthnicOrTribalGroup;
    this.religion = religion;
    this.immigrationCourtHistory = immigrationCourtHistory;
    this.countryWhoLastIssuedPassport = countryWhoLastIssuedPassport;
    this.passportNumber = passportNumber;
    this.travelDocumentNumber = travelDocumentNumber;
    this.travelDocumentExpirationDate = travelDocumentExpirationDate;
    this.nativeLanguage = nativeLanguage;
    this.fluentInEnglish = fluentInEnglish;
    this.otherLanguages = otherLanguages;
  }

  public boolean isAlsoApplyingConventionAgainstTorture() {
    return alsoApplyingConventionAgainstTorture;
  }

  public String getAlienRegistrationNumber() {
    return alienRegistrationNumber;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public String getUSISAccountNumber() {
    return USISAccountNumber;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public Set<String> getAliases() {
    return aliases;
  }

  public Address getUsResidence() {
    return usResidence;
  }

  public Address getUsMailingAddress() {
    return usMailingAddress;
  }

  public Gender getGender() {
    return gender;
  }

  public MaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getCityOfBirth() {
    return cityOfBirth;
  }

  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public String getRaceEthnicOrTribalGroup() {
    return raceEthnicOrTribalGroup;
  }

  public String getReligion() {
    return religion;
  }

  public ImmigrationCourtHistory getImmigrationCourtHistory() {
    return immigrationCourtHistory;
  }

  public String getCountryWhoLastIssuedPassport() {
    return countryWhoLastIssuedPassport;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public String getTravelDocumentNumber() {
    return travelDocumentNumber;
  }

  public String getTravelDocumentExpirationDate() {
    return travelDocumentExpirationDate;
  }

  public String getNativeLanguage() {
    return nativeLanguage;
  }

  public boolean isFluentInEnglish() {
    return fluentInEnglish;
  }

  public Set<String> getOtherLanguages() {
    return otherLanguages;
  }

  public String getPresentNationality() {
    return presentNationality;
  }

  public String getNationalityAtBirth() {
    return nationalityAtBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ApplicantInfo that = (ApplicantInfo) o;
    return fluentInEnglish == that.fluentInEnglish
        && alsoApplyingConventionAgainstTorture == that.alsoApplyingConventionAgainstTorture
        && Objects.equals(lastName, that.lastName)
        && Objects.equals(firstName, that.firstName)
        && Objects.equals(middleName, that.middleName)
        && Objects.equals(aliases, that.aliases)
        && Objects.equals(usResidence, that.usResidence)
        && Objects.equals(usMailingAddress, that.usMailingAddress)
        && gender == that.gender
        && maritalStatus == that.maritalStatus
        && Objects.equals(dateOfBirth, that.dateOfBirth)
        && Objects.equals(cityOfBirth, that.cityOfBirth)
        && Objects.equals(countryOfBirth, that.countryOfBirth)
        && Objects.equals(presentNationality, that.presentNationality)
        && Objects.equals(nationalityAtBirth, that.nationalityAtBirth)
        && Objects.equals(raceEthnicOrTribalGroup, that.raceEthnicOrTribalGroup)
        && Objects.equals(religion, that.religion)
        && Objects.equals(nativeLanguage, that.nativeLanguage)
        && Objects.equals(otherLanguages, that.otherLanguages)
        && Objects.equals(alienRegistrationNumber, that.alienRegistrationNumber)
        && Objects.equals(socialSecurityNumber, that.socialSecurityNumber)
        && Objects.equals(USISAccountNumber, that.USISAccountNumber)
        && immigrationCourtHistory == that.immigrationCourtHistory
        && Objects.equals(countryWhoLastIssuedPassport, that.countryWhoLastIssuedPassport)
        && Objects.equals(passportNumber, that.passportNumber)
        && Objects.equals(travelDocumentNumber, that.travelDocumentNumber)
        && Objects.equals(travelDocumentExpirationDate, that.travelDocumentExpirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
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
        nativeLanguage,
        fluentInEnglish,
        otherLanguages,
        alsoApplyingConventionAgainstTorture,
        alienRegistrationNumber,
        socialSecurityNumber,
        USISAccountNumber,
        immigrationCourtHistory,
        countryWhoLastIssuedPassport,
        passportNumber,
        travelDocumentNumber,
        travelDocumentExpirationDate);
  }

  @Override
  public String toString() {
    return "ApplicantInfo{"
        + "lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", middleName='"
        + middleName
        + '\''
        + ", aliases="
        + aliases
        + ", usResidence="
        + usResidence
        + ", usMailingAddress="
        + usMailingAddress
        + ", gender="
        + gender
        + ", maritalStatus="
        + maritalStatus
        + ", dateOfBirth='"
        + dateOfBirth
        + '\''
        + ", cityOfBirth='"
        + cityOfBirth
        + '\''
        + ", countryOfBirth='"
        + countryOfBirth
        + '\''
        + ", presentNationality='"
        + presentNationality
        + '\''
        + ", nationalityAtBirth='"
        + nationalityAtBirth
        + '\''
        + ", raceEthnicOrTribalGroup='"
        + raceEthnicOrTribalGroup
        + '\''
        + ", religion='"
        + religion
        + '\''
        + ", nativeLanguage='"
        + nativeLanguage
        + '\''
        + ", fluentInEnglish="
        + fluentInEnglish
        + ", otherLanguages="
        + otherLanguages
        + ", alsoApplyingConventionAgainstTorture="
        + alsoApplyingConventionAgainstTorture
        + ", alienRegistrationNumber='"
        + alienRegistrationNumber
        + '\''
        + ", socialSecurityNumber='"
        + socialSecurityNumber
        + '\''
        + ", USISAccountNumber='"
        + USISAccountNumber
        + '\''
        + ", immigrationCourtHistory="
        + immigrationCourtHistory
        + ", countryWhoLastIssuedPassport='"
        + countryWhoLastIssuedPassport
        + '\''
        + ", passportNumber='"
        + passportNumber
        + '\''
        + ", travelDocumentNumber='"
        + travelDocumentNumber
        + '\''
        + ", travelDocumentExpirationDate='"
        + travelDocumentExpirationDate
        + '\''
        + '}';
  }
}
