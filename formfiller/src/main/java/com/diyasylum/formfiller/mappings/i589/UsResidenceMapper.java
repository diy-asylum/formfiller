package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.Address;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.Map;
import java.util.function.Function;

public class UsResidenceMapper extends AbstractMapper<Address> {
  private static Map<String, Function<Address, String>> fieldMapping;

  @Override
  public Map<String, Function<Address, String>> getFormMapper() {
    if (fieldMapping == null) {
      fieldMapping =
          Map.of(
              "form1[0].#subform[0].PtAILine8_StreetNumandName[0]",
              usResidence ->
                  String.join(" ", usResidence.getStreetNumber(), usResidence.getStreetName()),
              "form1[0].#subform[0].TextField1[2]",
              Address::getCity,
              "form1[0].#subform[0].PtAILine8_AreaCode[0]",
              Address::getAreaCode,
              "form1[0].#subform[0].PtAILine8_TelephoneNumber[0]",
              Address::getPhoneNumber,
              "form1[0].#subform[0].PtAILine8_AptNumber[0]",
              Address::getApartmentNumber,
              "form1[0].#subform[0].PtAILine8_State[0]",
              Address::getState,
              "form1[0].#subform[0].PtAILine8_Zipcode[0]",
              Address::getZipCode);
    }
    return fieldMapping;
  }
}
