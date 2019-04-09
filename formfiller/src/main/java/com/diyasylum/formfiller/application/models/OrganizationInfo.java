package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

public class OrganizationInfo {
  private final QuestionWithExplanation associatedWithOrganizations;
  private final Optional<QuestionWithExplanation> continueToParticipate;

  @JsonCreator
  public OrganizationInfo(
      @JsonProperty("associatedWithOrganizations") QuestionWithExplanation associatedWithOrganizations,
      @JsonProperty("explanation") Optional<QuestionWithExplanation> continueToParticipate) {
    this.associatedWithOrganizations = associatedWithOrganizations;
    this.continueToParticipate = continueToParticipate;
  }

  public QuestionWithExplanation getAssociatedWithOrganizations() {
    return associatedWithOrganizations;
  }

  public Optional<QuestionWithExplanation> getContinueToParticipate() {
    return continueToParticipate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrganizationInfo that = (OrganizationInfo) o;
    return Objects.equals(associatedWithOrganizations, that.associatedWithOrganizations)
        && Objects.equals(continueToParticipate, that.continueToParticipate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(associatedWithOrganizations, continueToParticipate);
  }

  @Override
  public String toString() {
    return "OrganizationInfo{"
        + "associatedWithOrganizations='"
        + associatedWithOrganizations 
        + '\''
        + "continueToParticipate='"
        + continueToParticipate 
        + '\''
        + '}';
  }
}


