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

import br.com.ppm.commons.fixtures.Order;
import br.com.ppm.commons.object.DepthController;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepthControllerTest {

    @Test
    public void testIsAllowed() {
        assertThat("isAllowed should be true when called a single time",
                DepthController.isAllowed(new Order(1)), is(true));
    }

    @Test
    public void testIsAllowedWhenCall49Times() {
        for (int i = 0; i < 50; i++) {
            assertThat(String.format("isAllowed should be true when called %d times", i),
                    DepthController.isAllowed(new Order(2)), is(true));
        }
    }
}