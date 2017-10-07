/*
 * Copyright (C) 2017 ppm
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

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for Class Strings
 *
 * @author pedrotoliveira
 */
@RunWith(value = Parameterized.class)
public class StringsCapitalizeFirstLetterTest {

    private final String text;
    private final String expected;

    public StringsCapitalizeFirstLetterTest(String text, String expected) {
        this.text = text;
        this.expected = expected;
    }

    @Parameters(name = "Case {index}: (For text: {0}, we got: {1})")
    public static Collection<String[]> parameters() {
        return asList(new String[][]{
            {"jaurl", "Jaurl"},
            {"ayenal", "Ayenal"},
            {"Paheo", "Paheo"},
            {"aUYIAERNAIKMNAN  R4EJUJAIN", "AUYIAERNAIKMNAN  R4EJUJAIN"}
        });
    }

    /**
     * Test of capitalizeFirstLetter method, of class Strings.
     */
    @Test
    public void test() {
        assertThat(Strings.capitalizeFirstLetter(text), equalTo(expected));
    }

}
