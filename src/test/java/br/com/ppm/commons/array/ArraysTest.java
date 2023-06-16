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
package br.com.ppm.commons.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    @Test
    @DisplayName("Should check if the array is Empty (0 Length)")
    void isEmptyZeroLength() {
        var array = new Object[0];
        assertTrue(Arrays.isEmpty(array));
    }

    @Test
    @DisplayName("Should check if the array is Empty (Null Elements)")
    void isEmptyNullElements() {
        var array = new Object[100];
        assertTrue(Arrays.isEmpty(array));
    }

    @Test
    @DisplayName("Should check if the array is NOT Empty")
    void isNotEmpty() {
        var array = new Object[100];
        array[0] = "Value 1";
        array[1] = Integer.MAX_VALUE;
        assertTrue(Arrays.notEmpty(array));
    }

    @Test
    @DisplayName("isEmpty Should throw an Argument Exception on Null Parameter")
    void testIsEmptyNullParameter() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Arrays.isEmpty(null);
        });
        assertEquals("[array] is an invalid parameter.", ex.getMessage());
    }

    @Test
    @DisplayName("isNotEmpty Should throw an Argument Exception on Null Parameter")
    void testIsNotEmptyNullParameter() {
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> Arrays.notEmpty(null)
        );
        assertEquals("[array] is an invalid parameter.", ex.getMessage());
    }

    @DisplayName("Should reverse the array by modifying the original array")
    @Test
    void testReverse() {
        var array = new Object[5];
        array[0] = "Value 1";
        array[1] = "Value 2";
        array[2] = "Value 3";
        array[3] = "Value 4";
        array[4] = "Value 5";
        Arrays.reverse(array);
        assertEquals("Value 5", array[0]);
        assertEquals("Value 4", array[1]);
        assertEquals("Value 3", array[2]);
        assertEquals("Value 2", array[3]);
        assertEquals("Value 1", array[4]);
    }

    @DisplayName("Should reverse the array by creating a new array")
    @Test
    void testReverseNullParameter() {
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> Arrays.reverse(null)
        );
        assertEquals("[array] is an invalid parameter.", ex.getMessage());
    }

    @DisplayName("Should reverse the array by creating a new array")
    @Test
    void testReverseNewArray() {
        var array = new Object[5];
        array[0] = "Value 1";
        array[1] = "Value 2";
        array[2] = "Value 3";
        array[3] = "Value 4";
        array[4] = "Value 5";
        var reversed = Arrays.newReverse(array);
        assertFalse(array == reversed);
        assertEquals("Value 5", reversed[0]);
        assertEquals("Value 4", reversed[1]);
        assertEquals("Value 3", reversed[2]);
        assertEquals("Value 2", reversed[3]);
        assertEquals("Value 1", reversed[4]);
    }

    @Test
    @DisplayName("reverse Should throw an Argument Exception on Null Parameter")
    void testNewReverseNullParameter() {
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> Arrays.newReverse(null)
        );
        assertEquals("[array] is an invalid parameter.", ex.getMessage());
    }
}