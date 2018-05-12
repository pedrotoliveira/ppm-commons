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

import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.ppm.commons.ToStringConstants.*;

/**
 * Map to String Builder
 *
 * @author pedrotoliveira
 */
public class MapToStringBuilder {

    private static final Logger logger = LogManager.getFormatterLogger(MapToStringBuilder.class);
    private static final String DEFAULT_ERROR = "[Error on MapToStringBuilder]";
    private final Map<?, ?> map;

    public MapToStringBuilder(Map<?, ?> map) {
        this.map = map;
    }

    /**
     * Append map.
     */
    @SuppressWarnings("unchecked")
    public String build() {
        final StringBuilder builder = new StringBuilder(OPEN_MAP_BRACKET);
        try {
            int counter = 1;
            for (Iterator<Object> keyIt = (Iterator<Object>) map.keySet().iterator(); keyIt.hasNext();) {
                Object key = keyIt.next();
                builder.append(counter).append('.');
                builder.append(KEY).append(key);
                builder.append(VALUE);
                StringBuilderAppender.appendValue(builder, map.get(key));
                if (keyIt.hasNext()) {
                    builder.append(COMMA);
                }
                counter++;
            }
        } catch (Exception ex) {//NOPMD - We want to catch generic exceptions here
            handleException(ex, builder);
        }
        return builder.append(CLOSE_SQUARE_BRACKET).toString();
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
