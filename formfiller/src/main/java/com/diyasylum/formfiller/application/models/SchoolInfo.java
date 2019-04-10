package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class SchoolInfo {
  private final String schoolName;
  private final String typeOfSchool;
  private final String address;
  private final String fromDate; // mm/yyyy
  private final String toDate; // mm/yyyy

  @JsonCreator
  public SchoolInfo(
      @JsonProperty("schoolName") String schoolName,
      @JsonProperty("typeOfSchool") String typeOfSchool,
      @JsonProperty("address") String address,
      @JsonProperty("fromDate") String fromDate,
      @JsonProperty("toDate") String toDate) {
    this.schoolName = schoolName;
    this.typeOfSchool = typeOfSchool;
    this.address = address;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public String getTypeOfSchool() {
    return typeOfSchool;
  }

  public String getAddress() {
    return address;
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
    SchoolInfo that = (SchoolInfo) o;
    return Objects.equals(schoolName, that.schoolName)
        && Objects.equals(typeOfSchool, that.typeOfSchool)
        && Objects.equals(address, that.address)
        && Objects.equals(toDate, that.toDate)
        && Objects.equals(fromDate, that.fromDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schoolName, typeOfSchool, address, fromDate, toDate);
  }

  @Override
  public String toString() {
    return "SchoolInfo{"
        + "schoolName='"
        + schoolName
        + '\''
        + ", typeOfSchool='"
        + typeOfSchool
        + '\''
        + ", address='"
        + address
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
