package com.diyasylum.formfiller.application.models;

import java.util.Objects;

public class Address {
  private final String streetName;
  private final String streetNumber;
  private final String apartmentNumber;
  private final String city;
  private final String state;
  private final String zipCode;
  private final String areaCode;
  private final String phoneNumber;

  public Address(
      String streetName,
      String streetNumber,
      String apartmentNumber,
      String city,
      String state,
      String zipCode,
      String areaCode,
      String phoneNumber) {
    this.streetName = streetName;
    this.streetNumber = streetNumber;
    this.apartmentNumber = apartmentNumber;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.areaCode = areaCode;
    this.phoneNumber = phoneNumber;
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
    return Objects.equals(streetName, address.streetName)
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
        streetName, streetNumber, apartmentNumber, city, state, zipCode, areaCode, phoneNumber);
  }

  @Override
  public String toString() {
    return "Address{"
        + "streetName='"
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
