package com.diyasylum.formfiller.application.models;

public class AddressWithDatesBuilder {
  private String streetName;
  private String streetNumber;
  private String cityOrTown;
  private String departmentProvinceOrState;
  private String country;
  private String fromDate; // mm/yyyy
  private String toDate; // mm/yyyy

  public AddressWithDatesBuilder setStreetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

  public AddressWithDatesBuilder setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  public AddressWithDatesBuilder setCityOrTown(String cityOrTown) {
    this.cityOrTown = cityOrTown;
    return this;
  }

  public AddressWithDatesBuilder setDepartmentProvinceOrState(String departmentProvinceOrState) {
    this.departmentProvinceOrState = departmentProvinceOrState;
    return this;
  }

  public AddressWithDatesBuilder setCountry(String country) {
    this.country = country;
    return this;
  }

  public AddressWithDatesBuilder setFromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  public AddressWithDatesBuilder setToDate(String toDate) {
    this.toDate = toDate;
    return this;
  }

  public AddressWithDates createAddressWithDates() {
    return new AddressWithDates(
        streetName, streetNumber, cityOrTown, departmentProvinceOrState, country, fromDate, toDate);
  }
}
