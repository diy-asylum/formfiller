package com.diyasylum.formfiller.models;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class I589FieldTest {
  @Test
  void testFieldSerializationAndDeserialization() throws IOException {
    I589Field field =
        new I589Field("Im such a field omg", "Group.field 1", "field 1", FieldType.TEXT, "Yes!");

    ObjectMapper objectMapper = new ObjectMapper();
    String serializedJson = objectMapper.writeValueAsString(field);

    I589Field deserializedField = objectMapper.readValue(serializedJson, I589Field.class);

    assertEquals(field, deserializedField);
  }
}
