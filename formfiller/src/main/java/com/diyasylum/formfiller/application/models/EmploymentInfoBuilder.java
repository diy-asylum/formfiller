package com.diyasylum.formfiller.application.models;

public class EmploymentInfoBuilder {
  private String employerName;
  private String employerAddress;
  private String applicantOccupation;
  private String fromDate; // mm/yyyy
  private String toDate; // mm/yyyy

  public EmploymentInfoBuilder setEmployerName(String employerName) {
    this.employerName = employerName;
    return this;
  }

  public EmploymentInfoBuilder setEmployerAddress(String employerAddress) {
    this.employerAddress = employerAddress;
    return this;
  }

  public EmploymentInfoBuilder setApplicantOccupation(String applicantOccupation) {
    this.applicantOccupation = applicantOccupation;
    return this;
  }

  public EmploymentInfoBuilder setFromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  public EmploymentInfoBuilder setToDate(String toDate) {
    this.toDate = toDate;
    return this;
  }

  public EmploymentInfo createEmploymentInfo() {
    return new EmploymentInfo(employerName, employerAddress, applicantOccupation, fromDate, toDate);
  }
}
