package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.Gender;
import com.diyasylum.formfiller.application.models.SpouseInfo;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SpouseInfoMapper extends AbstractMapper<SpouseInfo> {
  private static Map<String, Function<SpouseInfo, String>> fieldMapping;
  private static Function<String, String> naIfBlank =
      ((Function<String, String>) c -> AbstractMapper.naIfBlank(c));

  @Override
  public Map<String, Function<SpouseInfo, String>> getFormMapper() {
    if (fieldMapping == null) {
      Map<String, Function<SpouseInfo, String>> pdfFieldMap = new HashMap<>();
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine1_ANumber[0]",
          this::formatAlienRegistrationNumber);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine5_LastName[0]",
          naIfBlank.compose(c -> c.getLastName()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine6_FirstName[0]",
          naIfBlank.compose(c -> c.getFirstName()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine7_MiddleName[0]",
          naIfBlank.compose(c -> c.getMiddleName()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].DateTimeField8[0]",
          naIfBlank.compose(c -> c.getDateOfMarriage()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].TextField10[0]",
          naIfBlank.compose(c -> c.getNationality()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine15_CheckBox15[0]", this::formatNotInUS);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine15_CheckBox15[1]", this::formatInUS);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine16_PlaceofLastEntry[0]",
          naIfBlank.compose(c -> c.getPlaceOfLastEntry()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine17_DateofLastEntry[0]",
          naIfBlank.compose(c -> c.getDateOfLastEntry()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine20_SpouseCurrentStatus[0]",
          naIfBlank.compose(c -> c.getCurrentImmigrationStatus()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].TextField10[1]", this::formatPassportNumber);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].DateTimeField7[0]",
          naIfBlank.compose(c -> c.getDateOfBirth()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].TextField10[2]", this::formatSocialSecurityNumber);
      pdfFieldMap.put("form1[0].#subform[1].NotMarried[0].TextField10[3]", this::formatAliases);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].TextField10[4]",
          naIfBlank.compose(c -> c.getPlaceOfMarriage()));
      pdfFieldMap.put("form1[0].#subform[1].NotMarried[0].TextField10[5]", this::formatCityBirth);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].TextField10[6]",
          naIfBlank.compose(c -> c.getRaceEthnicOrTribalGroup()));
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].CheckBox14_Gender[0]", this::formatMaleGender);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].CheckBox14_Gender[1]", this::formatFemaleGender);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine18_I94Number[0]", this::formatI94);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine19_StatusofLastAdmission[0]",
          this::formatImmigrationStatusWhenLastAdmitted);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine21_ExpDateofAuthorizedStay[0]",
          this::formatExpirationDateWhenLastAdmitted);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine23_PreviousArrivalDate[0]",
          this::formatPreviousArrival);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine22_Yes[0]", this::formatCourtProceedingsYes);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine22_No[0]", this::formatCourtProceedingsNo);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine24_No[0]", this::formatIncludedNo);
      pdfFieldMap.put(
          "form1[0].#subform[1].NotMarried[0].PtAIILine24_Yes[0]", this::formatIncludedYes);

      fieldMapping = pdfFieldMap;
    }
    return fieldMapping;
  }

  private String formatIncludedYes(SpouseInfo spouseInfo) {
    String flag = "Off";
    if (spouseInfo.getIncludeInApplication()) {
      flag = "N";
    }
    return flag;
  }

  private String formatIncludedNo(SpouseInfo spouseInfo) {
    String flag = "N";
    if (spouseInfo.getIncludeInApplication()) {
      flag = "Off";
    }
    return flag;
  }

  private String formatCourtProceedingsNo(SpouseInfo spouseInfo) {
    String flag = "No";
    if (spouseInfo.getIsInImmigrationCourt()) {
      flag = "Off";
    }
    return flag;
  }

  private String formatCourtProceedingsYes(SpouseInfo spouseInfo) {
    String flag = "Off";
    if (spouseInfo.getIsInImmigrationCourt()) {
      flag = "No";
    }
    return flag;
  }

  private String formatPreviousArrival(SpouseInfo spouseInfo) {
    String date = spouseInfo.getPreviousArrivalDate().orElse("");
    return AbstractMapper.naIfBlank(date);
  }

  private String formatExpirationDateWhenLastAdmitted(SpouseInfo spouseInfo) {
    String date = spouseInfo.getStatusExpirationDate().orElse("");
    return AbstractMapper.naIfBlank(date);
  }

  private String formatImmigrationStatusWhenLastAdmitted(SpouseInfo spouseInfo) {
    String status = spouseInfo.getImmigrationStatusWhenLastAdmitted().orElse("");
    return AbstractMapper.naIfBlank(status);
  }

  private String formatI94(SpouseInfo spouseInfo) {
    String i94 = spouseInfo.getI94Number().orElse("");
    return AbstractMapper.naIfBlank(i94);
  }

  private String formatFemaleGender(SpouseInfo spouseInfo) {
    Gender gender = spouseInfo.getGender().orElse(null);
    String flag = "Off";
    if (gender == Gender.FEMALE) {
      flag = "N";
    }
    return flag;
  }

  private String formatMaleGender(SpouseInfo spouseInfo) {
    Gender gender = spouseInfo.getGender().orElse(null);
    String flag = "Off";
    if (gender == Gender.MALE) {
      flag = "N";
    }
    return flag;
  }

  private String formatCityBirth(SpouseInfo spouseInfo) {
    String city = spouseInfo.getCityOfBirth();
    String country = spouseInfo.getCountryOfBirth();
    if (city != "" && country != "") {
      return city + ", " + country;
    } else if (city != "" && country == "") {
      return city;
    } else if (country != "" && city == "") {
      return country;
    } else {
      return "N/A";
    }
  }

  private String formatAliases(SpouseInfo spouseInfo) {
    String aliases = String.join(",", spouseInfo.getAliases());
    return AbstractMapper.naIfBlank(aliases);
  }

  private String formatSocialSecurityNumber(SpouseInfo spouseInfo) {
    String socialSecurityNumber = spouseInfo.getSocialSecurityNumber().orElse("");
    return AbstractMapper.naIfBlank(socialSecurityNumber);
  }

  private String formatAlienRegistrationNumber(SpouseInfo spouseInfo) {
    String alienRegistrationNumber = spouseInfo.getAlienRegistrationNumber().orElse("");
    return AbstractMapper.naIfBlank(alienRegistrationNumber);
  }

  private String formatNotInUS(SpouseInfo spouseInfo) {
    String flag = "N";
    if (spouseInfo.getInUS()) {
      flag = "Off";
    }
    return flag;
  }

  private String formatInUS(SpouseInfo spouseInfo) {
    String flag = "Off";
    if (spouseInfo.getInUS()) {
      flag = "N";
    }
    return flag;
  }

  private String formatPassportNumber(SpouseInfo spouseInfo) {
    String passportNumber = spouseInfo.getPassportNumber().orElse("");
    return AbstractMapper.naIfBlank(passportNumber);
  }
}
