package com.diyasylum.formserver;

import com.diyasylum.formfiller.I589Filler;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class I589Config {

  @Bean
  public I589Filler I589Filler() throws IOException {
    return I589Filler.fromIncludedForm();
  }
}
