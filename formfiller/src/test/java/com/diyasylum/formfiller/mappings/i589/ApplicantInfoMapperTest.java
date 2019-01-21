package com.diyasylum.formfiller.mappings.i589;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.TestUtils;
import com.diyasylum.formfiller.application.models.ApplicantInfo;
import com.diyasylum.formfiller.application.models.Gender;
import com.diyasylum.formfiller.application.models.ImmigrationCourtHistory;
import com.diyasylum.formfiller.application.models.MaritalStatus;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ApplicantInfoMapperTest {

  @Test
  void testBasicMapping() {
    ApplicantInfo applicantInfo = TestUtils.exampleApplication().getApplicantInfo();
    Map<String, String> result =
        new ApplicantInfoMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(applicantInfo)));
    Map<String, String> expected =
        Map.ofEntries(
            Map.entry("form1[0].#subform[0].PtAILine6_MiddleName[0]", "Benjamin"),
            Map.entry("form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]", "3230122"),
            Map.entry("form1[0].#subform[0].PtAILine9_InCareOf[0]", "May Parker"),
            Map.entry("form1[0].#subform[0].CheckBox3[1]", "Off"),
            Map.entry("form1[0].#subform[0].CheckBox4[0]", "Yes"),
            Map.entry("form1[0].#subform[0].PtAILine8_AptNumber[0]", "6"),
            Map.entry("form1[0].#subform[0].PtAILine9_AreaCode[0]", "212"),
            Map.entry("form1[0].#subform[0].PartALine9Gender[0]", "M"),
            Map.entry("form1[0].#subform[0].PtAILine9_ZipCode[0]", "10020"),
            Map.entry("form1[0].#subform[0].TextField1[1]", "Spider-man"),
            Map.entry("form1[0].#subform[0].PtAILine8_State[0]", "New York"),
            Map.entry("form1[0].#subform[0].DateTimeField1[0]", "8/10/1962"),
            Map.entry("form1[0].#subform[0].PtAILine9_AptNumber[0]", "6"),
            Map.entry("form1[0].#subform[0].PtAILine4_LastName[0]", "Parker"),
            Map.entry("form1[0].#subform[0].Marital[1]", "M"),
            Map.entry("form1[0].#subform[0].TextField1[7]", "Christian"),
            Map.entry("form1[0].#subform[0].TextField5[1]", "999999999"),
            Map.entry("form1[0].#subform[0].PtAILine8_StreetNumandName[0]", "135 W. 50th Street"),
            Map.entry("form1[0].#subform[0].TextField1[3]", "Chinese"),
            Map.entry("form1[0].#subform[0].PtAILine8_TelephoneNumber[0]", "3230122"),
            Map.entry("form1[0].#subform[0].TextField7[1]", "English,Spanish"),
            Map.entry("form1[0].#subform[0].Marital[3]", "Off"),
            Map.entry("form1[0].#subform[0].TextField1[5]", "Chinese"),
            Map.entry("form1[0].#subform[0].PtAILine9_StreetNumandName[0]", "7 34th street"),
            Map.entry("form1[0].#subform[0].PtAILine9_State[0]", "New York"),
            Map.entry("form1[0].#subform[0].PtAILine5_FirstName[0]", "Peter"),
            Map.entry("form1[0].#subform[0].CheckBox3[2]", "Off"),
            Map.entry("form1[0].#subform[0].CheckBox4[1]", "Off"),
            Map.entry("form1[0].#subform[0].PtAILine9_City[0]", "New York"),
            Map.entry("form1[0].#subform[0].CheckBox3[0]", "A"),
            Map.entry("form1[0].#subform[0].PtAILine1_ANumber[0]", "4234912"),
            Map.entry("form1[0].#subform[0].PartALine9Gender[1]", "Off"),
            Map.entry("form1[0].#subform[0].TextField1[0]", "234-22-1113"),
            Map.entry("form1[0].#subform[0].CheckBox31[0]", "1"),
            Map.entry("form1[0].#subform[0].PtAILine8_AreaCode[0]", "212"),
            Map.entry("form1[0].#subform[0].TextField1[2]", "New York"),
            Map.entry("form1[0].#subform[0].DateTimeField2[2]", "12-12-9999"),
            Map.entry("form1[0].#subform[0].Marital[2]", "Off"),
            Map.entry("form1[0].#subform[0].TextField5[2]", "29312"),
            Map.entry("form1[0].#subform[0].TextField1[8]", "A012345678"),
            Map.entry("form1[0].#subform[0].TextField7[0]", "Chinese"),
            Map.entry("form1[0].#subform[0].Marital[0]", "Off"),
            Map.entry("form1[0].#subform[0].TextField5[0]", "China"),
            Map.entry("form1[0].#subform[0].PtAILine8_Zipcode[0]", "10020"),
            Map.entry("form1[0].#subform[0].TextField1[4]", "Beijing China"),
            Map.entry("form1[0].#subform[0].TextField1[6]", "Asian"));

    assertEquals(expected, result);
  }

  @Test
  void testEmptyMapping() {
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder().createApplicantInfo();
    Map<String, String> result =
        new ApplicantInfoMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(applicantInfo)));
    Map<String, String> expected =
        Map.ofEntries(
            Map.entry("form1[0].#subform[0].PtAILine6_MiddleName[0]", "N/A"),
            Map.entry("form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]", ""),
            Map.entry("form1[0].#subform[0].PtAILine9_InCareOf[0]", "N/A"),
            Map.entry("form1[0].#subform[0].CheckBox3[1]", "Off"),
            Map.entry("form1[0].#subform[0].CheckBox4[0]", "Yes"),
            Map.entry("form1[0].#subform[0].PtAILine8_AptNumber[0]", ""),
            Map.entry("form1[0].#subform[0].PtAILine9_AreaCode[0]", ""),
            Map.entry("form1[0].#subform[0].PartALine9Gender[0]", "M"),
            Map.entry("form1[0].#subform[0].PtAILine9_ZipCode[0]", ""),
            Map.entry("form1[0].#subform[0].TextField1[1]", ""),
            Map.entry("form1[0].#subform[0].PtAILine8_State[0]", ""),
            Map.entry("form1[0].#subform[0].DateTimeField1[0]", ""),
            Map.entry("form1[0].#subform[0].PtAILine9_AptNumber[0]", ""),
            Map.entry("form1[0].#subform[0].PtAILine4_LastName[0]", "N/A"),
            Map.entry("form1[0].#subform[0].Marital[1]", "M"),
            Map.entry("form1[0].#subform[0].TextField1[7]", ""),
            Map.entry("form1[0].#subform[0].TextField5[1]", "NONE"),
            Map.entry("form1[0].#subform[0].PtAILine8_StreetNumandName[0]", " "),
            Map.entry("form1[0].#subform[0].TextField1[3]", ""),
            Map.entry("form1[0].#subform[0].PtAILine8_TelephoneNumber[0]", ""),
            Map.entry("form1[0].#subform[0].TextField7[1]", "NONE"),
            Map.entry("form1[0].#subform[0].Marital[3]", "Off"),
            Map.entry("form1[0].#subform[0].TextField1[5]", ""),
            Map.entry("form1[0].#subform[0].PtAILine9_StreetNumandName[0]", " "),
            Map.entry("form1[0].#subform[0].PtAILine9_State[0]", ""),
            Map.entry("form1[0].#subform[0].PtAILine5_FirstName[0]", "N/A"),
            Map.entry("form1[0].#subform[0].CheckBox3[2]", "Off"),
            Map.entry("form1[0].#subform[0].CheckBox4[1]", "Off"),
            Map.entry("form1[0].#subform[0].PtAILine9_City[0]", ""),
            Map.entry("form1[0].#subform[0].CheckBox3[0]", "A"),
            Map.entry("form1[0].#subform[0].PtAILine1_ANumber[0]", "NONE"),
            Map.entry("form1[0].#subform[0].PartALine9Gender[1]", "Off"),
            Map.entry("form1[0].#subform[0].TextField1[0]", ""),
            Map.entry("form1[0].#subform[0].CheckBox31[0]", "1"),
            Map.entry("form1[0].#subform[0].PtAILine8_AreaCode[0]", ""),
            Map.entry("form1[0].#subform[0].TextField1[2]", ""),
            Map.entry("form1[0].#subform[0].DateTimeField2[2]", "N/A"),
            Map.entry("form1[0].#subform[0].Marital[2]", "Off"),
            Map.entry("form1[0].#subform[0].TextField5[2]", "NONE"),
            Map.entry("form1[0].#subform[0].TextField1[8]", "NONE"),
            Map.entry("form1[0].#subform[0].TextField7[0]", ""),
            Map.entry("form1[0].#subform[0].Marital[0]", "Off"),
            Map.entry("form1[0].#subform[0].TextField5[0]", "NONE"),
            Map.entry("form1[0].#subform[0].PtAILine8_Zipcode[0]", ""),
            Map.entry("form1[0].#subform[0].TextField1[4]", " "),
            Map.entry("form1[0].#subform[0].TextField1[6]", ""));

    assertEquals(expected, result);
  }

  @Test
  void genderCheckbox() {
    ApplicantInfoMapper applicantInfoMapper = new ApplicantInfoMapper();
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setGender(Gender.MALE)
            .createApplicantInfo();
    String maleCheckboxValue =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].PartALine9Gender[0]")
            .apply(applicantInfo);
    String femaleCheckboxValue =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].PartALine9Gender[1]")
            .apply(applicantInfo);

    assertEquals("M", maleCheckboxValue);
    assertEquals("Off", femaleCheckboxValue);
    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setGender(Gender.FEMALE)
            .createApplicantInfo();
    maleCheckboxValue =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].PartALine9Gender[0]")
            .apply(applicantInfo);
    femaleCheckboxValue =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].PartALine9Gender[1]")
            .apply(applicantInfo);

    assertEquals("Off", maleCheckboxValue);
    assertEquals("F", femaleCheckboxValue);
  }

  @Test
  void testMaritalStatusCheckbox() {
    ApplicantInfoMapper applicantInfoMapper = new ApplicantInfoMapper();
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setMaritalStatus(MaritalStatus.MARRIED)
            .createApplicantInfo();
    String singleCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[0]")
            .apply(applicantInfo);
    String marriedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[1]")
            .apply(applicantInfo);
    String divorcedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[2]")
            .apply(applicantInfo);
    String widowedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[3]")
            .apply(applicantInfo);

    assertEquals("Off", singleCheckbox);
    assertEquals("M", marriedCheckbox);
    assertEquals("Off", divorcedCheckbox);
    assertEquals("Off", widowedCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setMaritalStatus(MaritalStatus.SINGLE)
            .createApplicantInfo();
    singleCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[0]")
            .apply(applicantInfo);
    marriedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[1]")
            .apply(applicantInfo);
    divorcedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[2]")
            .apply(applicantInfo);
    widowedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[3]")
            .apply(applicantInfo);
    assertEquals("S", singleCheckbox);
    assertEquals("Off", marriedCheckbox);
    assertEquals("Off", divorcedCheckbox);
    assertEquals("Off", widowedCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setMaritalStatus(MaritalStatus.DIVORCED)
            .createApplicantInfo();
    singleCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[0]")
            .apply(applicantInfo);
    marriedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[1]")
            .apply(applicantInfo);
    divorcedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[2]")
            .apply(applicantInfo);
    widowedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[3]")
            .apply(applicantInfo);
    assertEquals("Off", singleCheckbox);
    assertEquals("Off", marriedCheckbox);
    assertEquals("D", divorcedCheckbox);
    assertEquals("Off", widowedCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setMaritalStatus(MaritalStatus.WIDOWED)
            .createApplicantInfo();
    singleCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[0]")
            .apply(applicantInfo);
    marriedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[1]")
            .apply(applicantInfo);
    divorcedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[2]")
            .apply(applicantInfo);
    widowedCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].Marital[3]")
            .apply(applicantInfo);
    assertEquals("Off", singleCheckbox);
    assertEquals("Off", marriedCheckbox);
    assertEquals("Off", divorcedCheckbox);
    assertEquals("W", widowedCheckbox);
  }

  @Test
  void testImmigrationCourtCheckbox() {
    ApplicantInfoMapper applicantInfoMapper = new ApplicantInfoMapper();
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setImmigrationCourtHistory(ImmigrationCourtHistory.NEVER)
            .createApplicantInfo();
    String neverCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[0]")
            .apply(applicantInfo);
    String inThePastCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[1]")
            .apply(applicantInfo);
    String currentlyCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[2]")
            .apply(applicantInfo);

    assertEquals("A", neverCheckbox);
    assertEquals("Off", inThePastCheckbox);
    assertEquals("Off", currentlyCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setImmigrationCourtHistory(ImmigrationCourtHistory.CURRENTLY)
            .createApplicantInfo();
    neverCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[0]")
            .apply(applicantInfo);
    inThePastCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[1]")
            .apply(applicantInfo);
    currentlyCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[2]")
            .apply(applicantInfo);

    assertEquals("Off", neverCheckbox);
    assertEquals("Off", inThePastCheckbox);
    assertEquals("B", currentlyCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setImmigrationCourtHistory(ImmigrationCourtHistory.NOT_NOW_BUT_IN_THE_PAST)
            .createApplicantInfo();
    neverCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[0]")
            .apply(applicantInfo);
    inThePastCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[1]")
            .apply(applicantInfo);
    currentlyCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox3[2]")
            .apply(applicantInfo);

    assertEquals("Off", neverCheckbox);
    assertEquals("C", inThePastCheckbox);
    assertEquals("Off", currentlyCheckbox);
  }

  @Test
  void testEnglishFluencyCheckbox() {
    ApplicantInfoMapper applicantInfoMapper = new ApplicantInfoMapper();
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setFluentInEnglish(true)
            .createApplicantInfo();
    String fluentYesCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox4[0]")
            .apply(applicantInfo);
    String fluentNoCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox4[1]")
            .apply(applicantInfo);

    assertEquals("Yes", fluentYesCheckbox);
    assertEquals("Off", fluentNoCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setFluentInEnglish(false)
            .createApplicantInfo();
    fluentYesCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox4[0]")
            .apply(applicantInfo);
    fluentNoCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox4[1]")
            .apply(applicantInfo);
    assertEquals("Off", fluentYesCheckbox);
    assertEquals("No", fluentNoCheckbox);
  }

  @Test
  void testTortureCheckbox() {
    ApplicantInfoMapper applicantInfoMapper = new ApplicantInfoMapper();
    ApplicantInfo applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setAlsoApplyingConventionAgainstTorture(true)
            .createApplicantInfo();
    String tortureCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox31[0]")
            .apply(applicantInfo);

    assertEquals("1", tortureCheckbox);

    applicantInfo =
        TestUtils.emptyAsPossibleApplicantInfoBuilder()
            .setAlsoApplyingConventionAgainstTorture(false)
            .createApplicantInfo();
    tortureCheckbox =
        applicantInfoMapper
            .getFormMapper()
            .get("form1[0].#subform[0].CheckBox31[0]")
            .apply(applicantInfo);
    assertEquals("Off", tortureCheckbox);
  }
}
