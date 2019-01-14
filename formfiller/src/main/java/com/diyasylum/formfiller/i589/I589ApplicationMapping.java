package com.diyasylum.formfiller.i589;

import com.diyasylum.formfiller.application.models.I589Application;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

abstract class I589ApplicationMapping {
  // Right now this is mapping to string. This may eventually map to an object taking in a string
  // Basically "Give me a field and ill give you the object which gives you the text to validate and
  // fill in that field"
  static Map<String, Function<I589Application, String>> PDF_FIELD_MAP;

  static {
    // Using map.entries causes a compile warning so im reverting to this
    Map<String, Function<I589Application, String>> pdfFieldMap = new HashMap<>();
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine1_ANumber[0]",
        a -> a.getApplicantInfo().getAlienRegistrationNumber());
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[0]", a -> a.getApplicantInfo().getSocialSecurityNumber());
    pdfFieldMap.put("form1[0].#subform[0].PtAILine4_LastName[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_StreetNumandName[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField1[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[3]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine5_FirstName[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine6_MiddleName[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_AreaCode[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_TelephoneNumber[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_AptNumber[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_State[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine8_Zipcode[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_AptNumber[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_StreetNumandName[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_ZipCode[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_City[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_State[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PartALine9Gender[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PartALine9Gender[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].Marital[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].Marital[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].Marital[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].Marital[3]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[4]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[5]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[6]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[7]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox3[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox3[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox3[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField6[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField3[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField2[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField3[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[3]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField4[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[4]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField4[5]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField5[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField5[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField5[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox31[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_AreaCode[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField2[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField2[2]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].PtAILine9_InCareOf[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField7[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox4[0]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].CheckBox4[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField7[1]", a -> "");
    pdfFieldMap.put("form1[0].#subform[0].TextField1[8]", a -> "");
    I589ApplicationMapping.PDF_FIELD_MAP = Collections.unmodifiableMap(pdfFieldMap);
  }
}
