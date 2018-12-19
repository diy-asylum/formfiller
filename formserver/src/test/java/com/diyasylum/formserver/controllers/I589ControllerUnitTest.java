package com.diyasylum.formserver.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.diyasylum.formfiller.I589Filler;
import com.diyasylum.formfiller.models.FieldType;
import com.diyasylum.formfiller.models.I589Field;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(I589Controller.class)
class I589ControllerUnitTest {
  private MockMvc mockMvc;

  @MockBean private I589Filler i589Filler;

  @Autowired
  I589ControllerUnitTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void testBasicPost() throws Exception {
    byte[] expectedPdf = new byte[] {3}; // you are right, this is not a real pdf
    List<I589Field> fieldList =
        Collections.singletonList(
            new I589Field("Best Superhero", "heroes/best", "best", FieldType.TEXT, "batman"));
    when(i589Filler.fillInForm(fieldList)).thenReturn(expectedPdf);
    this.mockMvc
        .perform(
            post("/i589/fillraw")
                .content(new ObjectMapper().writeValueAsString(fieldList))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/pdf"))
        .andExpect(content().bytes(expectedPdf));
  }
}
