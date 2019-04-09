package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

public class QuestionWithExplanation {
  private final YesNoAnswer yesNoAnswer;
  private final Optional<String> explanation;

  @JsonCreator
  public QuestionWithExplanation(
      @JsonProperty("yesNoAnswer") YesNoAnswer yesNoAnswer,
      @JsonProperty("explanation") Optional<String> explanation) {
    this.yesNoAnswer = yesNoAnswer;
    this.explanation = explanation;
  }

  public YesNoAnswer getYesNoAnswer() {
    return yesNoAnswer;
  }

  public Optional<String> getExplanation() {
    return explanation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    QuestionWithExplanation that = (QuestionWithExplanation) o;
    return Objects.equals(yesNoAnswer, that.yesNoAnswer)
        && Objects.equals(explanation, that.explanation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(yesNoAnswer, explanation);
  }

  @Override
  public String toString() {
    return "QuestionWithExplanation{"
        + "yesNoAnswer='"
        + yesNoAnswer
        + '\''
        + "explanation='"
        + explanation
        + '\''
        + '}';
  }
}
