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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.ppm.commons.annotation.ToStringExclude;
import br.com.ppm.commons.annotation.ToStringStyle;
import br.com.ppm.commons.annotation.ToStringStyle.Style;

import static br.com.ppm.commons.ToStringConstants.*;
import static br.com.ppm.commons.Types.*;
import static br.com.ppm.commons.annotation.ToStringStyle.Style.NO_STYLE;

/**
 * Class ToStringBuilder is a Utility class to implement java toString pattern.
 *
 * This implementation should be more realible, faster and secure them other ToStringBuilders on the market.
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 05/15/2013
 *
 */
public final class ToStringBuilder {

    private static final String TO_MANY_TO_STRING_CALLS_VIOLATION = "[Error on ToStringBuilder, "
            + "reflectionToString method has reached the max depth calls! Please verify the circular references]";

    private final Object object;

    public ToStringBuilder(final Object object) {
        this.object = object;
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @return toString Pattern
     */
    public String build() {
        return build(NOT_IGNORE_SUPER_TYPES);
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     *
     * @param ignoreSuperType has to ignore the superType ?
     * @return toString Pattern
     */
    public String build(final boolean ignoreSuperType) {
        return build(ignoreSuperType, NO_STYLE);
    }

    public String build(final boolean ignoreSuperType, final Style style) {
        return reflectionToString(object, ignoreSuperType, style);
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     * <p>
     * @param object the Object
     * <p>
     * @return toString Pattern
     */
    public static String reflectionToString(final Object object) {
        return new ToStringBuilder(object).build();
    }

    /**
     * Create a toString Pattern for an object and its super type, if we want to.
     * <p>
     * @param object the Object
     * @param ignoreSuperType has to ignore the superType ?
     * <p>
     * @return toString Pattern
     */
    public static String reflectionToString(final Object object, final boolean ignoreSuperType) {
        return new ToStringBuilder(object).build(ignoreSuperType);
    }

    /**
     * Reflection to string.
     * <p>
     * @param object the o
     * @param ignoreSuperType the ignore super type
     * @param style the style
     * <p>
     * @return the string
     */
    private String reflectionToString(final Object object, final boolean ignoreSuperType, final Style style) {
        if (object == null) {
            return "Object=null ";
        }
        final StringBuilder builder = new StringBuilder();
        if (DepthController.isAllowed(object)) {
            if (isArray(object)) {
                builder.append(new ArrayToStringBuilder(object).build());
            } else if (isWrapper(object)) {
                builder.append(OPEN_SQUARE_BRACKET);
                builder.append(object);
                builder.append(CLOSE_SQUARE_BRACKET);
            } else if (isCollection(object)) {
                builder.append(new CollectionToStringBuilder(Collection.class.cast(object)).build());
            } else if (isMap(object)) {
                builder.append(new MapToStringBuilder(Map.class.cast(object)).build());
            } else {
                builder.append(object.getClass().getSimpleName());
                builder.append(OPEN_SQUARE_BRACKET);
                builder.append(toStringFields(object, ignoreSuperType, style));
                builder.delete(builder.length() - 2, builder.length());
                builder.append(CLOSE_SQUARE_BRACKET);
            }
        } else {
            builder.append(OPEN_SQUARE_BRACKET);
            builder.append("toStringError=").append(TO_MANY_TO_STRING_CALLS_VIOLATION);
            builder.append(CLOSE_SQUARE_BRACKET);
        }
        return builder.toString();
    }

    /**
     * To string fields.
     * <p>
     * @param object the o
     * @param ignoreSuperType the ignore super type
     * @param style the style
     * <p>
     * @return the string
     */
    private String toStringFields(final Object object, final boolean ignoreSuperType, final Style style) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = ignoreSuperType ? object.getClass().getDeclaredFields() : extractSuperClassFields(object);
        for (Field field : fields) {
            String name = field.getName();
            if (isToPrintField(field, name)) {
                Style selectedStyle = selectStyle(style, field);
                StringBuilderAppender.appendValue(object, field, name, builder, selectedStyle);
            }
        }
        return builder.toString();
    }

    /**
     * Select style.
     * <p>
     * @param current the current
     * @param field the field
     * <p>
     * @return the style
     */
    private Style selectStyle(Style current, Field field) {
        return (current == NO_STYLE) ? getFieldStyle(field) : current;
    }

    /**
     * Gets the field style.
     * <p>
     * @param field the field
     * <p>
     * @return the field style
     */
    private Style getFieldStyle(Field field) {
        return field.isAnnotationPresent(ToStringStyle.class)
                ? field.getAnnotation(ToStringStyle.class).value()
                : Style.REFLECTION;
    }

    /**
     * Extract super class fields.
     * <p>
     * @param o the o
     * <p>
     * @return the field[]
     */
    private Field[] extractSuperClassFields(Object o) {
        Field[] classFields = o.getClass().getDeclaredFields();
        if (hasSuperType(o)) {
            Field[] superFields = o.getClass().getSuperclass().getDeclaredFields();
            List<Field> fields = new ArrayList<>();
            for (Field field : superFields) {
                if (isNotOn(classFields, field)) {
                    fields.add(field);
                }
            }
            if (fields.isEmpty()) {
                return classFields;
            } else {
                Collections.addAll(fields, classFields);
                return fields.toArray(new Field[]{});
            }
        } else {
            return classFields;
        }
    }

    /**
     * Checks if is not on.
     * <p>
     * @param classFields the class fields
     * @param field the field
     * <p>
     * @return true, if is not on
     */
    private boolean isNotOn(Field[] classFields, Field field) {
        for (Field classField : classFields) {
            if (field.getName().equals(classField.getName()) && field.getType().equals(classField.getType())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks for super type.
     * <p>
     * @param o the o
     * <p>
     * @return true, if successful
     */
    private boolean hasSuperType(Object o) {
        return !(o.getClass().getSuperclass().equals(Object.class));
    }

    /**
     * Checks if is to print field.
     * <p>
     * @param field the field
     * @param name the name
     * <p>
     * @return true, if is to print field
     */
    private boolean isToPrintField(Field field, String name) {
        return !(field.isAnnotationPresent(ToStringExclude.class)
                || "serialVersionUID".equals(name)
                || "this$0".equals(name)
                || Modifier.isStatic(field.getModifiers()));
    }
}
