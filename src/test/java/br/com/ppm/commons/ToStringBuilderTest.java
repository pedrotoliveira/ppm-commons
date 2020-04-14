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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ppm.commons.model.Address;
import br.com.ppm.commons.model.Card;
import br.com.ppm.commons.model.ClassA;
import br.com.ppm.commons.model.ClassB;
import br.com.ppm.commons.model.Order;
import br.com.ppm.commons.model.Person;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * The Class ToStringBuilderTest.
 *
 * @author Pedro T. Oliveira
 */
public class ToStringBuilderTest {

    /**
     * Test method for.
     *
     * {@link ToStringBuilder#reflectionToString(java.lang.Object)} .
     */
    @Test
    public final void testReflectionToString() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAddress(new Address("Some street", 35, "Apto 2"));
        person.setAge(35);
        person.setAlive(true);
        person.setNumbers(new short[]{1, 3, 4, 5});
        person.setOrders(Arrays.asList(new Order[]{new Order(12358), new Order(12387), new Order(821)}));

        Map<String, Person> parents = new HashMap<>();
        Person father = new Person();
        father.setName("Bill Doe");
        father.setAddress(new Address("Cemitery", 582, null));
        father.setAge(0);
        father.setAlive(false);
        father.setNumbers(null);
        parents.put("father", father);

        Person mother = new Person();
        mother.setName("Willy Mae Doe");
        mother.setAddress(new Address("Older street", 82, "bloco a"));
        mother.setAge(70);
        mother.setAlive(false);
        mother.setNumbers(new short[]{9, 7, 6, 8});
        parents.put("mother", mother);

        person.setParents(parents);

        String toStringExpected = "Person[name=John Doe, age=35, "
                + "address=Address[street=Some street, number=35, complement=Apto 2], "
                + "numbers=[1, 3, 4, 5], alive=true, NULL_OBJECT=null, orders=ArrayList[Order[id=12358], Order[id=12387], Order[id=821]], "
                + "parents=Map["
                + "1.key=mother, "
                + "val=Person[name=Willy Mae Doe, age=70, address=Address[street=Older street, number=82, complement=bloco a], "
                + "numbers=[9, 7, 6, 8], alive=false, NULL_OBJECT=null, orders=null, parents=null, "
                + "clazz=class br.com.ppm.commons.model.Person], "
                + "2.key=father, "
                + "val=Person[name=Bill Doe, age=0, address=Address[street=Cemitery, number=582, complement=null], "
                + "numbers=null, alive=false, NULL_OBJECT=null, orders=null, parents=null, clazz=class br.com.ppm.commons.model.Person]], "
                + "clazz=class br.com.ppm.commons.model.Person]";

        String result = person.toString();
        assertThat("toString result should be equal to expected", result, equalTo(toStringExpected));
    }

    @Test
    public void testCyclicReferences() {
        ClassA a = new ClassA();
        ClassB b = new ClassB(a);
        a.setB(b);

        String result = ToStringBuilder.reflectionToString(b);
        String errorExpected = "Error on ToStringBuilder, reflectionToString method has reached the max depth calls!"
                + " Please verify the circular references";

        assertTrue("Result should contain the error text", result.contains(errorExpected));
    }

    @Test
    public void testMaskFields() {
        String number = "1058030000000055";
        String cvv = "***";
        String maskedNumber = "105803******0055";
        String expected = "Card[ccNumber=" + maskedNumber + ", cvv=" + "***" + "]";
        String result = new Card(number, cvv).toString();
        assertThat("CardNumber should be masked", result, equalTo(expected));
    }

    /**
     * Test collections.
     */
    @Test
    public void testMultiCollections() {
        final List<String> collection1 = Arrays.asList(new String[]{"one", "two", "three"});
        final List<List<String>> collection2 = new ArrayList<>();
        collection2.add(collection1);
        collection2.add(collection1);
        collection2.add(collection1);

        String toStringExpected = "ArrayList["
                + "ArrayList[one, two, three], "
                + "ArrayList[one, two, three], "
                + "ArrayList[one, two, three]"
                + "]";

        String result = ToStringBuilder.reflectionToString(collection2);
        assertThat("toString of Collections should be equal to expected", result, equalTo(toStringExpected));
    }

    @Test
    public void testArrays() {
        String[] stringArray = new String[]{"one", "two", "three"};
        String result = ToStringBuilder.reflectionToString(stringArray);
        String expected = "[one, two, three]";
        assertThat("toString of Array should be equal to expected", result, equalTo(expected));
    }

    @Test
    public void testWrapperLong() {
        Long teraFlops = 1093291043094920349L;
        String result = new ToStringBuilder(teraFlops).build();
        assertThat("toString shoud be equal to [1093291043094920349]", result, equalTo("[1093291043094920349]"));
    }

    @Test
    public void testWrapperInteger() {
        Integer one = 1;
        assertThat("toString shoud be equal to [1]", new ToStringBuilder(one).build(true), equalTo("[1]"));
    }

    @Test
    public void testWrapperDouble() {
        Double half = 0.5d;
        assertThat("toString shoud be equal to [0.5]", new ToStringBuilder(half).build(false), equalTo("[0.5]"));
    }

    @Test
    public void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        String result = ToStringBuilder.reflectionToString(map);
        String expected = new MapToStringBuilder(map).build();
        assertThat("toString shoud be equal to expected", result, equalTo(expected));
    }

    @Test
    public void testNull() {
        assertThat("result should be Object=null ", ToStringBuilder.reflectionToString(null), equalTo("Object=null "));
    }
}
