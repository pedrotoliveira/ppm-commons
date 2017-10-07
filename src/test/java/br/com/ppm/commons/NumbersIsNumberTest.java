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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit Tests For Numbers Class
 *
 * @author pedrotoliveira
 */
@RunWith(value = Parameterized.class)
public class NumbersIsNumberTest {

    private final String text;
    private final Boolean expected;

    public NumbersIsNumberTest(String text, Boolean expected) {
        this.text = text;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index}: (For text: {0}, we got: {1})")
    public static Object[][] parameters() {
        return new Object[][]{
            {"123", true},
            {null, false},
            {"", false},
            {"15135889447155841714711811651889186863888", true}
        };
    }

    /**
     * Test of isNumber method, of class Numbers.
     */
    @Test
    public void test() {
        assertThat(Numbers.isNumber(text), equalTo(expected));
    }

}
