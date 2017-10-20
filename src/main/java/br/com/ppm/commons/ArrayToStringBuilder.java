/*
 * Copyright (C) 2017 pedrotoliveira
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

import java.lang.reflect.Array;

import static br.com.ppm.commons.ToStringConstants.*;

/**
 * Array ToStringBuilder
 *
 * @author pedrotoliveira
 */
public final class ArrayToStringBuilder {

    private static final int PAGE_SIZE = 15;
    private final Object array;

    public ArrayToStringBuilder(Object array) {
        this.array = array;
    }

    /**
     * Append array values.
     * <p>
     * @param array the array
     * @param builder the builder
     */
    public String build() {
        StringBuilder builder = new StringBuilder();
        int lenght = Array.getLength(array);
        builder.append(OPEN_SQUARE_BRACKET);
        if (lenght > PAGE_SIZE) {
            appendArrayValuesRange(array, builder, 0, PAGE_SIZE);
            builder.append(", ...");
        } else {
            appendArrayValuesRange(array, builder, 0, lenght);
        }
        builder.append(CLOSE_SQUARE_BRACKET);
        return builder.toString();
    }

    /**
     * Append array values range.
     * <p>
     * @param array the array
     * @param builder the builder
     * @param beginIndex the begin index
     * @param endIndex the end index
     */
    private void appendArrayValuesRange(Object array, StringBuilder builder, int beginIndex, int endIndex) {
        for (int i = beginIndex; i < endIndex; i++) {
            Object element = Array.get(array, i);
            if (element != null && element.getClass().isArray()) {
                builder.append(new ArrayToStringBuilder(element).build());
            } else {
                builder.append(element);
                if (i != endIndex - 1) {
                    builder.append(COMMA);
                }
            }
        }
    }
}
