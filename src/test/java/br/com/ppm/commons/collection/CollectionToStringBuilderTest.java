/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import br.com.ppm.commons.fixtures.Person;
import br.com.ppm.commons.fixtures.PersonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pedrotoliveira
 */
@RunWith(Parameterized.class)
public class CollectionToStringBuilderTest {

    private final List<?> list;
    private final String expected;

    public CollectionToStringBuilderTest(List<?> list, String expected) {
        this.list = list;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index}: (Actual: {0} Expected: {1})")
    public static List<Object[]> data() {
        List<Object[]> fixture = new ArrayList<>();
        fixture.add(testListOfPersons());
        fixture.add(testListOfStrings());
        fixture.add(testBigCollection());
        return fixture;
    }

    private static Object[] testListOfPersons() {
        Person bonnie = PersonBuilder.aPerson()
                .withName("Bonnie")
                .withAge(19)
                .withAlive(false)
                .build();

        Person clyde = PersonBuilder.aPerson()
                .withName("Clyde")
                .withAge(21)
                .withAlive(false)
                .build();

        Collection<Person> persons = Arrays.asList(bonnie, clyde);
        String expected = "[" + bonnie.toString() + ", " + clyde.toString() + "]";
        return new Object[]{persons, expected};
    }

    private static Object[] testListOfStrings() {
        return new Object[]{Arrays.asList("one", "two", "three"), "[one, two, three]"};
    }

    private static Object[] testBigCollection() {
        Collection<Integer> collection = Seq.col(1, 25);
        String expected = "[1, 2, 3, 4, 5, ...]";
        return new Object[]{collection, expected};
    }

    @Test
    public void executeTests() {
        assertThat(new CollectionToStringBuilder(list).build()).isEqualTo(expected);
    }
}
