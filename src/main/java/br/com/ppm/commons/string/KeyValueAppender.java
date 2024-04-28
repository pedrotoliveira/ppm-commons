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
package br.com.ppm.commons.string;

import br.com.ppm.commons.annotation.ToStringStyle;
import br.com.ppm.commons.reflect.Reflections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Optional;

import static br.com.ppm.commons.string.ToStringConstants.*;

/**
 * Append Values to a StringBuilder
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public final class KeyValueAppender {

    private static final Logger logger = LogManager.getFormatterLogger(KeyValueAppender.class);
    private static final String DEFAULT_ERROR = "[Error on StringBuilderAppender]";

    private final StringBuilder builder;

    /**
     * <p>Constructor for KeyValueAppender.</p>
     */
    public KeyValueAppender() {
        this(new StringBuilder());
    }

    /**
     * <p>Constructor for KeyValueAppender.</p>
     *
     * @param builder a {@link java.lang.StringBuilder} object.
     */
    public KeyValueAppender(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     * <p>of.</p>
     *
     * @param builder a {@link java.lang.StringBuilder} object.
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public static KeyValueAppender of(final StringBuilder builder) {
        return new KeyValueAppender(builder);
    }

    /**
     * <p>start.</p>
     *
     * @param start a {@link java.lang.String} object.
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public static KeyValueAppender start(String start) {
        return new KeyValueAppender(new StringBuilder(start));
    }

    /**
     * <p>appendKeyValue.</p>
     *
     * @param target a {@link java.lang.Object} object.
     * @param key a {@link java.lang.reflect.Field} object.
     * @param style a {@link br.com.ppm.commons.annotation.ToStringStyle.Style} object.
     */
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
                appendNullValue();
            }
            appendSeparator(COMMA);
        } catch (Throwable ex) { //NOPMD - We do not want to throw exception to this method.
            handleException(ex);
        }
    }

    /**
     * <p>appendKey.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public KeyValueAppender appendKey(String name) {
        builder.append(name);
        return this;
    }

    /**
     * <p>appendNullValue.</p>
     *
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public KeyValueAppender appendNullValue() {
        builder.append("null");
        return this;
    }

    /**
     * <p>appendValue.</p>
     *
     * @param element a {@link java.lang.Object} object.
     * @param style a {@link br.com.ppm.commons.annotation.ToStringStyle.Style} object.
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public KeyValueAppender appendValue(Object element, ToStringStyle.Style style) {
        ToStringBuilder toStringBuilder = ToStringBuilderFactory.of(element);
        builder.append(toStringBuilder.build(IGNORE_SUPER_TYPES, style));
        return this;
    }

    /**
     * <p>appendSeparator.</p>
     *
     * @param separator a {@link java.lang.String} object.
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public KeyValueAppender appendSeparator(String separator) {
        builder.append(separator);
        return this;
    }

    /**
     * <p>deleteLastComma.</p>
     *
     * @return a {@link br.com.ppm.commons.string.KeyValueAppender} object.
     */
    public KeyValueAppender deleteLastComma() {
        builder.delete(builder.length() - 2, builder.length());
        return this;
    }

    /**
     * <p>appendTerminator.</p>
     *
     * @param terminator a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String appendTerminator(String terminator) {
        builder.append(terminator);
        return builder.toString();
    }

    private void handleException(final Throwable ex) {
        logger.error(DEFAULT_ERROR, ex);
        builder.append("toStringError=");
        builder.append(DEFAULT_ERROR);
    }

    /**
     * <p>Getter for the field <code>builder</code>.</p>
     *
     * @return a {@link java.lang.StringBuilder} object.
     */
    public StringBuilder getBuilder() {
        return builder;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "KeyValueAppender{" +
                "builder=" + builder +
                '}';
    }
}
