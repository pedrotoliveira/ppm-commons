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
package br.com.ppm.commons.type;

import br.com.ppm.commons.fixtures.Address;
import br.com.ppm.commons.fixtures.Person;
import br.com.ppm.commons.fixtures.States;
import org.junit.Test;

import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TypesTest {

    @Test
    public void isArrayShouldBeTrue() {
        assertThat(Types.isArray(new String[]{"One", "Two", "Three"})).isTrue();
    }

    @Test
    public void hasImplementedToString() {
        assertThat(Types.hasImplementedToString(new Person())).isTrue();
    }

    @Test
    public void hasNotImplementedTiString() {
        Address address = new Address("Socorro street", 34, "21 floor");
        assertThat(Types.hasImplementedToString(address)).isFalse();
    }

    @Test
    public void booleanHasToBeWrapper() {
        assertThat(Types.isWrapper(Boolean.FALSE)).isTrue();
    }

    @Test
    public void integerHasToBeWrapper() {
        assertThat(Types.isWrapper(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void stringHasToBeWrapper() {
        assertThat(Types.isWrapper("String")).isTrue();
    }

    @Test
    public void doubleHasToBeWrapper() {
        assertThat(Types.isWrapper(Double.MAX_VALUE)).isTrue();
    }

    @Test
    public void shortHasToBeWrapper() {
        assertThat(Types.isWrapper(Short.MAX_VALUE)).isTrue();
    }

    @Test
    public void longHasToBeWrapper() {
        assertThat(Types.isWrapper(Long.MAX_VALUE)).isTrue();
    }

    @Test
    public void floatHasToBeWrapper() {
        assertThat(Types.isWrapper(Float.MAX_VALUE)).isTrue();
    }

    @Test
    public void characterHasToBeWrapper() {
        assertThat(Types.isWrapper(Character.MAX_VALUE)).isTrue();
    }

    @Test
    public void byteHasToBeWrapper() {
        assertThat(Types.isWrapper(Byte.MAX_VALUE)).isTrue();
    }

    @Test
    public void dateHasToBeWrapper() {
        Date date = Date.from(Instant.now());
        assertThat(Types.isWrapper(date)).isTrue();
    }

    @Test
    public void calendarHasToBeWrapper() {
        assertThat(Types.isWrapper(Calendar.getInstance())).isTrue();
    }

    @Test
    public void localeHasToBeWrapper() {
        assertThat(Types.isWrapper(Locale.getDefault())).isTrue();
    }

    @Test
    public void classHasToBeWrapper() {
        assertThat(Types.isWrapper(this.getClass())).isTrue();
    }

    @Test
    public void enumShouldNotBeWrapper() {
        assertThat(Types.isWrapper(States.FINISHED)).isFalse();
    }

    @Test
    public void isEnumHasToBeTrue() {
        assertThat(Types.isEnum(States.PROCESSED)).isTrue();
    }

    @Test
    public void primitiveBooleanHasToBeWrappers() {
        assertThat(Types.isWrapper(false)).isTrue();
    }

    @Test
    public void primitiveIntHasToBeWrapper() {
        assertThat(Types.isWrapper(1)).isTrue();
    }

    @Test
    public void personHasNotToBeWrapper() {
        assertThat(Types.isWrapper(new Person())).isFalse();
    }

    @Test
    public void nullShouldNotToBeWrapper() {
        assertThat(Types.isWrapper(null)).isFalse();
    }

    @Test
    public void isMapShouldBeTrue() {
        assertThat(Types.isMap(new HashMap<>())).isTrue();
    }

    @Test
    public void isCollectionShouldBeTrue() {
        assertThat(Types.isCollection(new ArrayList<>())).isTrue();
    }

    @Test
    public void isListShouldBeTrue() {
        assertThat(Types.isList(new LinkedList<>())).isTrue();
    }
}