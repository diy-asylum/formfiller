package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

public class OtherCountryApplications {
  private final YesNoAnswer travelThroughOtherCountry;
  private final YesNoAnswer applyOtherCountry;
  private final Optional<String> explanation;

  @JsonCreator
  public OtherCountryApplications(
      @JsonProperty("travelThroughOtherCountry") YesNoAnswer travelThroughOtherCountry,
      @JsonProperty("applyOtherCountry") YesNoAnswer applyOtherCountry,
      @JsonProperty("explanation") Optional<String> explanation) {
    this.travelThroughOtherCountry = travelThroughOtherCountry;
    this.applyOtherCountry = applyOtherCountry;
    this.explanation = explanation;
  }

  public YesNoAnswer getTravelThroughOtherCountry() {
    return travelThroughOtherCountry;
  }

  public YesNoAnswer getApplyOtherCountry() {
    return applyOtherCountry;
  }

  public Optional<String> getExplanation() {
    return explanation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OtherCountryApplications that = (OtherCountryApplications) o;
    return Objects.equals(travelThroughOtherCountry, that.travelThroughOtherCountry)
        && Objects.equals(applyOtherCountry, that.applyOtherCountry)
	    && Objects.equals(explanation, that.explanation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(travelThroughOtherCountry, applyOtherCountry, explanation);
  }

  @Override
  public String toString() {
    return "OtherCountryApplications{"
        + "travelThroughOtherCountry='"
        + travelThroughOtherCountry 
        + '\''
        + "applyOtherCountry='"
        + applyOtherCountry 
        + '\''
        + "explanation='"
        + explanation 
        + '\''
        + '}';
  }
}


