package com.diyasylum.formfiller.application.models;

import java.util.Optional;

public class RelativeHelpPrepareBuilder {
  private YesNoAnswer didRelativeHelp;
  private Optional<Relative> firstRelative;
  private Optional<Relative> secondRelative;

  public RelativeHelpPrepareBuilder setDidRelativeHelp(YesNoAnswer didRelativeHelp) {
    this.didRelativeHelp = didRelativeHelp;
    return this;
  }

  public RelativeHelpPrepareBuilder setFirstRelative(Optional<Relative> firstRelative) {
    this.firstRelative = firstRelative;
    return this;
  }

  public RelativeHelpPrepareBuilder setSecondRelative(Optional<Relative> secondRelative) {
    this.secondRelative = secondRelative;
    return this;
  }

  public RelativeHelpPrepare createRelativeHelpPrepare() {
    return new RelativeHelpPrepare(didRelativeHelp, firstRelative, secondRelative);
  }
}
