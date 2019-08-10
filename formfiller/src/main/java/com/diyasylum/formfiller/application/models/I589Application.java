package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class I589Application {

  private final ApplicantInfo applicantInfo;
  private final UsTravelHistory usTravelHistory;
  private final Boolean isMarried;
  private final SpouseInfo spouseInfo;

  @JsonCreator
  public I589Application(
      @JsonProperty("applicantInfo") ApplicantInfo applicantInfo,
      @JsonProperty("usTravelHistory") UsTravelHistory usTravelHistory,
      @JsonProperty("isMarried") Boolean isMarried,
      @JsonProperty("spouseInfo") SpouseInfo spouseInfo) {
    this.applicantInfo = applicantInfo;
    this.usTravelHistory = usTravelHistory;
    this.isMarried = isMarried;
    this.spouseInfo = spouseInfo;
  }

  public ApplicantInfo getApplicantInfo() {
    return applicantInfo;
  }

  public UsTravelHistory getUsTravelHistory() {
    return usTravelHistory;
  }

  public Boolean getIsMarried() {
    return isMarried;
  }

  public SpouseInfo getSpouseInfo() {
    return spouseInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    I589Application that = (I589Application) o;
    return Objects.equals(applicantInfo, that.applicantInfo)
        && Objects.equals(usTravelHistory, that.usTravelHistory)
        && Objects.equals(isMarried, that.isMarried)
        && Objects.equals(spouseInfo, that.spouseInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicantInfo, usTravelHistory, isMarried, spouseInfo);
  }

  @Override
  public String toString() {
    return "I589Application{"
        + "applicantInfo="
        + applicantInfo
        + "isMarried="
        + isMarried
        + "spouseInfo="
        + spouseInfo
        + ", usTravelHistory="
        + usTravelHistory
        + '}';
  }
}
