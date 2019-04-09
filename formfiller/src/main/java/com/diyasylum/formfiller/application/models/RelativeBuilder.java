package com.diyasylum.formfiller.application.models;

public class RelativeBuilder {
  private String name;
  private String relationship;

  public RelativeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public RelativeBuilder setRelationship(String relationship) {
    this.relationship = relationship;
    return this;
  }

  public Relative createRelative() {
    return new Relative(name, relationship);
  }
}
