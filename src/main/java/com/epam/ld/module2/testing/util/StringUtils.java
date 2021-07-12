package com.epam.ld.module2.testing.util;

public class StringUtils {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean anyNullOrEmpty(String... values) {
        for (String value: values) {
            if (isNullOrEmpty(value)) {
                return true;
            }
        }
        return false;
    }
}
