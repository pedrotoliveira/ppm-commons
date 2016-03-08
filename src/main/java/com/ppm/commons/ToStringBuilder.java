/*
 *  Copyright (C) 2010 Pedro T. Oliveira <pedro.oliveira.nom.br>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ppm.commons;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ppm.commons.annotation.ToStringExclude;
import com.ppm.commons.annotation.ToStringStyle;
import com.ppm.commons.annotation.ToStringStyle.Style;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * ToStringBuilder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public final class ToStringBuilder {

    /**
     * The Constant logger.
     */
    //private static final FluentLogger logger = LoggerService.init(ToStringBuilder.class);
    /**
     * The Constant PAGE_SIZE.
     */
    private static final int PAGE_SIZE = 15;

    /**
     * The Constant EQUAL.
     */
    private static final String EQUAL = "=";

    /**
     * The Constant COMMA.
     */
    private static final String COMMA = ", ";

    /**
     * The Constant IGNORE_SUPER_TYPES.
     */
    private static final boolean IGNORE_SUPER_TYPES = true;

    /**
     * The Constant NOT_IGNORE_SUPER_TYPES.
     */
    private static final boolean NOT_IGNORE_SUPER_TYPES = false;

    /**
     * The Constant DEFAULT_ERROR.
     */
    private static final String DEFAULT_ERROR = "<We got some error on ToStringBuilder!>";

    /**
     * The Constant TO_MANY_TO_STRING_CALLS_VIOLATION.
     */
    private static final String TO_MANY_TO_STRING_CALLS_VIOLATION = "<We got some error on ToStringBuilder, reflectionToString"
            + " method has reached the max depth calls! Please verify the circular references.>";

    private final Object object;

    public ToStringBuilder(final Object o) {
        this.object = o;
    }

    public String reflectionToString() {
        return ToStringBuilder.reflectionToString(object, NOT_IGNORE_SUPER_TYPES);
    }

    /**
     * Create a toString Pattern for an object and its super type, if any.
     * <p>
     * @param o the Object
     * <p>
     * @return toString Pattern
     */
    public static String reflectionToString(final Object o) {
        return reflectionToString(o, NOT_IGNORE_SUPER_TYPES);
    }

    /**
     * Create a toString Pattern for an object and its super type, if we want to.
     * <p>
     * @param o               the Object
     * @param ignoreSuperType has to ignore the superType ?
     * <p>
     * @return toString Pattern
     */
    public static String reflectionToString(final Object o, boolean ignoreSuperType) {
        return reflectionToString(o, ignoreSuperType, null);
    }

    /**
     * Reflection to string.
     * <p>
     * @param o               the o
     * @param ignoreSuperType the ignore super type
     * @param style           the style
     * <p>
     * @return the string
     */
    private static String reflectionToString(Object o, boolean ignoreSuperType, Style style) {
        if (o == null) {
            return "Object=null ";
        }
        StringBuilder builder = new StringBuilder();
        if (RecursiveToStringDepthController.isAllowed()) {
            if (isArray(o)) {
                appendArrayValues(o, builder);
            } else if (isWrapper(o)) {
                builder.append("[");
                builder.append(o);
                builder.append("]");
            } else if (isCollection(o)) {
                appendCollection((Collection<?>) o, builder);
            } else if (isMap(o)) {
                appendMap((Map<?, ?>) o, builder);
            } else {
                builder.append(o.getClass().getSimpleName());
                builder.append("[");
                builder.append(toStringFields(o, ignoreSuperType, style));
                builder.delete(builder.length() - 2, builder.length());
                builder.append("]");
            }
        } else {
            builder.append("[");
            builder.append(TO_MANY_TO_STRING_CALLS_VIOLATION);
            builder.append("]");
        }
        return builder.toString();
    }

    /**
     * To string fields.
     * <p>
     * @param o               the o
     * @param ignoreSuperType the ignore super type
     * @param style           the style
     * <p>
     * @return the string
     */
    private static String toStringFields(Object o, boolean ignoreSuperType, Style style) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = (ignoreSuperType) ? o.getClass().getDeclaredFields() : extractSuperClassFields(o);
        for (Field field : fields) {
            String name = field.getName();
            if (isToPrintField(field, name)) {
                Style selectedStyle = selectStyle(style, field);
                appendValue(o, field, name, builder, selectedStyle);
            }
        }
        return builder.toString();
    }

    /**
     * Select style.
     * <p>
     * @param current the current
     * @param field   the field
     * <p>
     * @return the style
     */
    private static Style selectStyle(Style current, Field field) {
        return (current == null) ? getFieldStyle(field) : current;
    }

    /**
     * Gets the field style.
     * <p>
     * @param field the field
     * <p>
     * @return the field style
     */
    private static Style getFieldStyle(Field field) {
        return (field.isAnnotationPresent(ToStringStyle.class))
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
    private static Field[] extractSuperClassFields(Object o) {
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
     * @param field       the field
     * <p>
     * @return true, if is not on
     */
    private static boolean isNotOn(Field[] classFields, Field field) {
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
    private static boolean hasSuperType(Object o) {
        return !(o.getClass().getSuperclass().equals(Object.class));
    }

    /**
     * Checks if is to print field.
     * <p>
     * @param field the field
     * @param name  the name
     * <p>
     * @return true, if is to print field
     */
    private static boolean isToPrintField(Field field, String name) {
        return !(field.isAnnotationPresent(ToStringExclude.class)
                || "serialVersionUID".equals(name)
                || "this$0".equals(name)
                || Modifier.isStatic(field.getModifiers()));
    }

    /**
     * Append value.
     * <p>
     * @param o       the o
     * @param field   the field
     * @param name    the name
     * @param builder the builder
     * @param style   the style
     */
    private static void appendValue(Object o, final Field field, final String name, final StringBuilder builder, Style style) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object value = field.get(o);
            if (value == null) {
                if (Style.IGNORE_NULL.equals(style)) {
                    return;
                }
                builder.append(name).append(EQUAL);
                builder.append("null");
            } else if (isArray(value)) {
                builder.append(name).append(EQUAL);
                appendArrayValues(o, field, builder);
            } else if (isWrapper(value) || Style.CALL_TO_STRING.equals(style) || Style.MASK_FIELD.equals(style) || haveImplementedToString(value)) {
                builder.append(name).append(EQUAL);
                builder.append(Style.MASK_FIELD.equals(style) ? maskField(value) : value.toString());
            } else if (isCollection(value)) {
                builder.append(name).append(EQUAL);
                appendCollection((Collection<?>) value, builder);
            } else if (isMap(value)) {
                builder.append(name).append(EQUAL);
                appendMap((Map<?, ?>) value, builder);
            } else {
                builder.append(name).append(EQUAL);
                builder.append(reflectionToString(value, IGNORE_SUPER_TYPES, style));
            }

            builder.append(COMMA);

        } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            handleException(ex, builder);
        }
    }

    /**
     * Handle exception.
     * <p>
     * @param ex      the ex
     * @param builder the builder
     */
    private static void handleException(Exception ex, StringBuilder builder) {
        //logger.file().logError(DEFAULT_ERROR, ex);
        builder.append(DEFAULT_ERROR);
    }

    /**
     * Mask a String value.
     *
     * @param value to mask
     * <p>
     * @return the masked String
     */
    public static String mask(String value) {
        ValidatorUtils.notNullParameter(value, "value");
        return maskField(value).toString();
    }

    /**
     * Mask field.
     * <p>
     * @param value the value
     * <p>
     * @return the object
     */
    private static Object maskField(Object value) {
        String strValue = value.toString();
        final int size = strValue.length();

        if (size < 11) {
            return strValue.replaceAll("\\.", "*");
        }

        final int lastPart = 4;
        final int firstPart = 6;
        final int maskSize = size - lastPart - firstPart;

        final StringBuilder sb = new StringBuilder(strValue.substring(0, firstPart));
        for (int i = 0; i < maskSize; i++) {
            sb.append("*");
        }
        sb.append(strValue.substring(size - lastPart, size));
        return sb.toString();
    }

    /**
     * Checks if is array.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is array
     */
    private static boolean isArray(Object value) {
        return value.getClass().isArray();
    }

    /**
     * Have implemented to string.
     * <p>
     * @param value the value
     * <p>
     * @return true, if successful
     */
    private static boolean haveImplementedToString(Object value) {
        try {
            Method toString = value.getClass().getDeclaredMethod("toString");
            return (toString != null);
        } catch (SecurityException | NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * Checks if is wrapper.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is wrapper
     */
    private static boolean isWrapper(Object value) {
        return (value.getClass().isPrimitive()
                || value.getClass().isInterface()
                || value instanceof String
                || value instanceof Integer
                || value instanceof Double
                || value instanceof Short
                || value instanceof Long
                || value instanceof Float
                || value instanceof Character
                || value instanceof Boolean
                || value instanceof Byte
                || value instanceof Date
                || value instanceof Calendar
                || value instanceof Locale
                || value instanceof Class<?>
                || value instanceof Enum<?>);
    }

    /**
     * Checks if is map.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is map
     */
    private static boolean isMap(Object value) {
        return (value instanceof Map);
    }

    /**
     * Checks if is collection.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is collection
     */
    private static boolean isCollection(Object value) {
        return (value instanceof Collection);
    }

    /**
     * Append array values.
     * <p>
     * @param o       the o
     * @param field   the field
     * @param builder the builder
     * <p>
     * @throws IllegalArgumentException the illegal argument exception
     * @throws IllegalAccessException   the illegal access exception
     */
    private static void appendArrayValues(Object o, Field field, StringBuilder builder) throws IllegalArgumentException,
            IllegalAccessException {
        Object array = field.get(o);
        appendArrayValues(array, builder);
    }

    /**
     * Append array values.
     * <p>
     * @param array   the array
     * @param builder the builder
     */
    private static void appendArrayValues(Object array, StringBuilder builder) {
        int lenght = Array.getLength(array);
        builder.append("[");
        if (lenght > PAGE_SIZE) {
            appendArrayValuesRange(array, builder, 0, PAGE_SIZE);
            builder.append(", ...");
        } else {
            appendArrayValuesRange(array, builder, 0, lenght);
        }
        builder.append("]");
    }

    /**
     * Append array values range.
     * <p>
     * @param array      the array
     * @param builder    the builder
     * @param beginIndex the begin index
     * @param endIndex   the end index
     */
    private static void appendArrayValuesRange(Object array, StringBuilder builder, int beginIndex, int endIndex) {
        for (int i = beginIndex; i < endIndex; i++) {
            Object element = Array.get(array, i);
            if (element != null && element.getClass().isArray()) {
                appendArrayValues(element, builder);
            } else {
                builder.append(element);
                if (i != (endIndex - 1)) {
                    builder.append(COMMA);
                }
            }
        }
    }

    /**
     * Append collection.
     * <p>
     * @param collection the collection
     * @param builder    the builder
     */
    @SuppressWarnings("unchecked")
    private static void appendCollection(Collection<?> collection, StringBuilder builder) {
        try {
            builder.append(collection.getClass().getSimpleName()).append("{ ");
            int counter = 0;
            for (Iterator<Object> it = (Iterator<Object>) collection.iterator(); it.hasNext();) {
                Object element = it.next();
                appendCollectionValue(element, builder);
                if (it.hasNext()) {
                    builder.append(COMMA);
                }
                counter++;
                if (counter == PAGE_SIZE) {
                    builder.append(", ...");
                    break;
                }
            }
            builder.append(" }");
        } catch (Exception ex) {
            handleException(ex, builder);
        }
    }

    /**
     * Append collection value.
     * <p>
     * @param element the element
     * @param builder the builder
     */
    private static void appendCollectionValue(Object element, StringBuilder builder) {
        try {
            if (element == null) {
                builder.append(element);
            } else if (isArray(element)) {
                appendArrayValues(element, builder);
            } else if (isWrapper(element) || haveImplementedToString(element)) {
                builder.append("[");
                builder.append(element);
                builder.append("]");
            } else if (isCollection(element)) {
                appendCollection((Collection<?>) element, builder);
            } else if (isMap(element)) {
                appendMap((Map<?, ?>) element, builder);
            } else {
                builder.append(reflectionToString(element, IGNORE_SUPER_TYPES));
            }
        } catch (Exception ex) {
            handleException(ex, builder);
        }
    }

    /**
     * Append map.
     * <p>
     * @param map     the map
     * @param builder the builder
     */
    @SuppressWarnings("unchecked")
    private static void appendMap(Map<?, ?> map, StringBuilder builder) {
        try {
            builder.append("Map{ ");
            int counter = 1;
            for (Iterator<Object> keyIt = (Iterator<Object>) map.keySet().iterator(); keyIt.hasNext();) {
                Object key = keyIt.next();
                builder.append("(k").append(counter).append(EQUAL);
                builder.append(key);
                builder.append(", v").append(counter).append(EQUAL);
                appendCollectionValue(map.get(key), builder);
                builder.append(")");
                if (keyIt.hasNext()) {
                    builder.append(COMMA);
                }
                counter++;
            }
            builder.append(" }");
        } catch (Exception ex) {
            handleException(ex, builder);
        }
    }
}
