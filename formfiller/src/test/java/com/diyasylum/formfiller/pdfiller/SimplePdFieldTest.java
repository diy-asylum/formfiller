package com.diyasylum.formfiller.pdfiller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class SimplePdFieldTest {
  @Test
  void testFieldSerializationAndDeserialization() throws IOException {
    SimplePdField field =
        new SimplePdField(
            "Im such a field omg", "Group.field 1", "field 1", FieldType.TEXT, "Yes!");

    ObjectMapper objectMapper = new ObjectMapper();
    String serializedJson = objectMapper.writeValueAsString(field);

    SimplePdField deserializedField = objectMapper.readValue(serializedJson, SimplePdField.class);

    assertEquals(field, deserializedField);
  }
}
