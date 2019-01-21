package com.diyasylum.formserver;

import com.diyasylum.formfiller.pdfiller.PDFiller;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class I589Config {

  @Bean
  public PDFiller I589Filler() throws IOException {
    return PDFiller.fromIncludedForm();
  }
}
