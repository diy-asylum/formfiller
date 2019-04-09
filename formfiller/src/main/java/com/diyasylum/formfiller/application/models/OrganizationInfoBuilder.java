package com.diyasylum.formfiller.application.models;
import java.util.Optional;

public class OrganizationInfoBuilder {
  private QuestionWithExplanation associatedWithOrganizations;
  private Optional<QuestionWithExplanation> continueToParticipate;

  public OrganizationInfoBuilder setAssociatedWithOrganizations(QuestionWithExplanation associatedWithOrganizations) {
    this.associatedWithOrganizations = associatedWithOrganizations;
    return this;
  }

  public OrganizationInfoBuilder setContinueToParticipate(Optional<QuestionWithExplanation> continueToParticipate) {
    this.continueToParticipate = continueToParticipate;
    return this;
  }

  public OrganizationInfo createOrganizationInfo() {
    return new OrganizationInfo(associatedWithOrganizations, continueToParticipate);
  }
}


