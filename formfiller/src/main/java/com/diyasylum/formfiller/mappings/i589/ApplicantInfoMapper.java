package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.ApplicantInfo;
import com.diyasylum.formfiller.application.models.Gender;
import com.diyasylum.formfiller.application.models.ImmigrationCourtHistory;
import com.diyasylum.formfiller.application.models.MaritalStatus;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ApplicantInfoMapper extends AbstractMapper<ApplicantInfo> {
  private static Map<String, Function<ApplicantInfo, String>> fieldMapping;

  @Override
  public Map<String, Function<ApplicantInfo, String>> getFormMapper() {
    if (fieldMapping == null) {
      Map<String, Function<ApplicantInfo, String>> pdfFieldMap = new HashMap<>();
      pdfFieldMap.put(
          "form1[0].#subform[0].PtAILine1_ANumber[0]", this::formatAlienRegistrationNumber);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[0]", ApplicantInfo::getSocialSecurityNumber);
      pdfFieldMap.put("form1[0].#subform[0].PtAILine4_LastName[0]", this::formatLastName);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[1]", this::formatAliases);
      pdfFieldMap.put("form1[0].#subform[0].DateTimeField1[0]", ApplicantInfo::getDateOfBirth);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[3]", ApplicantInfo::getPresentNationality);
      pdfFieldMap.put("form1[0].#subform[0].PtAILine5_FirstName[0]", this::formatFirstName);
      pdfFieldMap.put("form1[0].#subform[0].PtAILine6_MiddleName[0]", this::formatMiddleName);

      pdfFieldMap.put("form1[0].#subform[0].PartALine9Gender[0]", this::checkIfMale);
      pdfFieldMap.put("form1[0].#subform[0].PartALine9Gender[1]", this::checkIfFemale);
      pdfFieldMap.put("form1[0].#subform[0].Marital[0]", this::checkIfSingle);
      pdfFieldMap.put("form1[0].#subform[0].Marital[1]", this::checkIfMarried);
      pdfFieldMap.put("form1[0].#subform[0].Marital[2]", this::checkIfDivorced);
      pdfFieldMap.put("form1[0].#subform[0].Marital[3]", this::checkIfWidowed);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[4]", this::formatCityAndCountryOfBirth);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[5]", ApplicantInfo::getNationalityAtBirth);
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField1[6]", ApplicantInfo::getRaceEthnicOrTribalGroup);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[7]", ApplicantInfo::getReligion);
      pdfFieldMap.put("form1[0].#subform[0].CheckBox3[0]", this::checkIfNeverInCourt);
      pdfFieldMap.put("form1[0].#subform[0].CheckBox3[1]", this::checkIfBeenInCourtPreviously);
      pdfFieldMap.put("form1[0].#subform[0].CheckBox3[2]", this::checkIfInCourtNow);
      pdfFieldMap.put("form1[0].#subform[0].TextField5[0]", this::formatCountryWhoIssuedPassport);
      pdfFieldMap.put("form1[0].#subform[0].TextField5[1]", this::formatPassportNumber);
      pdfFieldMap.put("form1[0].#subform[0].TextField5[2]", this::formatTravelDocumentNumber);
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox31[0]", this::checkIfApplyingForConventionAgainstTorture);
      pdfFieldMap.put(
          "form1[0].#subform[0].DateTimeField2[2]", this::formatTravelDocumentExpirationDate);
      pdfFieldMap.put("form1[0].#subform[0].TextField7[0]", ApplicantInfo::getNativeLanguage);
      pdfFieldMap.put("form1[0].#subform[0].CheckBox4[0]", this::checkIfFluentInEnglish);
      pdfFieldMap.put("form1[0].#subform[0].CheckBox4[1]", this::checkIfNotFluentInEnglish);
      pdfFieldMap.put("form1[0].#subform[0].TextField7[1]", this::formatOtherLanguages);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[8]", this::formatUscisNumber);
      fieldMapping = pdfFieldMap;
      fieldMapping.putAll(
          new UsMailingAddressMapper().composeMapping(ApplicantInfo::getUsMailingAddress));
      fieldMapping.putAll(new UsResidenceMapper().composeMapping(ApplicantInfo::getUsResidence));
    }
    return fieldMapping;
  }

  private String formatAlienRegistrationNumber(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(applicantInfo.getAlienRegistrationNumber());
  }

  private String formatFirstName(ApplicantInfo applicantInfo) {
    return AbstractMapper.naIfBlank(applicantInfo.getFirstName());
  }

  private String formatMiddleName(ApplicantInfo applicantInfo) {
    return AbstractMapper.naIfBlank(applicantInfo.getMiddleName());
  }

  private String formatLastName(ApplicantInfo applicantInfo) {
    return AbstractMapper.naIfBlank(applicantInfo.getLastName());
  }

  private String formatAliases(ApplicantInfo applicantInfo) {
    return String.join(",", applicantInfo.getAliases());
  }

  private String checkIfMale(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(applicantInfo.getGender() == Gender.MALE, "M");
  }

  private String checkIfFemale(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(applicantInfo.getGender() == Gender.FEMALE, "F");
  }

  private String checkIfSingle(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getMaritalStatus() == MaritalStatus.SINGLE, "S");
  }

  private String checkIfMarried(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getMaritalStatus() == MaritalStatus.MARRIED, "M");
  }

  private String checkIfDivorced(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getMaritalStatus() == MaritalStatus.DIVORCED, "D");
  }

  private String checkIfWidowed(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getMaritalStatus() == MaritalStatus.WIDOWED, "W");
  }

  private String formatCityAndCountryOfBirth(ApplicantInfo applicantInfo) {
    return String.join(" ", applicantInfo.getCityOfBirth(), applicantInfo.getCountryOfBirth());
  }

  private String checkIfBeenInCourtPreviously(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getImmigrationCourtHistory()
            == ImmigrationCourtHistory.NOT_NOW_BUT_IN_THE_PAST,
        "C");
  }

  private String checkIfInCourtNow(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getImmigrationCourtHistory() == ImmigrationCourtHistory.CURRENTLY, "B");
  }

  private String checkIfNeverInCourt(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.getImmigrationCourtHistory() == ImmigrationCourtHistory.NEVER, "A");
  }

  private String formatCountryWhoIssuedPassport(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(applicantInfo.getCountryWhoLastIssuedPassport());
  }

  private String formatPassportNumber(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(applicantInfo.getPassportNumber());
  }

  private String formatTravelDocumentNumber(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(applicantInfo.getTravelDocumentNumber());
  }

  private String checkIfApplyingForConventionAgainstTorture(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(
        applicantInfo.isAlsoApplyingConventionAgainstTorture(), "1");
  }

  private String formatTravelDocumentExpirationDate(ApplicantInfo applicantInfo) {
    return AbstractMapper.naIfBlank(applicantInfo.getTravelDocumentExpirationDate());
  }

  private String checkIfFluentInEnglish(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(applicantInfo.isFluentInEnglish(), "Yes");
  }

  private String checkIfNotFluentInEnglish(ApplicantInfo applicantInfo) {
    return AbstractMapper.formatCheckbox(!applicantInfo.isFluentInEnglish(), "No");
  }

  private String formatOtherLanguages(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(String.join(",", applicantInfo.getOtherLanguages()));
  }

  private String formatUscisNumber(ApplicantInfo applicantInfo) {
    return AbstractMapper.noneIfBlank(applicantInfo.getUscisAccountNumber());
  }
}
