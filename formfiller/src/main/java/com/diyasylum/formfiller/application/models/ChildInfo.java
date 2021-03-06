package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

public class ChildInfo {
  private final String lastName;
  private final String firstName;
  private final String middleName;
  private final Gender gender;
  private final MaritalStatus maritalStatus;
  private final String dateOfBirth; // mm/dd/yyyy
  private final String cityOfBirth;
  private final String countryOfBirth;
  private final String nationality;
  private final String raceEthnicOrTribalGroup;
  private final Optional<String> alienRegistrationNumber;
  private final Optional<String> socialSecurityNumber;
  private final Optional<String> passportNumber;
  private final boolean inUS;
  private final Optional<String> location;
  private final Optional<String> placeOfLastEntry;
  private final Optional<String> dateOfLastEntry;
  private final Optional<String> i94Number;
  private final Optional<String> immigrationStatusWhenLastAdmitted;
  private final Optional<String> currentImmigrationStatus;
  private final Optional<String> statusExpirationDate; // mm/dd/yyyy
  private final Optional<Boolean> isInImmigrationCourt;
  private final Optional<Boolean> includeInApplication;

  @JsonCreator
  ChildInfo(
      @JsonProperty("alienRegistrationNumber") Optional<String> alienRegistrationNumber,
      @JsonProperty("socialSecurityNumber") Optional<String> socialSecurityNumber,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("middleName") String middleName,
      @JsonProperty("gender") Gender gender,
      @JsonProperty("maritalStatus") MaritalStatus maritalStatus,
      @JsonProperty("dateOfBirth") String dateOfBirth,
      @JsonProperty("cityOfBirth") String cityOfBirth,
      @JsonProperty("countryOfBirth") String countryOfBirth,
      @JsonProperty("nationality") String nationality,
      @JsonProperty("raceEthnicOrTribalGroup") String raceEthnicOrTribalGroup,
      @JsonProperty("passportNumber") Optional<String> passportNumber,
      @JsonProperty("inUS") boolean inUS,
      @JsonProperty("location") Optional<String> location,
      @JsonProperty("placeOfLastEntry") Optional<String> placeOfLastEntry,
      @JsonProperty("dateOfLastEntry") Optional<String> dateOfLastEntry,
      @JsonProperty("i94Number") Optional<String> i94Number,
      @JsonProperty("immigrationStatusWhenLastAdmitted")
          Optional<String> immigrationStatusWhenLastAdmitted,
      @JsonProperty("currentImmigrationStatus") Optional<String> currentImmigrationStatus,
      @JsonProperty("statusExpirationDate") Optional<String> statusExpirationDate,
      @JsonProperty("isInImmigrationCourt") Optional<Boolean> isInImmigrationCourt,
      @JsonProperty("includeInApplication") Optional<Boolean> includeInApplication) {
    this.alienRegistrationNumber = alienRegistrationNumber;
    this.socialSecurityNumber = socialSecurityNumber;
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
    this.dateOfBirth = dateOfBirth;
    this.cityOfBirth = cityOfBirth;
    this.countryOfBirth = countryOfBirth;
    this.nationality = nationality;
    this.raceEthnicOrTribalGroup = raceEthnicOrTribalGroup;
    this.passportNumber = passportNumber;
    this.inUS = inUS;
    this.location = location;
    this.placeOfLastEntry = placeOfLastEntry;
    this.dateOfLastEntry = dateOfLastEntry;
    this.i94Number = i94Number;
    this.immigrationStatusWhenLastAdmitted = immigrationStatusWhenLastAdmitted;
    this.currentImmigrationStatus = currentImmigrationStatus;
    this.statusExpirationDate = statusExpirationDate;
    this.isInImmigrationCourt = isInImmigrationCourt;
    this.includeInApplication = includeInApplication;
  }

  public Optional<String> getAlienRegistrationNumber() {
    return alienRegistrationNumber;
  }

  public Optional<String> getSocialSecurityNumber() {
    return socialSecurityNumber;
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

  public Optional<String> getPassportNumber() {
    return passportNumber;
  }

  public String getNationality() {
    return nationality;
  }

  public boolean getInUS() {
    return inUS;
  }

  public Optional<String> getLocation() {
    return location;
  }

  public Optional<String> getPlaceOfLastEntry() {
    return placeOfLastEntry;
  }

  public Optional<String> getDateOfLastEntry() {
    return dateOfLastEntry;
  }

  public Optional<String> getI94Number() {
    return i94Number;
  }

  public Optional<String> getImmigrationStatusWhenLastAdmitted() {
    return immigrationStatusWhenLastAdmitted;
  }

  public Optional<String> getCurrentImmigrationStatus() {
    return currentImmigrationStatus;
  }

  public Optional<String> getStatusExpirationDate() {
    return statusExpirationDate;
  }

  public Optional<Boolean> getIsInImmigrationCourt() {
    return isInImmigrationCourt;
  }

  public Optional<Boolean> getIncludeInApplication() {
    return includeInApplication;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChildInfo that = (ChildInfo) o;
    return Objects.equals(lastName, that.lastName)
        && Objects.equals(firstName, that.firstName)
        && Objects.equals(middleName, that.middleName)
        && gender == that.gender
        && maritalStatus == that.maritalStatus
        && Objects.equals(dateOfBirth, that.dateOfBirth)
        && Objects.equals(cityOfBirth, that.cityOfBirth)
        && Objects.equals(countryOfBirth, that.countryOfBirth)
        && Objects.equals(nationality, that.nationality)
        && Objects.equals(raceEthnicOrTribalGroup, that.raceEthnicOrTribalGroup)
        && Objects.equals(alienRegistrationNumber, that.alienRegistrationNumber)
        && Objects.equals(socialSecurityNumber, that.socialSecurityNumber)
        && Objects.equals(passportNumber, that.passportNumber)
        && inUS == that.inUS
        && Objects.equals(location, that.location)
        && Objects.equals(placeOfLastEntry, that.placeOfLastEntry)
        && Objects.equals(dateOfLastEntry, that.dateOfLastEntry)
        && Objects.equals(i94Number, that.i94Number)
        && Objects.equals(immigrationStatusWhenLastAdmitted, that.immigrationStatusWhenLastAdmitted)
        && Objects.equals(currentImmigrationStatus, that.currentImmigrationStatus)
        && Objects.equals(statusExpirationDate, that.statusExpirationDate)
        && Objects.equals(isInImmigrationCourt, that.isInImmigrationCourt)
        && Objects.equals(includeInApplication, that.includeInApplication);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        lastName,
        firstName,
        middleName,
        gender,
        maritalStatus,
        dateOfBirth,
        cityOfBirth,
        countryOfBirth,
        nationality,
        raceEthnicOrTribalGroup,
        alienRegistrationNumber,
        socialSecurityNumber,
        passportNumber,
        inUS,
        location,
        placeOfLastEntry,
        dateOfLastEntry,
        i94Number,
        immigrationStatusWhenLastAdmitted,
        currentImmigrationStatus,
        statusExpirationDate,
        isInImmigrationCourt,
        includeInApplication);
  }

  @Override
  public String toString() {
    return "ChildInfo{"
        + "lastName='"
        + lastName
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", middleName='"
        + middleName
        + '\''
        + ", gender="
        + gender
        + '\''
        + ", maritalStatus="
        + maritalStatus
        + '\''
        + ", dateOfBirth='"
        + dateOfBirth
        + '\''
        + ", cityOfBirth='"
        + cityOfBirth
        + '\''
        + ", countryOfBirth='"
        + countryOfBirth
        + '\''
        + ", nationality='"
        + nationality
        + '\''
        + ", raceEthnicOrTribalGroup='"
        + raceEthnicOrTribalGroup
        + '\''
        + ", alienRegistrationNumber='"
        + alienRegistrationNumber.orElseGet(() -> "None")
        + '\''
        + ", socialSecurityNumber='"
        + socialSecurityNumber.orElseGet(() -> "None")
        + '\''
        + ", passportNumber='"
        + passportNumber.orElseGet(() -> "None")
        + '\''
        + ", inUS='"
        + inUS
        + '\''
        + ", location='"
        + location.orElseGet(() -> "None")
        + '\''
        + ", placeOfLastEntry='"
        + placeOfLastEntry.orElseGet(() -> "None")
        + '\''
        + ", dateOfLastEntry='"
        + dateOfLastEntry.orElseGet(() -> "None")
        + '\''
        + ", i94Number='"
        + i94Number.orElseGet(() -> "None")
        + '\''
        + ", immigrationStatusWhenLastAdmitted='"
        + immigrationStatusWhenLastAdmitted.orElseGet(() -> "None")
        + '\''
        + ", currentImmigrationStatus='"
        + currentImmigrationStatus.orElseGet(() -> "None")
        + '\''
        + ", statusExpirationDate='"
        + statusExpirationDate.orElseGet(() -> "None")
        + '\''
        + ", isInImmigrationCourt='"
        + isInImmigrationCourt.orElseGet(() -> null)
        + '\''
        + ", includeInApplication='"
        + includeInApplication.orElseGet(() -> null)
        + '\''
        + '}';
  }
}
