package br.com.ppm.commons;

import java.util.Collection;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.ppm.commons.ToStringConstants.*;

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
/**
 * Collection ToStringBuilder
 *
 * @author pedrotoliveira
 */
public final class CollectionToStringBuilder {

    private static final Logger logger = LogManager.getFormatterLogger(CollectionToStringBuilder.class);

    private static final int PAGE_SIZE = 5;
    private static final String DEFAULT_ERROR = "[Error on CollectionToStringBuilder]";

    private final Collection<?> collection;

    public CollectionToStringBuilder(final Collection<?> collection) {
        this.collection = collection;
    }

    /**
     * Append collection.
     * <p>
     * @param collection the collection
     * @param builder the builder
     */
    @SuppressWarnings("unchecked")
    public String build() {
        final StringBuilder builder = new StringBuilder();
        try {
            builder.append(collection.getClass().getSimpleName()).append(OPEN_SQUARE_BRACKET);
            int counter = 0;
            for (Iterator<Object> it = (Iterator<Object>) collection.iterator(); it.hasNext();) {
                Object element = it.next();
                StringBuilderAppender.appendValue(builder, element);
                if (it.hasNext()) {
                    builder.append(COMMA);
                }
                counter++;
                if (counter == PAGE_SIZE) {
                    builder.append(", ...");
                    break;
                }
            }
            builder.append(CLOSE_SQUARE_BRACKET);
        } catch (Exception ex) {//NOPMD - We want to catch generic exceptions here
            handleException(ex, builder);
        }
        return builder.toString();
    }

    /**
     * Handle exception.
     * <p>
     * @param ex the ex
     * @param builder the builder
     */
    private void handleException(final Exception ex, final StringBuilder builder) {
        logger.error(DEFAULT_ERROR, ex);
        builder.append("toStringError=");
        builder.append(DEFAULT_ERROR);
    }
}
