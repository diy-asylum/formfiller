package com.diyasylum.formserver.controllers;

import com.diyasylum.formfiller.application.models.I589Application;
import com.diyasylum.formfiller.mappings.i589.I589ApplicationMapper;
import com.diyasylum.formfiller.pdfiller.PDFiller;
import java.io.IOException;
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
  private final I589ApplicationMapper i589ApplicationMapper;

  @Autowired
  public I589Controller(PDFiller PDFiller, I589ApplicationMapper i589ApplicationMapper) {
    this.PDFiller = PDFiller;
    this.i589ApplicationMapper = i589ApplicationMapper;
    this.fillResponseHeaders = getFillResponseHeaders();
  }

  private HttpHeaders getFillResponseHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentDispositionFormData(FILLED_IN_FORM_FILENAME, FILLED_IN_FORM_FILENAME);
    headers.setCacheControl("no-cache");
    return headers;
  }

  @PostMapping("/i589/fill")
  @ResponseBody
  public ResponseEntity<byte[]> fillI589(@RequestBody I589Application application)
      throws IOException {
    return new ResponseEntity<>(
        PDFiller.fillInForm(application, new I589ApplicationMapper()),
        fillResponseHeaders,
        HttpStatus.OK);
  }
}
