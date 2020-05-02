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
import br.com.ppm.commons.reflect.Reflections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Optional;

import static br.com.ppm.commons.ToStringConstants.*;

/**
 * Append Values to a StringBuilder
 *
 * @author pedrotoliveira
 */
public final class KeyValueAppender {

    private static final Logger logger = LogManager.getFormatterLogger(KeyValueAppender.class);
    private static final String DEFAULT_ERROR = "[Error on StringBuilderAppender]";

    private final StringBuilder builder;

    public KeyValueAppender() {
        this(new StringBuilder());
    }

    public KeyValueAppender(StringBuilder builder) {
        this.builder = builder;
    }

    public static KeyValueAppender of(final StringBuilder builder) {
        return new KeyValueAppender(builder);
    }

    public static KeyValueAppender start(String start) {
        return new KeyValueAppender(new StringBuilder(start));
    }

    public void appendKeyValue(final Object target, final Field key, final ToStringStyle.Style style) {
        try {
            if (ToStringStyle.Style.IGNORE_NULL.equals(style)) {
                return;
            }
            appendKey(key.getName()).appendSeparator(EQUAL);
            Optional<Object> optional = Reflections.getValueByField(key, target);
            if (optional.isPresent()) {
                appendValue(optional.get(), style);
            } else {
                builder.append("null");
            }
            appendSeparator(COMMA);
        } catch (Throwable ex) { //NOPMD - We do not want to throw exception to this method.
            handleException(ex);
        }
    }

    public KeyValueAppender appendKey(String name) {
        builder.append(name);
        return this;
    }

    public KeyValueAppender appendValue(Object element, ToStringStyle.Style style) {
        ToStringBuilder toStringBuilder = ToStringBuilderFactory.of(element);
        builder.append(toStringBuilder.build(IGNORE_SUPER_TYPES, style));
        return this;
    }

    public KeyValueAppender appendSeparator(String separator) {
        builder.append(separator);
        return this;
    }

    public String appendTerminator(String terminator) {
        builder.append(terminator);
        return builder.toString();
    }

    private void handleException(final Throwable ex) {
        logger.error(DEFAULT_ERROR, ex);
        builder.append("toStringError=");
        builder.append(DEFAULT_ERROR);
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    @Override
    public String toString() {
        return "KeyValueAppender{" +
                "builder=" + builder +
                '}';
    }
}
