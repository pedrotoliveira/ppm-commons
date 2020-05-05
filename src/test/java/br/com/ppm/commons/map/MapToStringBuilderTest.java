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
package br.com.ppm.commons.map;

import br.com.ppm.commons.fixtures.Person;
import br.com.ppm.commons.fixtures.PersonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * @author pedrotoliveira
 */
@RunWith(Parameterized.class)
public class MapToStringBuilderTest {

    private final Map<?, ?> map;
    private final String expected;

    public MapToStringBuilderTest(Map<?, ?> map, String expected) {
        this.map = map;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index}: (Actual: {0} Expected: {1})")
    public static List<Object[]> data() {
        List<Object[]> fixture = new ArrayList<>();
        fixture.add(testMapOfPersons());
        fixture.add(testMapOfStrings());
        return fixture;
    }

    private static Object[] testMapOfStrings() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("keyOne", "one");
        map.put("keyTwo", "two");
        map.put("keyThree", "three");
        String expected = "Map{ ['keyOne', 'one'], ['keyTwo', 'two'], ['keyThree', 'three'] }";
        return new Object[]{map, expected};
    }

    private static Object[] testMapOfPersons() {
        Map<String, Person> map = new LinkedHashMap<>();
        Person person1 = PersonBuilder.aPerson().withName("Finin").build();
        Person person2 = PersonBuilder.aPerson().withName("Farin").build();
        Person person3 = PersonBuilder.aPerson().withName("Fuini").build();

        map.put("keyOne", person1);
        map.put("keyTwo", person2);
        map.put("keyThree", person3);

        String expected = "Map{ " +
                "['keyOne', " + person1.toString() + "], " +
                "['keyTwo', " + person2.toString() + "], " +
                "['keyThree', " + person3.toString() + "]" +
                " }";
        return new Object[]{map, expected};
    }

    @Test
    public void executeTest() {
        Assertions.assertThat(new MapToStringBuilder(map).build()).isEqualTo(expected);
    }

}
