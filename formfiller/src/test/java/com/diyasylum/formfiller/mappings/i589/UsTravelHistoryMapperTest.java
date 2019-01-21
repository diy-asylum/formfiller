package com.diyasylum.formfiller.mappings.i589;

import static org.junit.jupiter.api.Assertions.*;

import com.diyasylum.formfiller.application.models.UsTravelEventBuilder;
import com.diyasylum.formfiller.application.models.UsTravelHistory;
import com.diyasylum.formfiller.application.models.UsTravelHistoryBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UsTravelHistoryMapperTest {

  @Test
  void fullTravelHistory() {
    UsTravelHistory usTravelHistory =
        new UsTravelHistoryBuilder()
            .setDateStatusExpires("12/12/2012")
            .setI94Number("i19")
            .setLastLeftHomeCountry("13/13/13")
            .setTravelEvents(
                Arrays.asList(
                    new UsTravelEventBuilder()
                        .setDate("1/1/1")
                        .setPlace("firstPlace")
                        .setStatus("firstStatus")
                        .createUsTravelEvent(),
                    new UsTravelEventBuilder()
                        .setDate("2/2/2")
                        .setPlace("secondPlace")
                        .setStatus("secondStatus")
                        .createUsTravelEvent(),
                    new UsTravelEventBuilder()
                        .setDate("3/3/3")
                        .setPlace("thirdPlace")
                        .setStatus("thirdStatus")
                        .createUsTravelEvent()))
            .createUsTravelHistory();

    Map<String, String> result =
        new UsTravelHistoryMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(usTravelHistory)));
    assertEquals(
        Map.ofEntries(
            Map.entry("form1[0].#subform[0].DateTimeField2[0]", "1/1/1"),
            Map.entry("form1[0].#subform[0].TextField3[0]", "i19"),
            Map.entry("form1[0].#subform[0].DateTimeField2[1]", "12/12/2012"),
            Map.entry("form1[0].#subform[0].DateTimeField6[0]", "13/13/13"),
            Map.entry("form1[0].#subform[0].TextField4[2]", "secondPlace"),
            Map.entry("form1[0].#subform[0].TextField4[3]", "secondStatus"),
            Map.entry("form1[0].#subform[0].DateTimeField4[0]", "3/3/3"),
            Map.entry("form1[0].#subform[0].DateTimeField3[0]", "2/2/2"),
            Map.entry("form1[0].#subform[0].TextField4[0]", "firstPlace"),
            Map.entry("form1[0].#subform[0].TextField4[1]", "firstStatus"),
            Map.entry("form1[0].#subform[0].TextField4[4]", "thirdPlace"),
            Map.entry("form1[0].#subform[0].TextField4[5]", "thirdStatus")),
        result);
  }

  @Test
  void emptyTravelHistory() {
    UsTravelHistory usTravelHistory =
        new UsTravelHistoryBuilder()
            .setDateStatusExpires("12/12/2012")
            .setI94Number("i19")
            .setLastLeftHomeCountry("13/13/13")
            .setTravelEvents(Collections.emptyList())
            .createUsTravelHistory();

    Map<String, String> result =
        new UsTravelHistoryMapper()
            .getFormMapper()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(usTravelHistory)));
    assertEquals(
        Map.ofEntries(
            Map.entry("form1[0].#subform[0].DateTimeField2[0]", ""),
            Map.entry("form1[0].#subform[0].TextField3[0]", "i19"),
            Map.entry("form1[0].#subform[0].DateTimeField2[1]", "12/12/2012"),
            Map.entry("form1[0].#subform[0].DateTimeField6[0]", "13/13/13"),
            Map.entry("form1[0].#subform[0].TextField4[2]", ""),
            Map.entry("form1[0].#subform[0].TextField4[3]", ""),
            Map.entry("form1[0].#subform[0].DateTimeField4[0]", ""),
            Map.entry("form1[0].#subform[0].DateTimeField3[0]", ""),
            Map.entry("form1[0].#subform[0].TextField4[0]", ""),
            Map.entry("form1[0].#subform[0].TextField4[1]", ""),
            Map.entry("form1[0].#subform[0].TextField4[4]", ""),
            Map.entry("form1[0].#subform[0].TextField4[5]", "")),
        result);
  }
}
