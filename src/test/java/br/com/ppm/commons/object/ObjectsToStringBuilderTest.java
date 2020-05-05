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
package br.com.ppm.commons.object;

import br.com.ppm.commons.fixtures.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pedrotoliveira
 */
@RunWith(Parameterized.class)
public class ObjectsToStringBuilderTest {

    private final String testName;
    private final Object object;
    private final String expected;

    public ObjectsToStringBuilderTest(String testName, Object object, String expected) {
        this.testName = testName;
        this.object = object;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Case {index} - {0}")
    public static List<Object[]> data() {
        List<Object[]> fixture = new ArrayList<>();
        //fixture.add(testWithPerson());
        fixture.add(testWithAddress());
        return fixture;
    }

    private static Object[] testWithAddress() {
        Address address = new Address("Abbey Rd, St John's Wood", 3, "London NW8 9AY, Reino Unido");
        String expected = "Address{ street='Abbey Rd, St John's Wood', number=3, complement='London NW8 9AY, Reino Unido' }" ;
        return new Object[] {"testWithAddress", address, expected};
    }

    @Test
    public void build() {
        assertThat(new ObjectsToStringBuilder(object).build()).as(testName).isEqualTo(expected);
    }
}