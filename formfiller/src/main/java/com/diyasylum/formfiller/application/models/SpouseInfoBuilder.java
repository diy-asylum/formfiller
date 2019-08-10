package com.diyasylum.formfiller.application.models;

import java.util.List;
import java.util.Optional;

public class SpouseInfoBuilder {
  private String lastName;
  private String firstName;
  private String middleName;
  private List<String> aliases;
  private Optional<Gender> gender;
  private String dateOfMarriage;
  private String placeOfMarriage;
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
  private String placeOfLastEntry;
  private String dateOfLastEntry;
  private Optional<String> i94Number;
  private Optional<String> immigrationStatusWhenLastAdmitted;
  private String currentImmigrationStatus;
  private Optional<String> statusExpirationDate; // mm/dd/yyyy
  private boolean isInImmigrationCourt;
  private Optional<String> previousArrivalDate;
  private boolean includeInApplication;

  public SpouseInfoBuilder setAlienRegistrationNumber(Optional<String> alienRegistrationNumber) {
    this.alienRegistrationNumber = alienRegistrationNumber;
    return this;
  }

  public SpouseInfoBuilder setSocialSecurityNumber(Optional<String> socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
    return this;
  }

  public SpouseInfoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public SpouseInfoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public SpouseInfoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public SpouseInfoBuilder setAliases(List<String> aliases) {
    this.aliases = aliases;
    return this;
  }

  public SpouseInfoBuilder setGender(Optional<Gender> gender) {
    this.gender = gender;
    return this;
  }

  public SpouseInfoBuilder setDateOfMarriage(String dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
    return this;
  }

  public SpouseInfoBuilder setPlaceOfMarriage(String placeOfMarriage) {
    this.placeOfMarriage = placeOfMarriage;
    return this;
  }

  public SpouseInfoBuilder setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public SpouseInfoBuilder setCityOfBirth(String cityOfBirth) {
    this.cityOfBirth = cityOfBirth;
    return this;
  }

  public SpouseInfoBuilder setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  public SpouseInfoBuilder setNationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  public SpouseInfoBuilder setRaceEthnicOrTribalGroup(String raceEthnicOrTribalGroup) {
    this.raceEthnicOrTribalGroup = raceEthnicOrTribalGroup;
    return this;
  }

  public SpouseInfoBuilder setPassportNumber(Optional<String> passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  public SpouseInfoBuilder setInUS(boolean inUS) {
    this.inUS = inUS;
    return this;
  }

  public SpouseInfoBuilder setLocation(Optional<String> location) {
    this.location = location;
    return this;
  }

  public SpouseInfoBuilder setPlaceOfLastEntry(String placeOfLastEntry) {
    this.placeOfLastEntry = placeOfLastEntry;
    return this;
  }

  public SpouseInfoBuilder setDateOfLastEntry(String dateOfLastEntry) {
    this.dateOfLastEntry = dateOfLastEntry;
    return this;
  }

  public SpouseInfoBuilder setI94Number(Optional<String> i94Number) {
    this.i94Number = i94Number;
    return this;
  }

  public SpouseInfoBuilder setImmigrationStatusWhenLastAdmitted(
      Optional<String> immigrationStatusWhenLastAdmitted) {
    this.immigrationStatusWhenLastAdmitted = immigrationStatusWhenLastAdmitted;
    return this;
  }

  public SpouseInfoBuilder setCurrentImmigrationStatus(String currentImmigrationStatus) {
    this.currentImmigrationStatus = currentImmigrationStatus;
    return this;
  }

  public SpouseInfoBuilder setStatusExpirationDate(Optional<String> statusExpirationDate) {
    this.statusExpirationDate = statusExpirationDate;
    return this;
  }

  public SpouseInfoBuilder setIsInImmigrationCourt(boolean isInImmigrationCourt) {
    this.isInImmigrationCourt = isInImmigrationCourt;
    return this;
  }

  public SpouseInfoBuilder setPreviousArrivalDate(Optional<String> previousArrivalDate) {
    this.previousArrivalDate = previousArrivalDate;
    return this;
  }

  public SpouseInfoBuilder setIncludeInApplication(boolean includeInApplication) {
    this.includeInApplication = includeInApplication;
    return this;
  }

  public SpouseInfo createSpouseInfo() {
    return new SpouseInfo(
        alienRegistrationNumber,
        socialSecurityNumber,
        lastName,
        firstName,
        middleName,
        aliases,
        gender,
        dateOfMarriage,
        placeOfMarriage,
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
        previousArrivalDate,
        includeInApplication);
  }
}
