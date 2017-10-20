/*
 * Copyright (C) 2017 pedrotoliveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons;

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

}
