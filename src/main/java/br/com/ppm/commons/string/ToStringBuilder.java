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
package br.com.ppm.commons.string;

import br.com.ppm.commons.annotation.ToStringStyle;

import static br.com.ppm.commons.string.ToStringConstants.NOT_IGNORE_SUPER_TYPES;

public interface ToStringBuilder {
    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @return toString Pattern
     */
    default String build() {
        return build(NOT_IGNORE_SUPER_TYPES);
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @param ignoreSuperType has to ignore the superType ?
     * @return toString Pattern
     */
    default String build(boolean ignoreSuperType) {
        return build(ignoreSuperType, ToStringStyle.Style.REFLECTION);
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @param ignoreSuperType has to ignore the superType ?
     * @param style a ToStringStyle.Style
     *
     * @return toString Pattern
     */
    String build(boolean ignoreSuperType, ToStringStyle.Style style);

    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @param object the Object
     *
     * @return toString Pattern
     */
    static String toString(final Object object) {
        return ToStringBuilderFactory.of(object).build();
    }

    /**
     * Create a toString Pattern for an object and its super type, if we want to.
     *
     * @param object the Object
     * @param ignoreSuperType has to ignore the superType ?
     *
     * @return toString Pattern
     */
    static String toString(final Object object, final boolean ignoreSuperType) {
        return ToStringBuilderFactory.of(object).build(ignoreSuperType);
    }
}
