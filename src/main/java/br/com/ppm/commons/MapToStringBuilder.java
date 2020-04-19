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

import java.util.Iterator;
import java.util.Map;

import static br.com.ppm.commons.ToStringConstants.*;

/**
 * Map to String Builder
 *
 * @author pedrotoliveira
 */
public final class MapToStringBuilder implements ToStringBuilder {

    private final Map<?, ?> map;

    public MapToStringBuilder(Map<?, ?> map) {
        this.map = map;
    }

    @Override
    public String build() {
        return build(NOT_IGNORE_SUPER_TYPES);
    }

    @Override
    public String build(final boolean ignoreSuperType) {
        return build(ignoreSuperType, ToStringStyle.Style.REFLECTION);
    }

    @Override
    public String build(final boolean ignoreSuperType, final ToStringStyle.Style style) {
        KeyValueAppender appender = KeyValueAppender.of(new StringBuilder(OPEN_MAP_BRACKET));
        int counter = 1;
        for (Iterator<?> keyIt = map.keySet().iterator(); keyIt.hasNext(); ) {
            Object key = keyIt.next();
            appender.appendKey(mapItemKey(counter))
                    .appendSeparator(OPEN_SQUARE_BRACKET)
                    .appendValue(map.get(key), style)
                    .appendSeparator(CLOSE_SQUARE_BRACKET);
            if (keyIt.hasNext()) {
                appender.appendSeparator(COMMA);
            }
            counter++;
        }
        return appender.appendTerminator(CLOSE_SQUARE_BRACKET);
    }

    private String mapItemKey(int counter) {
        return OPEN_SQUARE_BRACKET + KEY + counter + CLOSE_SQUARE_BRACKET;
    }
}
