/*
 * Copyright (C) 2020.
 */

package br.com.ppm.commons.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class WrapperToStringBuilderTest {

    private final Object object;
    private final String expected;

    public WrapperToStringBuilderTest(Object object, String expected) {
        this.object = object;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index}: (For Wrapper Object: {0}, we got: {1})")
    public static Object[][] parameters() {
        return new Object[][]{
                {Boolean.TRUE, "true"},
                {true, "true"},
                {false, "false"}
        };
    }

    @Test
    public void build() {
    }

    @Test
    public void testBuild() {
    }

    @Test
    public void testBuild1() {
    }
}