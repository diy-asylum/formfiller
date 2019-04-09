package com.diyasylum.formfiller.application.models;

public class RelativeInfoBuilder {
  private String fullName;
  private String cityOrTownOfBirth;
  private String countryOfBirth;
  private String currentLocation;
  private boolean isDeceased; 

  public RelativeInfoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public RelativeInfoBuilder setCityOrTownOfBirth(String cityOrTownOfBirth) {
    this.cityOrTownOfBirth = cityOrTownOfBirth;
    return this;
  }

  public RelativeInfoBuilder setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  public RelativeInfoBuilder setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
    return this;
  }

  public RelativeInfoBuilder setIsDeceased(boolean isDeceased) {
    this.isDeceased = isDeceased;
    return this;
  }

  public RelativeInfo createRelativeInfo() {
    return new RelativeInfo(fullName, cityOrTownOfBirth, countryOfBirth, currentLocation, isDeceased);
  }
}

