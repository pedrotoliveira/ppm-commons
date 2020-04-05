/*
 * Copyright (C) 2018 pedrotoliveira
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

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Class EmailPatternTest
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 12/05/18 10:05
 */
@RunWith(value = Parameterized.class)
public class EmailPatternTest {
    
    private final String email;
    private final boolean expected;
    
    
    public EmailPatternTest(String email, String expected) {
        this.email = email;
        this.expected = Boolean.parseBoolean(expected);
    }
    
    @Parameterized.Parameters(name = "Case {index}: (Email: {0}, should be: {1})")
    public static Collection<String[]> parameters() {
        return asList(new String[][]{
                {"pedro.oliveira20@gmail.com", "true"},
                {"email@müller.de", "false"},
                {"user@78.47.122.114", "true"},
                {"user.100@email.com.au", "true"},
                {"User.100@email.com.de", "true"},
                {"User-100@email.com.au", "true"},
                {"a-100@yahoo.com.br", "true"},
                {"Chuck Norris <gmail@chucknorris.com>", "false"},
                {"chucknorris@gmail.com", "true"},
                {"pedro.oliveira20()@gmail.com", "false"},
                {"em  ail@müller.de", "false"},
                {"あいうえお@example.com", "false"},
                {"user.100@email.com.", "false"},
                {"User.100email.com.de", "false"},
                {"User-100@com.com.au", "true"},
                {"-100@yahoo.com.r", "false"},
        });
    }
    
    /**
     * Test of capitalizeFirstLetter method, of class Strings.
     */
    @Test
    public void test() {
        assertThat("Check Email Pattern", new EmailPattern(email).matches(), equalTo(expected));
    }
}