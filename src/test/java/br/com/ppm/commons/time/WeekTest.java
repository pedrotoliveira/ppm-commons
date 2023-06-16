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

package br.com.ppm.commons.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {

    @Test
    void getDayMonday() {
        var expected = "MONDAY";
        var week = new Week(2020, 1, 6);
        assertEquals(expected, week.getDay());
    }

    @Test
    void getDayTuesday() {
        var expected = "TUESDAY";
        var week = new Week(2023, 6, 13);
        assertEquals(expected, week.getDay());
    }

    @Test
    void testWensesday() {
        var expected = "WEDNESDAY";
        var week = new Week(2005, 11, 16);
        assertEquals(expected, week.getDay());
    }

    @Test
    void testThusday() {
        var expected = "THURSDAY";
        var week = new Week(2005, 11, 17);
        assertEquals(expected, week.getDay());
    }

    @Test
    void testFriday() {
        var expected = "FRIDAY";
        var week = new Week(2023,   11, 17);
        assertEquals(expected, week.getDay());
    }

    @Test
    void testSunday() {
        var expected = "SUNDAY";
        var week = new Week(2023, 11, 19);
        assertEquals(expected, week.getDay());
    }

    @Test
    void testToString() {
        var expected = "Week{time=2020-01-06T00:00}";
        var week = new Week(2020, 1, 6);
        assertEquals(expected, week.toString());
    }

    @Test
    void testInvalidMonth() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Week(2020, 13, 6)
        );
        assertEquals("The number: 13 is not in range between [1, 12]", exception.getMessage());
    }

    @Test
    void testInvalidDay() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Week(2020, 1, 32)
        );
        assertEquals("The number: 32 is not in range between [1, 31]", exception.getMessage());
    }
}