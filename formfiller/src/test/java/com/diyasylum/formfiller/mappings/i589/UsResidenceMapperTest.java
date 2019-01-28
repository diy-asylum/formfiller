package com.diyasylum.formfiller.mappings.i589;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.application.models.Address;
import com.diyasylum.formfiller.application.models.AddressBuilder;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UsResidenceMapperTest {
  @Test
  void basicMapping() {
    Address usResidence =
        new AddressBuilder()
            .setApartmentNumber("1")
            .setAreaCode("203")
            .setCity("city")
            .setPhoneNumber("933-1223")
            .setState("realState")
            .setStreetName("realStreet")
            .setStreetNumber("4")
            .setInCareOf("Batman")
            .setZipCode("123456")
            .createAddress();

    Map<String, String> result =
        new UsResidenceMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(usResidence)));

    assertEquals(
        Map.of(
            "form1[0].#subform[0].PtAILine8_State[0]", "realState",
            "form1[0].#subform[0].PtAILine8_AreaCode[0]", "203",
            "form1[0].#subform[0].TextField1[2]", "city",
            "form1[0].#subform[0].PtAILine8_AptNumber[0]", "1",
            "form1[0].#subform[0].PtAILine8_StreetNumandName[0]", "4 realStreet",
            "form1[0].#subform[0].PtAILine8_Zipcode[0]", "123456",
            "form1[0].#subform[0].PtAILine8_TelephoneNumber[0]", "933-1223"),
        result);
  }
}
