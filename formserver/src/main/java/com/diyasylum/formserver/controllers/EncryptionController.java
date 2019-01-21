package com.diyasylum.formserver.controllers;

import com.diyasylum.encryption.PasswordGenerator;
import com.diyasylum.encryption.SecretBox;
import com.diyasylum.encryption.models.EncryptedMessage;
import com.diyasylum.encryption.models.UnencryptedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EncryptionController {
  private final HttpHeaders fillResponseHeaders;

  @Autowired
  public EncryptionController() {
    this.fillResponseHeaders = getFillResponseHeaders();
  }

  private HttpHeaders getFillResponseHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setCacheControl("no-cache");
    return headers;
  }

  @PostMapping("/encryption/v1")
  @ResponseBody
  public ResponseEntity<EncryptedMessage> encryptMessage(@RequestBody UnencryptedMessage message) {
    String password = PasswordGenerator.getPassword();
    SecretBox box = new SecretBox(password);
    EncryptedMessage encryptedMessage = box.encrypt(message.getMessage()).get();
    return new ResponseEntity<>(encryptedMessage, fillResponseHeaders, HttpStatus.OK);
  }
}
