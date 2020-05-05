/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.array;

import br.com.ppm.commons.collection.Seq;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Unit tests of class ArrayToStringBuilder
 *
 * @author pedrotoliveira
 */
public class ArraysToStringBuilderTest {

    @Test
    public void testBuild() {
        Object[] stringArray = {"one", "two", "three"};
        String result = new ArraysToStringBuilder(stringArray).build();
        assertThat(result).isEqualTo("['one', 'two', 'three']");
    }

    @Test
    public void testBuildBigArray() {
        Object[] array = Seq.array(1, 25);
        String result = new ArraysToStringBuilder(array).build();
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, ...]");
    }

    @Test
    public void testBuildMaxPageSize() {
        Object[] array = Seq.array(1, 15);
        String result = new ArraysToStringBuilder(array).build();
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]");
    }
}
