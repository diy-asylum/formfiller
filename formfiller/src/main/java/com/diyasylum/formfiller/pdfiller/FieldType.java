package com.diyasylum.formfiller.pdfiller;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FieldType {
  TEXT,
  BUTTON;

  @JsonCreator
  static FieldType fromString(String fieldType) {
    switch (fieldType) {
      case "BUTTON":
      case "Btn":
        return FieldType.BUTTON;
      case "Tx":
      case "TEXT":
        return FieldType.TEXT;
      default:
        throw new IllegalArgumentException("Dont know about ftype " + fieldType);
    }
  }
}
