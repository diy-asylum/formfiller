package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.Address;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.Map;
import java.util.function.Function;

public class UsMailingAddressMapper extends AbstractMapper<Address> {
  private static Map<String, Function<Address, String>> fieldMapping;

  @Override
  public Map<String, Function<Address, String>> getFormMapper() {
    if (fieldMapping == null) {
      fieldMapping =
          Map.of(
              "form1[0].#subform[0].PtAILine9_AptNumber[0]",
              Address::getApartmentNumber,
              "form1[0].#subform[0].PtAILine9_ZipCode[0]",
              Address::getZipCode,
              "form1[0].#subform[0].PtAILine9_City[0]",
              Address::getCity,
              "form1[0].#subform[0].PtAILine9_State[0]",
              Address::getState,
              "form1[0].#subform[0].PtAILine9_AreaCode[0]",
              Address::getAreaCode,
              "form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]",
              Address::getPhoneNumber,
              "form1[0].#subform[0].PtAILine9_InCareOf[0]",
              this::formatInCareOf,
              "form1[0].#subform[0].PtAILine9_StreetNumandName[0]",
              this::formatStreetNumberAndName);
    }
    return fieldMapping;
  }

  private String formatInCareOf(Address address) {
    return AbstractMapper.naIfBlank(address.getInCareOf());
  }

  private String formatStreetNumberAndName(Address address) {
    return String.join(" ", address.getStreetNumber(), address.getStreetName());
  }
}
