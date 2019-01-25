package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.*;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class I589ApplicationMapper extends AbstractMapper<I589Application> {
  public static final String FORM_URL =
      "https://www.uscis.gov/system/files_force/files/form/i-589.pdf?download=1";
  public static final String SUPPORTED_FORM_REVISION = "Form I-589 (Rev. 05/16/17) N";

  private static Map<String, Function<I589Application, String>> fieldMapping;

  @Override
  public Map<String, Function<I589Application, String>> getFormMapper() {
    if (fieldMapping == null) {
      fieldMapping = new HashMap<>();
      fieldMapping.putAll(
          new UsTravelHistoryMapper().composeMapping(I589Application::getUsTravelHistory));
      fieldMapping.putAll(
          new ApplicantInfoMapper().composeMapping(I589Application::getApplicantInfo));
    }
    return fieldMapping;
  }
}
