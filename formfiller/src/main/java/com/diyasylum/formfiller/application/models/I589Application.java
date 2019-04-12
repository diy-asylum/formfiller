package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class I589Application {

  private final ApplicantInfo applicantInfo;
  private final UsTravelHistory usTravelHistory;
  private final Optional<SpouseInfo> spouseInfo;
  private final List<ChildInfo> childInfo;
  private final AddressWithDates lastAddressBeforeUS;
  private final Optional<AddressWithDates> lastAddressPersecuted;
  private final List<AddressWithDates> residencesInLastFiveYears;
  private final List<SchoolInfo> educationInfo;
  private final List<EmploymentInfo> employmentInfo;
  private final RelativeInfo motherInfo;
  private final RelativeInfo fatherInfo;
  private final List<RelativeInfo> siblingInfo;
  private final List<WhyApplying> whyApplying;
  private final QuestionWithExplanation experiencedHarm;
  private final QuestionWithExplanation fearsHarm;
  private final QuestionWithExplanation arrestedInOtherCountry;
  private final OrganizationInfo organizationInfo;
  private final QuestionWithExplanation afraidOfTorture;
  private final QuestionWithExplanation relativeAppliedForAsylum;
  private final OtherCountryApplications otherCountryApplications;
  private final QuestionWithExplanation causedHarm;
  private final QuestionWithExplanation returnCountry;
  private final QuestionWithExplanation applyAfterOneYear;
  private final QuestionWithExplanation crimeInUS;
  private final RelativeHelpPrepare relativeHelpPrepare;

  @JsonCreator
  public I589Application(
      @JsonProperty("applicantInfo") ApplicantInfo applicantInfo,
      @JsonProperty("usTravelHistory") UsTravelHistory usTravelHistory,
      @JsonProperty("spouseInfo") Optional<SpouseInfo> spouseInfo,
      @JsonProperty("childInfo") List<ChildInfo> childInfo,
      @JsonProperty("lastAddressBeforeUS") AddressWithDates lastAddressBeforeUS,
      @JsonProperty("lastAddressPersecuted") Optional<AddressWithDates> lastAddressPersecuted,
      @JsonProperty("residencesInLastFiveYears") List<AddressWithDates> residencesInLastFiveYears,
      @JsonProperty("educationInfo") List<SchoolInfo> educationInfo,
      @JsonProperty("employmentInfo") List<EmploymentInfo> employmentInfo,
      @JsonProperty("motherInfo") RelativeInfo motherInfo,
      @JsonProperty("fatherInfo") RelativeInfo fatherInfo,
      @JsonProperty("siblingInfo") List<RelativeInfo> siblingInfo,
      @JsonProperty("whyApplying") List<WhyApplying> whyApplying,
      @JsonProperty("experiencedHarm") QuestionWithExplanation experiencedHarm,
      @JsonProperty("fearsHarm") QuestionWithExplanation fearsHarm,
      @JsonProperty("arrestedInOtherCountry") QuestionWithExplanation arrestedInOtherCountry,
      @JsonProperty("organizationInfo") OrganizationInfo organizationInfo,
      @JsonProperty("afraidOfTorture") QuestionWithExplanation afraidOfTorture,
      @JsonProperty("relativeAppliedForAsylum") QuestionWithExplanation relativeAppliedForAsylum,
      @JsonProperty("otherCountryApplications") OtherCountryApplications otherCountryApplications,
      @JsonProperty("cuasedHarm") QuestionWithExplanation causedHarm,
      @JsonProperty("returnCountry") QuestionWithExplanation returnCountry,
      @JsonProperty("applyAfterOneYear") QuestionWithExplanation applyAfterOneYear,
      @JsonProperty("crimeInUS") QuestionWithExplanation crimeInUS,
      @JsonProperty("relativeHelpPrepare") RelativeHelpPrepare relativeHelpPrepare) {
    this.applicantInfo = applicantInfo;
    this.usTravelHistory = usTravelHistory;
    this.spouseInfo = spouseInfo;
    this.childInfo = childInfo;
    this.lastAddressBeforeUS = lastAddressBeforeUS;
    this.lastAddressPersecuted = lastAddressPersecuted;
    this.residencesInLastFiveYears = residencesInLastFiveYears;
    this.educationInfo = educationInfo;
    this.employmentInfo = employmentInfo;
    this.motherInfo = motherInfo;
    this.fatherInfo = fatherInfo;
    this.siblingInfo = siblingInfo;
    this.whyApplying = whyApplying;
    this.experiencedHarm = experiencedHarm;
    this.fearsHarm = fearsHarm;
    this.arrestedInOtherCountry = arrestedInOtherCountry;
    this.organizationInfo = organizationInfo;
    this.afraidOfTorture = afraidOfTorture;
    this.relativeAppliedForAsylum = relativeAppliedForAsylum;
    this.otherCountryApplications = otherCountryApplications;
    this.causedHarm = causedHarm;
    this.returnCountry = returnCountry;
    this.applyAfterOneYear = applyAfterOneYear;
    this.crimeInUS = crimeInUS;
    this.relativeHelpPrepare = relativeHelpPrepare;
  }

  public ApplicantInfo getApplicantInfo() {
    return applicantInfo;
  }

  public UsTravelHistory getUsTravelHistory() {
    return usTravelHistory;
  }

  public Optional<SpouseInfo> getSpouseInfo() {
    return spouseInfo;
  }

  public List<ChildInfo> getChildInfo() {
    return childInfo;
  }

  public AddressWithDates getLastAddressBeforeUS() {
    return lastAddressBeforeUS;
  }

  public Optional<AddressWithDates> getLastAddressPersecuted() {
    return lastAddressPersecuted;
  }

  public List<AddressWithDates> getResidencesInLastFiveYears() {
    return residencesInLastFiveYears;
  }

  public List<SchoolInfo> getEducationInfo() {
    return educationInfo;
  }

  public List<EmploymentInfo> getEmploymentInfo() {
    return employmentInfo;
  }

  public RelativeInfo getMotherInfo() {
    return motherInfo;
  }

  public RelativeInfo getFatherInfo() {
    return fatherInfo;
  }

  public List<RelativeInfo> getSiblingInfo() {
    return siblingInfo;
  }

  public List<WhyApplying> getWhyApplying() {
    return whyApplying;
  }

  public QuestionWithExplanation getExperiencedHarm() {
    return experiencedHarm;
  }

  public QuestionWithExplanation getFearsHarm() {
    return fearsHarm;
  }

  public QuestionWithExplanation getArrestedInOtherCountry() {
    return arrestedInOtherCountry;
  }

  public OrganizationInfo getOrganizationInfo() {
    return organizationInfo;
  }

  public QuestionWithExplanation getAfraidOfTorture() {
    return afraidOfTorture;
  }

  public QuestionWithExplanation getRelativeAppliedForAsylum() {
    return relativeAppliedForAsylum;
  }

  public OtherCountryApplications getOtherCountryApplications() {
    return otherCountryApplications;
  }

  public QuestionWithExplanation getCausedHarm() {
    return causedHarm;
  }

  public QuestionWithExplanation getReturnCountry() {
    return returnCountry;
  }

  public QuestionWithExplanation getApplyAfterOneYear() {
    return applyAfterOneYear;
  }

  public QuestionWithExplanation getCrimeInUS() {
    return crimeInUS;
  }

  public RelativeHelpPrepare getRelativeHelpPrepare() {
    return relativeHelpPrepare;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    I589Application that = (I589Application) o;
    return Objects.equals(applicantInfo, that.applicantInfo)
        && Objects.equals(usTravelHistory, that.usTravelHistory)
        && Objects.equals(spouseInfo, that.spouseInfo)
        && Objects.equals(childInfo, that.childInfo)
        && Objects.equals(lastAddressBeforeUS, that.lastAddressBeforeUS)
        && Objects.equals(lastAddressPersecuted, that.lastAddressPersecuted)
        && Objects.equals(residencesInLastFiveYears, that.residencesInLastFiveYears)
        && Objects.equals(educationInfo, that.educationInfo)
        && Objects.equals(employmentInfo, that.employmentInfo)
        && Objects.equals(motherInfo, that.motherInfo)
        && Objects.equals(fatherInfo, that.fatherInfo)
        && Objects.equals(siblingInfo, that.siblingInfo)
        && Objects.equals(whyApplying, that.whyApplying)
        && Objects.equals(experiencedHarm, that.experiencedHarm)
        && Objects.equals(fearsHarm, that.fearsHarm)
        && Objects.equals(arrestedInOtherCountry, that.arrestedInOtherCountry)
        && Objects.equals(organizationInfo, that.organizationInfo)
        && Objects.equals(afraidOfTorture, that.afraidOfTorture)
        && Objects.equals(relativeAppliedForAsylum, that.relativeAppliedForAsylum)
        && Objects.equals(otherCountryApplications, that.otherCountryApplications)
        && Objects.equals(causedHarm, that.causedHarm)
        && Objects.equals(returnCountry, that.returnCountry)
        && Objects.equals(applyAfterOneYear, that.applyAfterOneYear)
        && Objects.equals(crimeInUS, that.crimeInUS)
        && Objects.equals(relativeHelpPrepare, that.relativeHelpPrepare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        applicantInfo,
        usTravelHistory,
        spouseInfo,
        childInfo,
        lastAddressBeforeUS,
        lastAddressPersecuted,
        residencesInLastFiveYears,
        educationInfo,
        employmentInfo,
        motherInfo,
        fatherInfo,
        siblingInfo,
        whyApplying,
        experiencedHarm,
        fearsHarm,
        arrestedInOtherCountry,
        organizationInfo,
        afraidOfTorture,
        relativeAppliedForAsylum,
        otherCountryApplications,
        causedHarm,
        returnCountry,
        applyAfterOneYear,
        crimeInUS,
        relativeHelpPrepare);
  }

  @Override
  public String toString() {
    return "I589Application{"
        + "applicantInfo="
        + applicantInfo
        + ", usTravelHistory="
        + usTravelHistory
        + ", spouseInfo="
        + spouseInfo
        + ", childInfo="
        + childInfo
        + ", lastAddressBeforeUS="
        + lastAddressBeforeUS
        + ", lastAddressPersecuted="
        + lastAddressPersecuted
        + ", residencesInLastFiveYears="
        + residencesInLastFiveYears
        + ", educationInfo="
        + educationInfo
        + ", employmentInfo="
        + employmentInfo
        + ", motherInfo="
        + motherInfo
        + ", fatherInfo="
        + fatherInfo
        + ", siblingInfo="
        + siblingInfo
        + ", whyApplying="
        + whyApplying
        + ", experiencedHarm="
        + experiencedHarm
        + ", fearsHarm="
        + fearsHarm
        + ", arrestedInOtherCountry="
        + arrestedInOtherCountry
        + ", organizationInfo="
        + organizationInfo
        + ", afraidOfTorture="
        + afraidOfTorture
        + ", relativeAppliedForAsylum="
        + relativeAppliedForAsylum
        + ", otherCountryApplications="
        + otherCountryApplications
        + ", causedHarm="
        + causedHarm
        + ", returnCountry="
        + returnCountry
        + ", applyAfterOneYear="
        + applyAfterOneYear
        + ", crimeInUS="
        + crimeInUS
        + ", relativeHelpPrepare="
        + relativeHelpPrepare
        + '}';
  }
}
