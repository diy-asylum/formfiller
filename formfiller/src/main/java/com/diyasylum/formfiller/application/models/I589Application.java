package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class I589Application {

  private final ApplicantInfo applicantInfo;
  private final UsTravelHistory usTravelHistory;

  @JsonCreator
  public I589Application(
      @JsonProperty("applicantInfo") ApplicantInfo applicantInfo,
      @JsonProperty("usTravelHistory") UsTravelHistory usTravelHistory) {
    this.applicantInfo = applicantInfo;
    this.usTravelHistory = usTravelHistory;
  }

  public ApplicantInfo getApplicantInfo() {
    return applicantInfo;
  }

  public UsTravelHistory getUsTravelHistory() {
    return usTravelHistory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    I589Application that = (I589Application) o;
    return Objects.equals(applicantInfo, that.applicantInfo)
        && Objects.equals(usTravelHistory, that.usTravelHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicantInfo, usTravelHistory);
  }

  @Override
  public String toString() {
    return "I589Application{"
        + "applicantInfo="
        + applicantInfo
        + ", usTravelHistory="
        + usTravelHistory
        + '}';
  }
}
