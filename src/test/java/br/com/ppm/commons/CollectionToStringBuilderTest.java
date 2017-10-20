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
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 * @author pedrotoliveira
 */
public class CollectionToStringBuilderTest {

    /**
     * Test of build method, of class CollectionToStringBuilder.
     */
    @Test
    public void testBuild() {
        final List<String> collection = Arrays.asList(new String[]{"one", "two", "three"});
        String toStringExpected = "ArrayList[one, two, three]";
        String result = new CollectionToStringBuilder(collection).build();
        assertThat("toString of Collections should be equal to expected", result, equalTo(toStringExpected));
    }

}
