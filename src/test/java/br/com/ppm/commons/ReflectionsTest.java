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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

import br.com.ppm.commons.model.Address;
import br.com.ppm.commons.model.Card;
import br.com.ppm.commons.model.Person;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Reflections Unit Tests
 *
 * @author pedrotoliveira
 */
public class ReflectionsTest {

    private Card card;

    @Before
    public void beforeEach() {
        this.card = createRandomCard();
    }

    private Card createRandomCard() {
        String[] numbers = {"5433314767598593", "4916786376775069", "6011129186515608", "348731465602655"};
        String[] cvvs = {"212", "965", "524", "487"};
        int randomIndex = new Random().nextInt(numbers.length);
        return new Card(numbers[randomIndex], cvvs[randomIndex]);
    }

    @Test
    public void testMethodGet() throws Exception {
        Field field = Card.class.getDeclaredField("ccNumber");
        String methodGet = Reflections.methodGet(field);
        assertThat("It should be equal to getCcNumber", methodGet, equalTo("getCcNumber"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodGetNullParameter() throws Exception {
        Reflections.methodGet(null);
        fail("Expected Throw IllegalArgumentException");
    }

    @Test
    public void testMethodSet() throws Exception {
        Field field = Person.class.getDeclaredField("name");
        String methodGet = Reflections.methodSet(field);
        assertThat("It should be equal to setName", methodGet, equalTo("setName"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetNullParameter() throws Exception {
        Reflections.methodSet(null);
        fail("Expected Throw IllegalArgumentException");
    }

    @Test
    public void testFindMethod() throws Exception {
        Method method = Reflections.findMethod(Card.class, "toString").get();
        assertThat("Should be toString method", method.getName(), equalTo("toString"));
    }

    @Test
    public void testFindMethodNotFound() throws Exception {
        assertFalse("We expect that method is not present", Reflections.findMethod(Card.class, "setCvv").isPresent());
    }

    @Test
    public void testFindMethodWithParameters() throws Exception {
        Method method = Reflections.findMethod(Person.class, "setAddress", Address.class).get();
        assertThat("It should be equal to setAddress", method.getName(), equalTo("setAddress"));
    }

    @Test
    public void testFindMethodWithParametersNotFound() throws Exception {
        assertFalse("We expect that method is not present", Reflections.findMethod(Card.class, "setCvv", String.class).isPresent());
    }
}
