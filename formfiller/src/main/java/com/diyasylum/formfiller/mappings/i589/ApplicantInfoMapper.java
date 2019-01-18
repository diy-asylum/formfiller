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
          "form1[0].#subform[0].PtAILine1_ANumber[0]",
          applicantInfo -> AbstractMapper.noneIfBlank(applicantInfo.getAlienRegistrationNumber()));
      pdfFieldMap.put("form1[0].#subform[0].TextField1[0]", ApplicantInfo::getSocialSecurityNumber);
      pdfFieldMap.put(
          "form1[0].#subform[10].USCISOnlineAcctNumber[0]",
          applicantInfo -> AbstractMapper.noneIfBlank(applicantInfo.getUSISAccountNumber()));
      pdfFieldMap.put(
          "form1[0].#subform[0].PtAILine4_LastName[0]",
          applicantInfo -> AbstractMapper.naIfBlank(applicantInfo.getLastName()));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField1[1]",
          applicantInfo -> String.join(",", applicantInfo.getAliases()));
      pdfFieldMap.put("form1[0].#subform[0].DateTimeField1[0]", ApplicantInfo::getDateOfBirth);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[3]", ApplicantInfo::getPresentNationality);
      pdfFieldMap.put(
          "form1[0].#subform[0].PtAILine5_FirstName[0]",
          applicantInfo -> AbstractMapper.naIfBlank(applicantInfo.getFirstName()));
      pdfFieldMap.put(
          "form1[0].#subform[0].PtAILine6_MiddleName[0]",
          applicantInfo -> AbstractMapper.naIfBlank(applicantInfo.getMiddleName()));

      pdfFieldMap.put(
          "form1[0].#subform[0].PartALine9Gender[0]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(applicantInfo.getGender() == Gender.MALE, "M"));
      pdfFieldMap.put(
          "form1[0].#subform[0].PartALine9Gender[1]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(applicantInfo.getGender() == Gender.FEMALE, "F"));
      pdfFieldMap.put(
          "form1[0].#subform[0].Marital[0]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getMaritalStatus() == MaritalStatus.SINGLE, "S"));
      pdfFieldMap.put(
          "form1[0].#subform[0].Marital[1]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getMaritalStatus() == MaritalStatus.MARRIED, "M"));
      pdfFieldMap.put(
          "form1[0].#subform[0].Marital[2]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getMaritalStatus() == MaritalStatus.DIVORCED, "D"));
      pdfFieldMap.put(
          "form1[0].#subform[0].Marital[3]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getMaritalStatus() == MaritalStatus.WIDOWED, "W"));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField1[4]",
          applicantInfo ->
              String.join(" ", applicantInfo.getCityOfBirth(), applicantInfo.getCountryOfBirth()));
      pdfFieldMap.put("form1[0].#subform[0].TextField1[5]", ApplicantInfo::getNationalityAtBirth);
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField1[6]", ApplicantInfo::getRaceEthnicOrTribalGroup);
      pdfFieldMap.put("form1[0].#subform[0].TextField1[7]", ApplicantInfo::getReligion);
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox3[0]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getImmigrationCourtHistory() == ImmigrationCourtHistory.NEVER,
                  "A"));
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox3[1]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getImmigrationCourtHistory()
                      == ImmigrationCourtHistory.NOT_NOW_BUT_IN_THE_PAST,
                  "C"));
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox3[2]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.getImmigrationCourtHistory() == ImmigrationCourtHistory.CURRENTLY,
                  "B"));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField5[0]",
          applicantInfo ->
              AbstractMapper.noneIfBlank(applicantInfo.getCountryWhoLastIssuedPassport()));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField5[1]",
          applicantInfo -> AbstractMapper.noneIfBlank(applicantInfo.getPassportNumber()));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField5[2]",
          applicantInfo -> AbstractMapper.noneIfBlank(applicantInfo.getTravelDocumentNumber()));
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox31[0]",
          applicantInfo ->
              AbstractMapper.formatCheckbox(
                  applicantInfo.isAlsoApplyingConventionAgainstTorture(), "1"));
      pdfFieldMap.put("form1[0].#subform[0].DateTimeField2[1]", applicantInfo -> "");
      pdfFieldMap.put(
          "form1[0].#subform[0].DateTimeField2[2]",
          applicantInfo ->
              AbstractMapper.naIfBlank(applicantInfo.getTravelDocumentExpirationDate()));
      pdfFieldMap.put("form1[0].#subform[0].TextField7[0]", ApplicantInfo::getNativeLanguage);
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox4[0]",
          applicantInfo -> AbstractMapper.formatCheckbox(applicantInfo.isFluentInEnglish(), "Yes"));
      pdfFieldMap.put(
          "form1[0].#subform[0].CheckBox4[1]",
          applicantInfo -> AbstractMapper.formatCheckbox(!applicantInfo.isFluentInEnglish(), "No"));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField7[1]",
          applicantInfo ->
              AbstractMapper.noneIfBlank(String.join(",", applicantInfo.getOtherLanguages())));
      pdfFieldMap.put(
          "form1[0].#subform[0].TextField1[8]",
          applicantInfo -> AbstractMapper.noneIfBlank(applicantInfo.getUSISAccountNumber()));
      fieldMapping = pdfFieldMap;
      fieldMapping.putAll(new UsMailingAddressMapper().composeMapping(ApplicantInfo::getUsMailingAddress));
      fieldMapping.putAll(new UsResidenceMapper().composeMapping(ApplicantInfo::getUsResidence));
    }
    return fieldMapping;
  }
}
