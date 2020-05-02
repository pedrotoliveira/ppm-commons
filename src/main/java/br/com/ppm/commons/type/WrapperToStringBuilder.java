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

import br.com.ppm.commons.string.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

public class WrapperToStringBuilder implements ToStringBuilder {

    private final Wrapper<?> wrapper;

    public WrapperToStringBuilder(Wrapper<?> wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        return wrapper.toString();
    }
}
