package com.epam.ld.module2.testing.util;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullOrEmptyStrings(String input) {
        assertTrue(StringUtils.isNullOrEmpty(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "123"})
    public void testNonEmptyStrings(String input) {
        assertFalse(StringUtils.isNullOrEmpty(input));
    }

    @TestFactory
    public Stream<DynamicTest> dynamicTestString() {
        List<String> inputList = Arrays.asList("abc123", "aew", "  ");

        return inputList.stream().map(s -> DynamicTest.dynamicTest(
                "test: " + s,
                () -> {
                    assertFalse(StringUtils.isNullOrEmpty(s));
                }));
    }
}
