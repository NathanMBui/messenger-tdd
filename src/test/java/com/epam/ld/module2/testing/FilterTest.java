package com.epam.ld.module2.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

public class FilterTest {

    @Test
    @DisabledIf("isMacOS")
    public void testMetaAnnotationAndFiltering() {
        //this test should not be run in mac OSX
    }

    public boolean isMacOS() {
        return java.lang.System.getProperty("os.name").toLowerCase().contains("mac");
    }
}
