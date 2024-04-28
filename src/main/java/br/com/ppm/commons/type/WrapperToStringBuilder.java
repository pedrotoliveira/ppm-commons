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

/**
 * <p>WrapperToStringBuilder class.</p>
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public class WrapperToStringBuilder implements ToStringBuilder {

    private final Wrapper<?> wrapper;

    /**
     * <p>Constructor for WrapperToStringBuilder.</p>
     *
     * @param wrapper a {@link br.com.ppm.commons.type.Wrapper} object.
     */
    public WrapperToStringBuilder(Wrapper<?> wrapper) {
        this.wrapper = wrapper;
    }

    /** {@inheritDoc} */
    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        return wrapper.toString();
    }
}
