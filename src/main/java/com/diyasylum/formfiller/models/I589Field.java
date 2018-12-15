package com.diyasylum.formfiller.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class I589Field {
  private final String description;
  private final String absolutePath;
  private final String relativePath;
  private final String value;
  private final FieldType fieldType;

  public static I589Field fromPdField(PDField field) {
    return new I589Field(
        field.getAlternateFieldName(),
        field.getFullyQualifiedName(),
        field.getPartialName(),
        FieldType.fromString(field.getFieldType()),
        field.getValueAsString());
  }

  @JsonCreator
  public I589Field(
      @JsonProperty("description") String description,
      @JsonProperty("absolutePath") String absolutePath,
      @JsonProperty("relativePath") String relativePath,
      @JsonProperty("fieldType") FieldType fieldType,
      @JsonProperty("value") String value) {
    this.description = description;
    this.absolutePath = absolutePath;
    this.relativePath = relativePath;
    this.fieldType = fieldType;
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public String getAbsolutePath() {
    return absolutePath;
  }

  public String getRelativePath() {
    return relativePath;
  }

  public FieldType getFieldType() {
    return fieldType;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    I589Field i589Field = (I589Field) o;
    return Objects.equals(description, i589Field.description)
        && Objects.equals(absolutePath, i589Field.absolutePath)
        && Objects.equals(relativePath, i589Field.relativePath)
        && Objects.equals(value, i589Field.value)
        && fieldType == i589Field.fieldType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, absolutePath, relativePath, value, fieldType);
  }

  @Override
  public String toString() {
    return "I589Field{"
        + "description='"
        + description
        + '\''
        + ", absolutePath='"
        + absolutePath
        + '\''
        + ", relativePath='"
        + relativePath
        + '\''
        + ", value='"
        + value
        + '\''
        + ", fieldType="
        + fieldType
        + '}';
  }
}
