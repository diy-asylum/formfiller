package com.diyasylum.formfiller.mappings.i589;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.application.models.Address;
import com.diyasylum.formfiller.application.models.AddressBuilder;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UsMailingAddressMapperTest {

  @Test
  void basicMapping() {
    Address usMailingAddress =
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
        new UsMailingAddressMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(usMailingAddress)));
    result.forEach((k, v) -> System.out.println("\"" + k + "\", " + "\"" + v + "\","));

    assertEquals(
        Map.of(
            "form1[0].#subform[0].PtAILine9_ZipCode[0]",
            "123456",
            "form1[0].#subform[0].PtAILine9_StreetNumandName[0]",
            "4 realStreet",
            "form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]",
            "933-1223",
            "form1[0].#subform[0].PtAILine9_State[0]",
            "realState",
            "form1[0].#subform[0].PtAILine9_InCareOf[0]",
            "Batman",
            "form1[0].#subform[0].PtAILine9_City[0]",
            "city",
            "form1[0].#subform[0].PtAILine9_AptNumber[0]",
            "1",
            "form1[0].#subform[0].PtAILine9_AreaCode[0]",
            "203"),
        result);
  }

  @Test
  void missingCareOf() {
    Address nullInCareOf = new AddressBuilder().createAddress();
    assertEquals("N/A", new UsMailingAddressMapper().getFormMapper().get("form1[0].#subform[0].PtAILine9_InCareOf[0]").apply(nullInCareOf));
  }
}
