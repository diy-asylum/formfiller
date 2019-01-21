package com.diyasylum.formserver;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.pdfiller.PDFiller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FormserverApplicationTest {

  private PDFiller PDFiller;

  @Autowired
  FormserverApplicationTest(PDFiller PDFiller) {
    this.PDFiller = PDFiller;
  }

  @Test
  void contextLoads() {
    assertNotNull(this.PDFiller);
  }
}
