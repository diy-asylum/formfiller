package com.diyasylum.formfiller.models;

public enum FieldType {
  TEXT,
  BUTTON;

  static FieldType fromString(String ftype) {
    switch (ftype) {
      case "Btn":
        return FieldType.BUTTON;
      case "Tx":
        return FieldType.TEXT;
      default:
        throw new IllegalArgumentException("Dont know about ftype " + ftype);
    }
  }
}
