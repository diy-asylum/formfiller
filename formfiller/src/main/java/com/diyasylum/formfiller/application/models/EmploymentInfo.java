package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class EmploymentInfo {
  private final String employerName;
  private final String employerAddress;
  private final String applicantOccupation;
  private final String fromDate; // mm/yyyy
  private final String toDate; // mm/yyyy

  @JsonCreator
  public EmploymentInfo(
      @JsonProperty("employerName") String employerName,
      @JsonProperty("employerAddress") String employerAddress,
      @JsonProperty("applicantOccupation") String applicantOccupation,
      @JsonProperty("fromDate") String fromDate,
      @JsonProperty("toDate") String toDate) {
    this.employerName = employerName;
    this.employerAddress = employerAddress;
    this.applicantOccupation = applicantOccupation;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public String getEmployerName() {
    return employerName;
  }

  public String getEmployerAddress() {
    return employerAddress;
  }

  public String getApplicantOccupation() {
    return applicantOccupation;
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
    EmploymentInfo that = (EmploymentInfo) o;
    return Objects.equals(employerName, that.employerName)
        && Objects.equals(employerAddress, that.employerAddress)
        && Objects.equals(applicantOccupation, that.applicantOccupation)
        && Objects.equals(toDate, that.toDate)
        && Objects.equals(fromDate, that.fromDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employerName, employerAddress, applicantOccupation, fromDate, toDate);
  }

  @Override
  public String toString() {
    return "EmploymentInfo{"
        + "employerName='"
        + employerName
        + '\''
        + ", employerAddress='"
        + employerAddress
        + '\''
        + ", applicantOccupation='"
        + applicantOccupation
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
