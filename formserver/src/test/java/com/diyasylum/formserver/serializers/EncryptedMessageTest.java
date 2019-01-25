package com.diyasylum.formserver.serializers;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

class EncryptedMessageTest {
  @Test
  void testSerializationAndDeserialization() throws IOException {
    EncryptedMessage encryptedMessage =
        new EncryptedMessage(
            Base64.decodeBase64("itkNJqRclSElL/iaUugskBZCaCmXCf67coYuw3T5"),
            Base64.decodeBase64("C1wxtjxCPusWK1naAnnVyQ=="),
            Base64.decodeBase64("7yKw+IMNRouQFrIv5P/sY+Ag3D4XVwbq"));

    ObjectMapper objectMapper = new ObjectMapper();
    String serializedJson = objectMapper.writeValueAsString(encryptedMessage);

    EncryptedMessage deserializedMessage =
        objectMapper.readValue(serializedJson, EncryptedMessage.class);
    assertEquals(encryptedMessage, deserializedMessage);
  }
}
