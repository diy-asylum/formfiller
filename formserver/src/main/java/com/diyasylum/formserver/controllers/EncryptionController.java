package com.diyasylum.formserver.controllers;

import com.diyasylum.encryption.EncryptionHandler;
import com.diyasylum.encryption.models.EncryptionPackage;
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
  public ResponseEntity<EncryptionPackage> encryptMessage(@RequestBody UnencryptedMessage message) {
    return new ResponseEntity<>(
        EncryptionHandler.handleEncryption(message), fillResponseHeaders, HttpStatus.OK);
  }

  @PostMapping("/decryption/v1")
  @ResponseBody
  public ResponseEntity<UnencryptedMessage> decryptMessage(
      @RequestBody EncryptionPackage encryptionPackage) {
    return new ResponseEntity<>(
        EncryptionHandler.handleDecryption(encryptionPackage), fillResponseHeaders, HttpStatus.OK);
  }
}
