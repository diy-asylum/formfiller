package com.diyasylum.formfiller.application.models;

public class Address {
  private final String street;
  private final String apartmentNumber;
  private final String city;
  private final String state;
  private final String zipCode;
  private final String phoneNumber;

  public Address(
      String street,
      String apartmentNumber,
      String city,
      String state,
      String zipCode,
      String phoneNumber) {
    this.street = street;
    this.apartmentNumber = apartmentNumber;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.phoneNumber = phoneNumber;
  }

  public String getStreet() {
    return street;
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "Address{"
        + "street='"
        + street
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
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + '}';
  }
}
