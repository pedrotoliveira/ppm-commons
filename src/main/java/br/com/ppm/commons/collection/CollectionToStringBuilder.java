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
package br.com.ppm.commons.collection;

import br.com.ppm.commons.KeyValueAppender;
import br.com.ppm.commons.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

import java.util.Collection;
import java.util.Iterator;

import static br.com.ppm.commons.ToStringConstants.*;

/**
 * Collection ToStringBuilder
 *
 * @author pedrotoliveira
 */
public final class CollectionToStringBuilder implements ToStringBuilder {

    private static final int PAGE_SIZE = 5;
    private final Collection<?> collection;

    public CollectionToStringBuilder(final Collection<?> collection) {
        this.collection = collection;
    }

    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        KeyValueAppender appender = KeyValueAppender.start(OPEN_SQUARE_BRACKET);
        int counter = 0;
        for (Iterator<?> it = collection.iterator(); it.hasNext();) {
            appender.appendValue(it.next(), style);
            if (it.hasNext()) {
                appender.appendSeparator(COMMA);
            }
            counter++;
            if (counter == PAGE_SIZE) {
                appender.appendSeparator(" ...");
                break;
            }
        }
        return appender.appendTerminator(CLOSE_SQUARE_BRACKET);
    }
}
