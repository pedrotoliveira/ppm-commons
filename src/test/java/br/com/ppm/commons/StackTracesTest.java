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
 * Unit tests of class StackTraces
 *
 * @author pedrotoliveira
 */
public class StackTracesTest {

    /**
     * Test of toString method, of class StackTraces.
     */
    @Test
    public void testToString() {
        Throwable throwable = new RuntimeException("testToString");
        String result = StackTraces.toString(throwable, StackTraceFormatters.HTML);
        String expected = StackTraceFormatters.HTML.formatToString(throwable);
        assertThat("Expect a string like: ".concat(expected), result, equalTo(expected));
    }

    /**
     * Test of toString method, of class StackTraces.
     */
    @Test
    public void testToStringDefault() {
        Throwable throwable = new RuntimeException("testToStringDefault");
        String result = StackTraces.toString(throwable);
        String expected = StackTraceFormatters.PLAIN_TEXT.formatToString(throwable);
        assertThat("Expect a string like: ".concat(expected), result, equalTo(expected));
    }
}
