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
package br.com.ppm.commons.validation;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Unit tests of class Validator
 *
 * @author pedrotoliveira
 */
public class ArgumentValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNotNullParameter() {
        ArgumentValidator.notNullParameter(null, "some param");
	}

	@Test
	public void shoudPassWhenParameterNotNull() {
        ArgumentValidator.notNullParameter("Not Null", "some param");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEmptyParameter() {
        ArgumentValidator.notEmptyParameter(new String[]{}, "String Array");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testNoNullElementsParameter() {
        ArgumentValidator.noNullElementsParameter(new String[]{"one", null, "three"}, "String Array");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotEmpty() {
        ArgumentValidator.isNotEmpty("", "string");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testCorrectSize() {
        Collection<?> collection = Arrays.asList("one", "two", "three");
        ArgumentValidator.correctSize(collection, 5, "collection");
	}

    @Test(expected = NoSuchElementException.class)
    public void testHandleNoSuchElement() {
        throw ArgumentValidator.handleNoSuchElement("element");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testHandleIllegalArgumentException() {
        throw ArgumentValidator.handleIllegalArgumentException("argument");
	}

    @Test(expected = IllegalStateException.class)
    public void testHandleIllegalStateException() {
        throw ArgumentValidator.handleIllegalStateException("message");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEmail() {
        ArgumentValidator.isValidEmail("email@aeh.cio.", "email");
    }

    @Test
    public void testValidEmail() {
        ArgumentValidator.isValidEmail("pedro.oliveira20@gmail.com", "email");
    }

    @Test
    public void testValidCondition() {
        ArgumentValidator.isTrue(true, "Should Not throw exception");
    }
}
