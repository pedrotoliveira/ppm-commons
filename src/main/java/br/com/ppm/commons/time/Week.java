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

import br.com.ppm.commons.validation.ArgumentValidator;

import java.time.LocalDateTime;

public final class Week {

    private final LocalDateTime time;

    public Week(int year, int month, int day) {
        ArgumentValidator.number(year).inRange(0, 9999);
        ArgumentValidator.number(month).inRange(1, 12);
        ArgumentValidator.number(day).inRange(1, 31);
        this.time = LocalDateTime.of(year, month, day, 0, 0);
    }


    /**
     * Get the day of week
     *
     * @return a string with the day of week
     */
    public String getDay() {
        return time.getDayOfWeek().name();
    }

    /**
     * Get the day of week with first letter in upper caseÏ
     *
     * @return String
     */
    public String day() {
        char[] chars = getDay().toCharArray();
        return chars[0] + getDay().substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return "Week{" + "time=" + time + '}';
    }
}
