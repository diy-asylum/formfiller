package com.diyasylum.formfiller.pdfiller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class SimplePdField {
  private final String description;
  private final String absolutePath;
  private final String relativePath;
  private final String value;
  private final FieldType fieldType;

  public static SimplePdField fromPdField(PDField field) {
    return new SimplePdField(
        field.getAlternateFieldName(),
        field.getFullyQualifiedName(),
        field.getPartialName(),
        FieldType.fromString(field.getFieldType()),
        field.getValueAsString());
  }

  @JsonCreator
  public SimplePdField(
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
    SimplePdField simplePdField = (SimplePdField) o;
    return Objects.equals(description, simplePdField.description)
        && Objects.equals(absolutePath, simplePdField.absolutePath)
        && Objects.equals(relativePath, simplePdField.relativePath)
        && Objects.equals(value, simplePdField.value)
        && fieldType == simplePdField.fieldType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, absolutePath, relativePath, value, fieldType);
  }

  @Override
  public String toString() {
    return "SimplePdField{"
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
