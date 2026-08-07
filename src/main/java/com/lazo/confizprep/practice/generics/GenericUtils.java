package com.lazo.confizprep.practice.generics;

import java.util.List;
import java.util.Optional;

public class GenericUtils {

    public static <T> Optional<T> getFirst(List<T> values) {
        if (values == null || values.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(values.getFirst());
    }

    public static <T> boolean contains(
            List<T> values,
            T target
    ) {
        for (T value : values) {
            if (value.equals(target)) {
                return true;
            }
        }

        return false;
    }
}