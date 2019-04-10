package com.diyasylum.formfiller.application.models;

import java.util.Optional;

public class OtherCountryApplicationsBuilder {
  private YesNoAnswer travelThroughOtherCountry;
  private YesNoAnswer applyOtherCountry;
  private Optional<String> explanation;

  public OtherCountryApplicationsBuilder setTravelThroughOtherCountry(
      YesNoAnswer travelThroughOtherCountry) {
    this.travelThroughOtherCountry = travelThroughOtherCountry;
    return this;
  }

  public OtherCountryApplicationsBuilder setApplyOtherCountry(YesNoAnswer applyOtherCountry) {
    this.applyOtherCountry = applyOtherCountry;
    return this;
  }

  public OtherCountryApplicationsBuilder setExplanation(Optional<String> explanation) {
    this.explanation = explanation;
    return this;
  }

  public OtherCountryApplications createOtherCountryApplications() {
    return new OtherCountryApplications(travelThroughOtherCountry, applyOtherCountry, explanation);
  }
}
