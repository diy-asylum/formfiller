package com.diyasylum.formfiller.application.models;

import java.util.Optional;

public class QuestionWithExplanationBuilder {
  private YesNoAnswer yesNoAnswer;
  private Optional<String> explanation;

  public QuestionWithExplanationBuilder setYesNoAnswer(YesNoAnswer yesNoAnswer) {
    this.yesNoAnswer = yesNoAnswer;
    return this;
  }

  public QuestionWithExplanationBuilder setExplanation(Optional<String> explanation) {
    this.explanation = explanation;
    return this;
  }

  public QuestionWithExplanation createQuestionWithExplanation() {
    return new QuestionWithExplanation(yesNoAnswer, explanation);
  }
}
