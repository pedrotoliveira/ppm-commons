/*
 *     Copyright (C) 2020 - pedro.oliveira20@gmail.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit Tests for Strings#isBlank(String text)
 *
 * @author pedrotoliveira
 */
@RunWith(value = Parameterized.class)
public class StringsIsBlankTest {

    private final String text;
    private final Boolean expected;

    public StringsIsBlankTest(String text, Boolean expected) {
        this.text = text;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index}: (For text: {0}, we got: {1})")
    public static Collection<Object[]> parameters() {
        return asList(new Object[][]{
            {"", true},
            {"   ", false},
            {null, false},
            {"Paheo", false},
            {"aUYIAERNAIKMNAN  R4EJUJAIN", false}
        });
    }

    @Test
    public void test() {
        assertThat("Result should be equal to expected", Strings.isBlank(text), equalTo(expected));
    }
}
