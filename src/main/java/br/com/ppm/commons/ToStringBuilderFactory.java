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
package br.com.ppm.commons;

import java.util.Collection;
import java.util.Map;

/**
 * Factory of ToStringBuilders
 */
public final class ToStringBuilderFactory {

    private final Object element;

    public ToStringBuilderFactory(final Object element) {
        this.element = element;
    }

    public static <T> ToStringBuilder of(T element) {
        return new ToStringBuilderFactory(element).create();
    }

    public ToStringBuilder create() {
        if (Types.isArray(element)) {
            return new ArrayToStringBuilder(element);
        } else if (Types.isWrapper(element) || Types.hasImplementedToString(element)) {
            return new WrapperToStringBuilder(element);
        } else if (Types.isCollection(element)) {
            return new CollectionToStringBuilder(Collection.class.cast(element));
        } else if (Types.isMap(element)) {
            return new MapToStringBuilder(Map.class.cast(element));
        } else {
            return new ObjectsToStringBuilder(element);
        }
    }
}
