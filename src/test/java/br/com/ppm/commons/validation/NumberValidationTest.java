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

package br.com.ppm.commons.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when start is null")
    void inRangeStartNull() {
        var end = 20;
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new NumberValidation(10).inRange(null, end)
        );
        assertEquals("The range must be not null [ null, 20]", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when end is null")
    void inRangeEndNull() {
        var start = 10;
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new NumberValidation(10).inRange(start, null)
        );
        assertEquals("The range must be not null [ 10, null]", exception.getMessage());
    }
}