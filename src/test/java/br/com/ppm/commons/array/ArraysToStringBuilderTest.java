/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests of class ArrayToStringBuilder
 *
 * @author pedrotoliveira
 */
public class ArrayToStringBuilderTest {

    /**
     * Test of build method, of class ArrayToStringBuilder.
     */
    @Test
    public void testBuild() {
        String[] stringArray = new String[]{"one", "two", "three"};
        String result = new ArrayToStringBuilder(stringArray).build();
        String expected = "[one, two, three]";
        assertThat("toString of Array should be equal to expected", result, equalTo(expected));
    }

    /**
     * Test of build method, of class ArrayToStringBuilder.
     */
    @Test
    public void testBuildBigArray() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        String result = new ArrayToStringBuilder(array).build();
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, ...]";
        assertThat("toString of Array should be equal to expected", result, equalTo(expected));
    }

    @Test
    public void build() {
    }

    @Test
    public void testBuild1() {
    }

    @Test
    public void testBuild2() {
    }
}
