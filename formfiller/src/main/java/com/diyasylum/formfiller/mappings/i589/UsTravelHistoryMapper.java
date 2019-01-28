package com.diyasylum.formfiller.mappings.i589;

import com.diyasylum.formfiller.application.models.UsTravelEvent;
import com.diyasylum.formfiller.application.models.UsTravelHistory;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.Map;
import java.util.function.Function;

public class UsTravelHistoryMapper extends AbstractMapper<UsTravelHistory> {
  private static Map<String, Function<UsTravelHistory, String>> fieldMapping;

  @Override
  public Map<String, Function<UsTravelHistory, String>> getFormMapper() {
    if (fieldMapping == null) {
      fieldMapping =
          Map.ofEntries(
              Map.entry(
                  "form1[0].#subform[0].DateTimeField2[1]", UsTravelHistory::getDateStatusExpires),
              Map.entry(
                  "form1[0].#subform[0].DateTimeField6[0]",
                  UsTravelHistory::getLastLeftHomeCountry),
              Map.entry("form1[0].#subform[0].TextField3[0]", this::formatI94Number),
              Map.entry(
                  "form1[0].#subform[0].DateTimeField2[0]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 0)
                          .map(UsTravelEvent::getDate)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[0]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 0)
                          .map(UsTravelEvent::getPlace)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[1]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 0)
                          .map(UsTravelEvent::getStatus)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].DateTimeField3[0]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 1)
                          .map(UsTravelEvent::getDate)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[2]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 1)
                          .map(UsTravelEvent::getPlace)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[3]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 1)
                          .map(UsTravelEvent::getStatus)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].DateTimeField4[0]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 2)
                          .map(UsTravelEvent::getDate)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[4]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 2)
                          .map(UsTravelEvent::getPlace)
                          .orElse("")),
              Map.entry(
                  "form1[0].#subform[0].TextField4[5]",
                  usTravelHistory ->
                      AbstractMapper.safeListAccess(usTravelHistory.getTravelEvents(), 2)
                          .map(UsTravelEvent::getStatus)
                          .orElse("")));
    }
    return fieldMapping;
  }

  private String formatI94Number(UsTravelHistory usTravelHistory) {
    return AbstractMapper.noneIfBlank(usTravelHistory.getI94Number());
  }
}
