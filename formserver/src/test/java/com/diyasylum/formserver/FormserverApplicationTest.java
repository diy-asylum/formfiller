package com.diyasylum.formserver;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.I589Filler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FormserverApplicationTest {

  private I589Filler i589Filler;

  @Autowired
  FormserverApplicationTest(I589Filler i589Filler) {
    this.i589Filler = i589Filler;
  }

  @Test
  void contextLoads() {
    assertNotNull(this.i589Filler);
  }
}
