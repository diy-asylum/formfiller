package com.diyasylum.formfiller.models;

public class I589FieldBuilder {
  private String description;
  private String absolutePath;
  private String relativePath;
  private FieldType fieldType;
  private String value;

  public I589FieldBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public I589FieldBuilder setAbsolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
    return this;
  }

  public I589FieldBuilder setRelativePath(String relativePath) {
    this.relativePath = relativePath;
    return this;
  }

  public I589FieldBuilder setFieldType(FieldType fieldType) {
    this.fieldType = fieldType;
    return this;
  }

  public I589FieldBuilder setValue(String value) {
    this.value = value;
    return this;
  }

  public I589Field createI589Field() {
    return new I589Field(description, absolutePath, relativePath, fieldType, value);
  }
}
