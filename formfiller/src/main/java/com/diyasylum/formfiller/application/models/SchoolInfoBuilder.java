package com.diyasylum.formfiller.application.models;

public class SchoolInfoBuilder {
  private String schoolName;
  private String typeOfSchool;
  private String address;
  private String fromDate; // mm/yyyy
  private String toDate; // mm/yyyy

  public SchoolInfoBuilder setSchoolName(String schoolName) {
    this.schoolName = schoolName;
    return this;
  }

  public SchoolInfoBuilder setTypeOfSchool(String typeOfSchool) {
    this.typeOfSchool = typeOfSchool;
    return this;
  }

  public SchoolInfoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public SchoolInfoBuilder setFromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  public SchoolInfoBuilder setToDate(String toDate) {
    this.toDate = toDate;
    return this;
  }

  public SchoolInfo createSchoolInfo() {
    return new SchoolInfo(schoolName, typeOfSchool, address, fromDate, toDate);
  }
}
