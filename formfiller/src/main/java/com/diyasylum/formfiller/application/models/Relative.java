package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Relative {
  private final String name;
  private final String relationship;

  @JsonCreator
  public Relative(
      @JsonProperty("name") String name,
      @JsonProperty("relationship") String relationship) {
    this.name = name;
    this.relationship = relationship;
  }

  public String getName() {
    return name;
  }

  public String getRelationship() {
    return relationship;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Relative that = (Relative) o;
    return Objects.equals(name, that.name)
        && Objects.equals(relationship, that.relationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, relationship);
  }

  @Override
  public String toString() {
    return "Relative{"
        + "name='"
        + name 
        + '\''
        + "relationship='"
        + relationship
        + '\''
        + '}';
  }
}


