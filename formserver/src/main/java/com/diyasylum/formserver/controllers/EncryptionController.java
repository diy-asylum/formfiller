package com.diyasylum.formserver.controllers;

import com.diyasylum.encryption.EncryptionHandler;
import com.diyasylum.encryption.exceptions.DecryptionFailedException;
import com.diyasylum.encryption.exceptions.EncryptionFailedException;
import com.diyasylum.encryption.models.EncryptionPackage;
import com.diyasylum.encryption.models.UnencryptedMessage;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    try {
      EncryptionPackage response = EncryptionHandler.handleEncryption(message);
      return new ResponseEntity<>(response, fillResponseHeaders, HttpStatus.OK);
    } catch (EncryptionFailedException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @PostMapping("/decryption/v1")
  @ResponseBody
  public ResponseEntity<UnencryptedMessage> decryptMessage(
      @RequestBody EncryptionPackage encryptionPackage) {
    try {
      UnencryptedMessage response = EncryptionHandler.handleDecryption(encryptionPackage);
      return new ResponseEntity<>(response, fillResponseHeaders, HttpStatus.OK);
    } catch (DecryptionFailedException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @ExceptionHandler({EncryptionFailedException.class, DecryptionFailedException.class})
  void handleBadRequests(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value(), "Encryption libraries failed.");
  }
}
