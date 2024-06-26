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

import br.com.ppm.commons.string.KeyValueAppender;
import br.com.ppm.commons.string.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

import java.util.Collection;
import java.util.Iterator;

import static br.com.ppm.commons.string.ToStringConstants.*;

/**
 * Collection ToStringBuilder
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public final class CollectionToStringBuilder implements ToStringBuilder {

    private final int pageSize;
    private final Collection<?> collection;

    /**
     * <p>Constructor for CollectionToStringBuilder.</p>
     *
     * @param collection a {@link java.util.Collection} object.
     */
    public CollectionToStringBuilder(final Collection<?> collection) {
        this(5, collection);
    }

    /**
     * <p>Constructor for CollectionToStringBuilder.</p>
     *
     * @param pageSize a int.
     * @param collection a {@link java.util.Collection} object.
     */
    public CollectionToStringBuilder(int pageSize, Collection<?> collection) {
        this.pageSize = pageSize;
        this.collection = collection;
    }

    /** {@inheritDoc} */
    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        KeyValueAppender appender = appendCollectionValues(style);
        if (collection.size() > pageSize) {
            appender.appendSeparator("...");
        }
        return appender.appendTerminator(CLOSE_SQUARE_BRACKET);
    }

    private KeyValueAppender appendCollectionValues(ToStringStyle.Style style) {
        KeyValueAppender appender = KeyValueAppender.start(OPEN_SQUARE_BRACKET);
        int counter = 0;
        for (Iterator<?> it = collection.iterator(); it.hasNext();) {
            appender.appendValue(it.next(), style);
            counter++;
            if (counter == pageSize && collection.size() > pageSize) {
                appender.appendSeparator(COMMA);
                break;
            }
            if (it.hasNext()) {
                appender.appendSeparator(COMMA);
            }
        }
        return appender;
    }
}
