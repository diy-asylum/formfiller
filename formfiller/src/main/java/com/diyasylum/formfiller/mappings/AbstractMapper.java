package com.diyasylum.formfiller.mappings;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractMapper<T> {

  public static String naIfBlank(String input) {
    return replaceIfBlank(input, "N/A");
  }

  public static String replaceIfBlank(String input, String replacement) {
    return StringUtils.isBlank(input) ? replacement : input;
  }

  /*
   * Checkboxes all define their own value for "on" but have the same off value
   * if the condition is true this will return the checkbox on value. Otherwise it will
   * return "Off"
   */
  public static String formatCheckbox(boolean condition, String checkedValue) {
    return condition ? checkedValue : "Off";
  }

  public static <T> Optional<T> safeListAccess(List<T> list, int index) {
    if (index < 0 || index >= list.size()) {
      return Optional.empty();
    } else {
      return Optional.of(list.get(index));
    }
  }

  public static String noneIfBlank(String input) {
    return replaceIfBlank(input, "NONE");
  }

  public abstract Map<String, Function<T, String>> getFormMapper();

  public <S> Map<String, Function<S, String>> composeMapping(Function<S, T> typeMapping) {
    return getFormMapper()
        .entrySet()
        .stream()
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, entry -> (S s) -> entry.getValue().apply(typeMapping.apply(s))));
  }
}
