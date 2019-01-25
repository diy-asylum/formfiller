package com.diyasylum.formserver.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.diyasylum.encryption.models.EncryptedMessage;
import com.diyasylum.encryption.models.EncryptionPackage;
import com.diyasylum.encryption.models.UnencryptedMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EncryptionController.class)
class EncryptionControllerUnitTest {
  private MockMvc mockMvc;

  @Autowired
  EncryptionControllerUnitTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void testEncryptionPost() throws Exception {
    UnencryptedMessage message = new UnencryptedMessage("message");
    this.mockMvc
        .perform(
            post("/encryption/v1")
                .content(new ObjectMapper().writeValueAsString(message))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test
  void testDecryptionPost() throws Exception {
    EncryptedMessage encryptedMessage =
        new EncryptedMessage(
            Base64.decodeBase64("itkNJqRclSElL/iaUugskBZCaCmXCf67coYuw3T5"),
            Base64.decodeBase64("C1wxtjxCPusWK1naAnnVyQ=="),
            Base64.decodeBase64("7yKw+IMNRouQFrIv5P/sY+Ag3D4XVwbq"));
    String password = "4nChZTTPYlOvCma5";
    EncryptionPackage encryptionPackage = new EncryptionPackage(encryptedMessage, password);
    UnencryptedMessage message = new UnencryptedMessage("secret message");
    this.mockMvc
        .perform(
            post("/decryption/v1")
                .content(new ObjectMapper().writeValueAsString(encryptionPackage))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().json(new ObjectMapper().writeValueAsString(message)));
  }
}
