package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Optional;

public class RelativeHelpPrepare {
  private final YesNoAnswer didRelativeHelp;
  private final Optional<Relative> firstRelative;
  private final Optional<Relative> secondRelative;

  @JsonCreator
  public RelativeHelpPrepare(
      @JsonProperty("didRelativeHelp") YesNoAnswer didRelativeHelp,
      @JsonProperty("firstRelative") Optional<Relative> firstRelative,
      @JsonProperty("secondRelative") Optional<Relative> secondRelative) {
    this.didRelativeHelp = didRelativeHelp;
    this.firstRelative = firstRelative;
    this.secondRelative = secondRelative;
  }

  public YesNoAnswer getDidRelativeHelp() {
    return didRelativeHelp;
  }

  public Optional<Relative> getFirstRelative() {
    return firstRelative;
  }

  public Optional<Relative> getSecondRelative() {
    return secondRelative;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RelativeHelpPrepare that = (RelativeHelpPrepare) o;
    return Objects.equals(didRelativeHelp, that.didRelativeHelp)
        && Objects.equals(firstRelative, that.firstRelative)
        && Objects.equals(secondRelative, that.secondRelative);
  }

  @Override
  public int hashCode() {
    return Objects.hash(didRelativeHelp, firstRelative, secondRelative);
  }

  @Override
  public String toString() {
    return "RelativeHelpPrepare{"
        + "didRelativeHelp='"
        + didRelativeHelp
        + '\''
        + "firstRelative='"
        + firstRelative
        + '\''
        + "secondRelative='"
        + secondRelative
        + '\''
        + '}';
  }
}
