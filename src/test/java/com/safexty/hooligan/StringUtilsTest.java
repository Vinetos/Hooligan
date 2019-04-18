package com.safexty.hooligan;

import org.junit.Test;

import static com.safexty.hooligan.utils.StringUtils.isNumber;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testNumberAreFound() {
        // Good input
        assertTrue(isNumber("0"));
        assertTrue(isNumber("9"));
        assertTrue(isNumber("-3"));
        assertTrue(isNumber("-0"));

        assertTrue(isNumber("41862486"));
        assertTrue(isNumber("-65542"));

        assertTrue(isNumber("48117.5498178"));
        assertTrue(isNumber("-0.333333"));

        // Bad input
        assertFalse(isNumber(null));

        assertFalse(isNumber(""));
        assertFalse(isNumber("-"));

        assertFalse(isNumber("418.62486.5498178"));

        assertFalse(isNumber("hey"));
    }
}
