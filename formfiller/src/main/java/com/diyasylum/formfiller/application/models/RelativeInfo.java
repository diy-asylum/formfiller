package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class RelativeInfo {
  private final String fullName;
  private final String cityOrTownOfBirth;
  private final String countryOfBirth;
  private final String currentLocation;
  private final boolean isDeceased;

  @JsonCreator
  public RelativeInfo(
      @JsonProperty("fullName") String fullName,
      @JsonProperty("cityOrTownOfBirth") String cityOrTownOfBirth,
      @JsonProperty("countryOfBirth") String countryOfBirth,
      @JsonProperty("currentLocation") String currentLocation,
      @JsonProperty("isDeceased") boolean isDeceased) {
    this.cityOrTownOfBirth = cityOrTownOfBirth;
    this.fullName = fullName;
    this.countryOfBirth = countryOfBirth;
    this.currentLocation = currentLocation;
    this.isDeceased = isDeceased;
  }

  public String getFullName() {
    return fullName;
  }

  public String getCityOrTownOfBirth() {
    return cityOrTownOfBirth;
  }

  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public boolean getIsDeceased() {
    return isDeceased;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RelativeInfo that = (RelativeInfo) o;
    return Objects.equals(fullName, that.fullName)
        && Objects.equals(cityOrTownOfBirth, that.cityOrTownOfBirth)
        && Objects.equals(countryOfBirth, that.countryOfBirth)
        && Objects.equals(currentLocation, that.currentLocation)
        && isDeceased == that.isDeceased;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, cityOrTownOfBirth, countryOfBirth, currentLocation, isDeceased);
  }

  @Override
  public String toString() {
    return "RelativeInfo{"
        + "fullName='"
        + fullName 
        + '\''
        + ", cityOrTownOfBirth='"
        + cityOrTownOfBirth
        + '\''
        + ", countryOfBirth='"
        + countryOfBirth
        + '\''
        + ", currentLocation='"
        + currentLocation 
        + '\''
        + ", isDeceased='"
        + isDeceased 
        + '\''
        + '}';
  }
}

