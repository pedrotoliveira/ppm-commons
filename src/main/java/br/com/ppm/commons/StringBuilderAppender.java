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

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import br.com.ppm.commons.annotation.ToStringStyle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.ppm.commons.Strings.mask;
import static br.com.ppm.commons.ToStringConstants.*;
import static br.com.ppm.commons.Types.*;

/**
 * Append Values to a String Builder
 *
 * @author pedrotoliveira
 */
public final class StringBuilderAppender {

    private static final Logger logger = LogManager.getFormatterLogger(StringBuilderAppender.class);
    private static final String DEFAULT_ERROR = "[Error on StringBuilderAppender]";
    private final StringBuilder builder;

    private StringBuilderAppender(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     *
     * @param builder
     * @param element
     */
    public static void appendValue(final StringBuilder builder, final Object element) {
        new StringBuilderAppender(builder).append(element);
    }

    /**
     * Append value.
     * <p>
     * @param o the object
     * @param field the field in object instance
     * @param name the name field name
     * @param builder the builder string builder
     * @param style the style Style to apply
     */
    public static void appendValue(Object o, final Field field, final String name, final StringBuilder builder, ToStringStyle.Style style) {
        new StringBuilderAppender(builder).append(o, field, name, style);
    }

    private void append(Object o, final Field field, final String name, ToStringStyle.Style style) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object value = field.get(o);
            if (value == null) {
                if (ToStringStyle.Style.IGNORE_NULL.equals(style)) {
                    return;
                }
                builder.append(name).append(EQUAL);
                builder.append("null");
            } else if (isArray(value)) {
                builder.append(name).append(EQUAL).append(new ArrayToStringBuilder(value).build());
            } else if (isWrapper(value) || ToStringStyle.Style.CALL_TO_STRING.equals(style) || ToStringStyle.Style.MASK_FIELD.equals(style) || hasImplementedToString(value)) {
                builder.append(name).append(EQUAL);
                builder.append(ToStringStyle.Style.MASK_FIELD.equals(style) ? mask(String.valueOf(value)) : value.toString());
            } else if (isCollection(value)) {
                builder.append(name).append(EQUAL);
                builder.append(new CollectionToStringBuilder(Collection.class.cast(value)).build());
            } else if (isMap(value)) {
                builder.append(name).append(EQUAL);
                builder.append(new MapToStringBuilder(Map.class.cast(value)).build());
            } else {
                builder.append(name).append(EQUAL);
                builder.append(new ToStringBuilder(value).build(IGNORE_SUPER_TYPES, style));
            }

            builder.append(COMMA);

        } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            handleException(ex);
        }
    }

    private void append(final Object element) {
        try {
            if (element == null) {
                builder.append("null");
            } else if (isArray(element)) {
                builder.append(new ArrayToStringBuilder(element).build());
            } else if (isWrapper(element) || hasImplementedToString(element)) {
                builder.append(element);
            } else if (isCollection(element)) {
                builder.append(new CollectionToStringBuilder(Collection.class.cast(element)).build());
            } else if (isMap(element)) {
                builder.append(new MapToStringBuilder(Map.class.cast(element)).build());
            } else {
                builder.append(new ToStringBuilder(element).build(true));
            }
        } catch (Exception ex) {//NOPMD - We want to catch generic exceptions here
            handleException(ex);
        }
    }

    private void handleException(final Exception ex) {
        logger.error(DEFAULT_ERROR, ex);
        builder.append("toStringError=");
        builder.append(DEFAULT_ERROR);
    }
}
