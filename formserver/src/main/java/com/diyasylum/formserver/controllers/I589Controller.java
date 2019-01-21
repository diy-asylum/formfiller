package com.diyasylum.formserver.controllers;

import com.diyasylum.formfiller.pdfiller.PDFiller;
import com.diyasylum.formfiller.pdfiller.SimplePdField;
import java.io.IOException;
import java.util.List;
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
public class I589Controller {
  private static final String FILLED_IN_FORM_FILENAME = "I589-filled.pdf";
  private final HttpHeaders fillResponseHeaders;
  private final PDFiller PDFiller;

  @Autowired
  public I589Controller(PDFiller PDFiller) {
    this.PDFiller = PDFiller;
    this.fillResponseHeaders = getFillResponseHeaders();
  }

  private HttpHeaders getFillResponseHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentDispositionFormData(FILLED_IN_FORM_FILENAME, FILLED_IN_FORM_FILENAME);
    headers.setCacheControl("no-cache");
    return headers;
  }

  @PostMapping(
      "/i589/fillraw") // The final api will be fill. Made this endpoint so we can transition
  @ResponseBody
  public ResponseEntity<byte[]> fillI589(@RequestBody List<SimplePdField> pdfFields)
      throws IOException {
    return new ResponseEntity<>(PDFiller.fillInForm(pdfFields), fillResponseHeaders, HttpStatus.OK);
  }
}
