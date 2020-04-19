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

import br.com.ppm.commons.annotation.ToStringStyle;

import java.lang.reflect.Array;
import java.util.Arrays;

import static br.com.ppm.commons.ToStringConstants.*;
import static br.com.ppm.commons.annotation.ToStringStyle.Style.CALL_TO_STRING;

/**
 * Array ToStringBuilder
 *
 * @author pedrotoliveira
 */
public final class ArrayToStringBuilder implements ToStringBuilder {

    private static final int PAGE_SIZE = 15;
    private final Object array;

    public ArrayToStringBuilder(Object array) {
        this.array = array;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        int length = Array.getLength(array);
        builder.append(OPEN_SQUARE_BRACKET);
        if (length > PAGE_SIZE) {
            appendArrayValuesRange(array, builder, PAGE_SIZE);
            builder.append(", ...");
        } else {
            appendArrayValuesRange(array, builder, length);
        }
        builder.append(CLOSE_SQUARE_BRACKET);
        return builder.toString();
    }

    @Override
    public String build(boolean ignoreSuperType) {
        return build();
    }

    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        return (CALL_TO_STRING.equals(style))
                ? Arrays.deepToString(Object[].class.cast(array))
                : build(ignoreSuperType);
    }

    private void appendArrayValuesRange(Object array, StringBuilder builder, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
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
