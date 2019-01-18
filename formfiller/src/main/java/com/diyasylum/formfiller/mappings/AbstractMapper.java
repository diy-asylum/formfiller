package com.diyasylum.formfiller.mappings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractMapper<T> {

    public abstract Map<String, Function<T, String>> getFormMapper();

    public <S> Map<String, Function<S, String>> composeMapping(Function<S, T> typeMapping) {
        return getFormMapper()
                .entrySet()
                .stream()
                .collect(
                    Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> (S s) -> entry.getValue().apply(typeMapping.apply(s))
                    )
                );

    }
}
