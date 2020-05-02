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
package br.com.ppm.commons.map;

import br.com.ppm.commons.KeyValueAppender;
import br.com.ppm.commons.ToStringBuilder;
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
    public String build(final boolean ignoreSuperType, final ToStringStyle.Style style) {
        KeyValueAppender appender = KeyValueAppender.of(new StringBuilder(OPEN_MAP_BRACKET));
        for (Iterator<?> keyIt = map.keySet().iterator(); keyIt.hasNext(); ) {
            Object key = keyIt.next();
            appender.appendSeparator(OPEN_SQUARE_BRACKET)
                    .appendKey(mapItemKey(key))
                    .appendSeparator(COMMA)
                    .appendValue(map.get(key), style)
                    .appendSeparator(CLOSE_SQUARE_BRACKET);
            if (keyIt.hasNext()) {
                appender.appendSeparator(COMMA);
            }
        }
        return appender.appendTerminator(CLOSE_BRACKET);
    }

    private String mapItemKey(Object key) {
        KeyValueAppender keyAppender = new KeyValueAppender();
        keyAppender.appendValue(key, ToStringStyle.Style.REFLECTION);
        return keyAppender.getBuilder().toString();
    }
}
