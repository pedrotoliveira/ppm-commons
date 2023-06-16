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

public final class NumberValidation {

    private final Number toCheck;

    public NumberValidation(Number number) {
        this.toCheck = number;
    }

    public void inRange(Number start, Number end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException(
                    "The range must be not null [ "
                            + String.valueOf(start)
                            + ", "
                            + String.valueOf(end) +
                            "]");
        }
        if (toCheck.longValue() < start.longValue() || toCheck.longValue() > end.longValue()) {
            throw new IllegalArgumentException("The number: " + toCheck + " is not in range between [" + start + ", " + end + "]");
        }
    }
}
