package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.*;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class I589ApplicationMapper extends AbstractMapper<I589Application> {

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
