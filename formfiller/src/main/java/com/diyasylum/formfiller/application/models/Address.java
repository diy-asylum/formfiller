package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Address {
  private final String inCareOf;
  private final String streetName;
  private final String streetNumber;
  private final String apartmentNumber;
  private final String city;
  private final String state;
  private final String zipCode;
  private final String areaCode;
  private final String phoneNumber;

  @JsonCreator
  public Address(
      @JsonProperty("inCareOf") String inCareOf,
      @JsonProperty("streetName") String streetName,
      @JsonProperty("streetNumber") String streetNumber,
      @JsonProperty("apartmentNumber") String apartmentNumber,
      @JsonProperty("city") String city,
      @JsonProperty("state") String state,
      @JsonProperty("zipCode") String zipCode,
      @JsonProperty("areaCode") String areaCode,
      @JsonProperty("phoneNumber") String phoneNumber) {
    this.inCareOf = inCareOf;
    this.streetName = streetName;
    this.streetNumber = streetNumber;
    this.apartmentNumber = apartmentNumber;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.areaCode = areaCode;
    this.phoneNumber = phoneNumber;
  }

  public String getInCareOf() {
    return inCareOf;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public String getApartmentNumber() {
    return apartmentNumber;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(inCareOf, address.inCareOf)
        && Objects.equals(streetName, address.streetName)
        && Objects.equals(streetNumber, address.streetNumber)
        && Objects.equals(apartmentNumber, address.apartmentNumber)
        && Objects.equals(city, address.city)
        && Objects.equals(state, address.state)
        && Objects.equals(zipCode, address.zipCode)
        && Objects.equals(areaCode, address.areaCode)
        && Objects.equals(phoneNumber, address.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        inCareOf,
        streetName,
        streetNumber,
        apartmentNumber,
        city,
        state,
        zipCode,
        areaCode,
        phoneNumber);
  }

  @Override
  public String toString() {
    return "Address{"
        + "inCareOf='"
        + inCareOf
        + '\''
        + ", streetName='"
        + streetName
        + '\''
        + ", streetNumber='"
        + streetNumber
        + '\''
        + ", apartmentNumber='"
        + apartmentNumber
        + '\''
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", zipCode='"
        + zipCode
        + '\''
        + ", areaCode='"
        + areaCode
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + '}';
  }
}
