package com.diyasylum.formfiller.application.models;

import java.util.Optional;

public class ChildInfoBuilder {
  private String lastName;
  private String firstName;
  private String middleName;
  private Gender gender;
  private MaritalStatus maritalStatus;
  private String dateOfBirth; // mm/dd/yyyy
  private String cityOfBirth;
  private String countryOfBirth;
  private String nationality;
  private String raceEthnicOrTribalGroup;
  private Optional<String> alienRegistrationNumber;
  private Optional<String> socialSecurityNumber;
  private Optional<String> passportNumber;
  private boolean inUS;
  private Optional<String> location;
  private Optional<String> placeOfLastEntry;
  private Optional<String> dateOfLastEntry;
  private Optional<String> i94Number;
  private Optional<String> immigrationStatusWhenLastAdmitted;
  private Optional<String> currentImmigrationStatus;
  private Optional<String> statusExpirationDate; // mm/dd/yyyy
  private Optional<Boolean> isInImmigrationCourt;
  private Optional<Boolean> includeInApplication;

  public ChildInfoBuilder setAlienRegistrationNumber(Optional<String> alienRegistrationNumber) {
    this.alienRegistrationNumber = alienRegistrationNumber;
    return this;
  }

  public ChildInfoBuilder setSocialSecurityNumber(Optional<String> socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
    return this;
  }

  public ChildInfoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ChildInfoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ChildInfoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ChildInfoBuilder setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public ChildInfoBuilder setMaritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  public ChildInfoBuilder setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public ChildInfoBuilder setCityOfBirth(String cityOfBirth) {
    this.cityOfBirth = cityOfBirth;
    return this;
  }

  public ChildInfoBuilder setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  public ChildInfoBuilder setNationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  public ChildInfoBuilder setRaceEthnicOrTribalGroup(String raceEthnicOrTribalGroup) {
    this.raceEthnicOrTribalGroup = raceEthnicOrTribalGroup;
    return this;
  }

  public ChildInfoBuilder setPassportNumber(Optional<String> passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  public ChildInfoBuilder setInUS(boolean inUS) {
    this.inUS = inUS;
    return this;
  }

  public ChildInfoBuilder setLocation(Optional<String> location) {
    this.location = location;
    return this;
  }

  public ChildInfoBuilder setPlaceOfLastEntry(Optional<String> placeOfLastEntry) {
    this.placeOfLastEntry = placeOfLastEntry;
    return this;
  }

  public ChildInfoBuilder setDateOfLastEntry(Optional<String> dateOfLastEntry) {
    this.dateOfLastEntry = dateOfLastEntry;
    return this;
  }

  public ChildInfoBuilder setI94Number(Optional<String> i94Number) {
    this.i94Number = i94Number;
    return this;
  }

  public ChildInfoBuilder setImmigrationStatusWhenLastAdmitted(
      Optional<String> immigrationStatusWhenLastAdmitted) {
    this.immigrationStatusWhenLastAdmitted = immigrationStatusWhenLastAdmitted;
    return this;
  }

  public ChildInfoBuilder setCurrentImmigrationStatus(Optional<String> currentImmigrationStatus) {
    this.currentImmigrationStatus = currentImmigrationStatus;
    return this;
  }

  public ChildInfoBuilder setStatusExpirationDate(Optional<String> statusExpirationDate) {
    this.statusExpirationDate = statusExpirationDate;
    return this;
  }

  public ChildInfoBuilder setIsInImmigrationCourt(Optional<Boolean> isInImmigrationCourt) {
    this.isInImmigrationCourt = isInImmigrationCourt;
    return this;
  }

  public ChildInfoBuilder setIncludeInApplication(Optional<Boolean> includeInApplication) {
    this.includeInApplication = includeInApplication;
    return this;
  }

  public ChildInfo createChildInfo() {
    return new ChildInfo(
        alienRegistrationNumber,
        socialSecurityNumber,
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
}
