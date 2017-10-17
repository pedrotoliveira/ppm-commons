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

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author pedrotoliveira
 */
public class ValidatorTest {


	@Before
	public void setUp() {
	}

    @Test(expected = IllegalArgumentException.class)
    public void testNotNullParameter() {
        Validator.notNullParameter(null, "some param");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testNotEmptyParameter() {
        Validator.notEmptyParameter(new String[]{}, "String Array");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testNoNullElementsParameter() {
        Validator.noNullElementsParameter(new String[]{"one", null, "three"}, "String Array");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotEmpty() {
        Validator.isNotEmpty("", "string");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testCorrectSize() {
        Collection<?> collection = Arrays.asList(new String[]{"one", "two", "three"});
        Validator.correctSize(collection, 5, "collection");
	}

    @Test(expected = NoSuchElementException.class)
    public void testHandleNoSuchElement() {
        throw Validator.handleNoSuchElement("element");
	}

    @Test(expected = IllegalArgumentException.class)
    public void testHandleIllegalArgumentException() {
        throw Validator.handleIllegalArgumentException("argument");
	}

    @Test(expected = IllegalStateException.class)
    public void testHandleIllegalStateException() {
        throw Validator.handleIllegalStateException("message");
	}

}
