/*
 * Copyright (C) 2020 pedrotoliveira
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
package br.com.ppm.commons.formatter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit tests of class HtmlStackTraceFormatter
 *
 * @author pedrotoliveira
 */
public class HtmlStackTraceFormatterTest {

    /**
     * Test of formatToString method, of class HtmlStackTraceFormatter.
     */
    @Test
    public void testFormatToString() {
        Throwable throwable = new RuntimeException("test format to string");
        String result = new HtmlStackTraceFormatter().formatToString(throwable);
        String expected = "<div id=\"stacktrace\">java.lang.RuntimeException: test format to string<br />\n"
                + "	at br.com.ppm.commons.formatter.HtmlStackTraceFormatterTest.testFormatToString(HtmlStackTraceFormatterTest.java:36)<br />\n";

        assertThat("Expect a string that contains: ".concat(expected), result, containsString(expected));
    }
}
