package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class AddressWithDates {
  private final String streetName;
  private final String streetNumber;
  private final String cityOrTown;
  private final String departmentProvinceOrState;
  private final String country;
  private final String fromDate; // mm/yyyy
  private final String toDate; // mm/yyyy

  @JsonCreator
  public AddressWithDates(
      @JsonProperty("streetName") String streetName,
      @JsonProperty("streetNumber") String streetNumber,
      @JsonProperty("cityOrTown") String cityOrTown,
      @JsonProperty("departmentProvinceOrState") String departmentProvinceOrState,
      @JsonProperty("country") String country,
      @JsonProperty("fromDate") String fromDate,
      @JsonProperty("toDate") String toDate) {
    this.streetName = streetName;
    this.streetNumber = streetNumber;
    this.cityOrTown = cityOrTown;
    this.departmentProvinceOrState = departmentProvinceOrState;
    this.country = country;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public String getCityOrTown() {
    return cityOrTown;
  }

  public String getDepartmentProvinceOrState() {
    return departmentProvinceOrState;
  }

  public String getCountry() {
    return country;
  }

  public String getFromDate() {
    return fromDate;
  }

  public String getToDate() {
    return toDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddressWithDates that = (AddressWithDates) o;
    return Objects.equals(streetName, that.streetName)
        && Objects.equals(streetNumber, that.streetNumber)
        && Objects.equals(departmentProvinceOrState, that.departmentProvinceOrState)
        && Objects.equals(country, that.country)
        && Objects.equals(fromDate, that.fromDate)
        && Objects.equals(toDate, that.toDate)
        && Objects.equals(cityOrTown, that.cityOrTown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        streetName, streetNumber, cityOrTown, departmentProvinceOrState, country, fromDate, toDate);
  }

  @Override
  public String toString() {
    return "AddressWithDates{"
        + "streetName='"
        + streetName
        + '\''
        + ", streetNumber='"
        + streetNumber
        + '\''
        + ", cityOrTown='"
        + cityOrTown
        + '\''
        + ", departmentProvinceOrState='"
        + departmentProvinceOrState
        + '\''
        + ", country='"
        + country
        + '\''
        + ", fromDate='"
        + fromDate
        + '\''
        + ", toDate='"
        + toDate
        + '\''
        + '}';
  }
}
