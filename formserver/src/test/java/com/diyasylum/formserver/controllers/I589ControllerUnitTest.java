package com.diyasylum.formserver.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.diyasylum.formfiller.application.models.I589Application;
import com.diyasylum.formfiller.mappings.i589.I589ApplicationMapper;
import com.diyasylum.formfiller.pdfiller.PDFiller;
import com.diyasylum.formserver.I589Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(I589Controller.class)
@Import(I589Config.class)
class I589ControllerUnitTest {
  private MockMvc mockMvc;

  @MockBean private PDFiller PDFiller;

  @Autowired
  I589ControllerUnitTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void testBasicPost() throws Exception {
    byte[] expectedPdf = new byte[] {3}; // you are right, this is not a real pdf
    I589Application application = new I589Application(null, null);
    when(PDFiller.fillInForm(eq(application), any(I589ApplicationMapper.class)))
        .thenReturn(expectedPdf);

    this.mockMvc
        .perform(
            post("/i589/fill")
                .content(new ObjectMapper().writeValueAsString(application))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/pdf"))
        .andExpect(content().bytes(expectedPdf));
  }
}
