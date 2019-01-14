package com.diyasylum.formfiller.application.models;

import java.util.Objects;

public class I589Application {

  private final ApplicantInfo applicantInfo;

  public I589Application(ApplicantInfo applicantInfo) {
    this.applicantInfo = applicantInfo;
  }

  public ApplicantInfo getApplicantInfo() {
    return applicantInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    I589Application that = (I589Application) o;
    return Objects.equals(applicantInfo, that.applicantInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicantInfo);
  }

  @Override
  public String toString() {
    return "I589Application{" + "applicantInfo=" + applicantInfo + '}';
  }
}
