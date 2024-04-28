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
package br.com.ppm.commons.array;

import br.com.ppm.commons.string.KeyValueAppender;
import br.com.ppm.commons.string.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

import static br.com.ppm.commons.string.ToStringConstants.*;

/**
 * Array ToStringBuilder
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public final class ArraysToStringBuilder implements ToStringBuilder {

    private static final int PAGE_SIZE = 15;
    private final Object[] array;

    /**
     * <p>Constructor for ArraysToStringBuilder.</p>
     *
     * @param array a {@link java.lang.Object} object.
     */
    public ArraysToStringBuilder(Object... array) {
        this.array = array;
    }

    /** {@inheritDoc} */
    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        KeyValueAppender appender = appendArrayValues(style);
        if (array.length > PAGE_SIZE) {
            appender.appendSeparator("...");
        }
        return appender.appendTerminator(CLOSE_SQUARE_BRACKET);
    }

    private KeyValueAppender appendArrayValues(ToStringStyle.Style style) {
        KeyValueAppender appender = KeyValueAppender.start(OPEN_SQUARE_BRACKET);
        for (int index = 0; index < array.length; index++) {
            appender.appendValue(array[index], style);
            if (index + 1 == PAGE_SIZE && array.length > PAGE_SIZE) {
                appender.appendSeparator(COMMA);
                break;
            }
            if (index + 1 < array.length) {
                appender.appendSeparator(COMMA);
            }
        }
        return appender;
    }
}
