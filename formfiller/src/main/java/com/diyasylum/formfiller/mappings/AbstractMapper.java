package com.diyasylum.formfiller.mappings;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractMapper<T> {

  /**
   * This method returns the literal mapping for the filler to use. returns a map of PDF fields to
   * functions that when the type is provided will return the value to put into that PDF field.
   */
  public abstract Map<String, Function<T, String>> getFormMapper();

  /**
   * This method is what allows us to break up a mapping. Instead of one large mapping for the
   * I589Application we can break it up and use this compose method to "bubble" them up.
   *
   * <p>For example. This method can convert a ApplicantInfo mapper to a I589Application mapper if
   * you provide it the function to get the Applicant info from the I589Application object. With
   * that converted mapper you can take the entries and add it to the I589Application mapper.
   * Allowing you to have just one mapper to provide to the pdf filler.
   *
   * <p>See I589ApplicationMapper to see this thing in use.
   *
   * <p>The AbstractMapper test also shows a toy example
   */
  public <S> Map<String, Function<S, String>> composeMapping(Function<S, T> typeMapping) {
    return getFormMapper()
        .entrySet()
        .stream()
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, entry -> (S s) -> entry.getValue().apply(typeMapping.apply(s))));
  }

  /**
   * This method is intended to handle the fact that the PDF can only handle so much text. If the
   * input is too long the alternative will be used. The alternative would be something like "See
   * supplement X"
   */
  public static String altIfTooLong(String input, int maxLength, String alternative) {
    return input.length() <= maxLength ? input : alternative;
  }

  public static String naIfBlank(String input) {
    return replaceIfBlank(input, "N/A");
  }

  public static String replaceIfBlank(String input, String replacement) {
    return StringUtils.isBlank(input) ? replacement : input;
  }

  /**
   * Checkboxes all define their own value for "on" but have the same off value if the condition is
   * true this will return the checkbox on value. Otherwise it will return "Off"
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
}
