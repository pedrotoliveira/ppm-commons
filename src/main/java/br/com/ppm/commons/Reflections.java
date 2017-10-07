/*
 *  Copyright (C) 2016 Pedro T. Oliveira <pedro.oliveira.nom.br>
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
package br.com.ppm.commons;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Reflections Operations
 *
 * @author Pedro T. Oliveira
 */
public final class Reflections {

    /**
     * The Constant FIELDS_SEPARATOR.
     */
    private static final String FIELDS_SEPARATOR = "\\.";

    /**
     * No instances for this class
     */
    private Reflections() {
    }

    /**
     * Method get.
     *
     * @param field the field
     *
     * @return the string
     */
    public static String methodGet(final Field field) {
        final String fieldName = capitalizeFirstLetter(field.getName());
        return "get".concat(fieldName);
    }

    /**
     * Method set.
     *
     * @param field the field
     *
     * @return the string
     */
    public static String methodSet(final Field field) {
        final String fieldName = capitalizeFirstLetter(field.getName());
        return "set".concat(fieldName);
    }

    /**
     * Capitalize.
     *
     * @param str the str
     *
     * @return the string
     */
    private static String capitalizeFirstLetter(final String str) {
        return new StringBuilder(str.length()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    /**
     * Find method that has no parameters.
     *
     * @param clazz the clazz
     * @param name the name
     *
     * @return the method
     */
    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, null);
    }

    /**
     * Find method.
     *
     * @param clazz the clazz
     * @param name the name
     * @param paramType the param type
     *
     * @return the method
     */
    public static Method findMethod(Class<?> clazz, String name, Class<?> paramType) {
        Method[] methods = clazz.getMethods();
        Method toReturn = null;
        for (Method method : methods) {
            if (method.getName().equals(name)
                    && (paramType == null || Arrays.equals(new Class<?>[]{paramType}, method.getParameterTypes()))) {
                toReturn = method;
                break;
            }
        }
        return toReturn;
    }

    public static void copyProperties(final Object src, final Object dest) {
    }

    /**
     * Gets the value by field name.
     * <p>
     * Use the dot notation: "thing.child";
     * <p>
     * To access Map fields, use the same notation: "some.mapField.thing";
     * <p>
     * To access List fields, use the index: "some.listField.0";
     * <p>
     * @param fieldName the field
     * @param target the target
     * <p>
     * @return the by field name
     */
    public static Object getByFieldName(final String fieldName, final Object target) {
        String[] fields = fieldName.split(FIELDS_SEPARATOR);
        try {
            Object value = target;

            for (String fName : fields) {
                if (isMap(value)) {
                    value = getValueFromMap(fName, value);
                } else if (isList(value)) {
                    value = getValueFromList(fName, value);
                } else {
                    value = getValueFromField(fName, value);
                }
            }

            return value;
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalArgumentException("Exception accessing field", e);
        }
    }

    /**
     * Checks if is map.
     *
     * @param target the target
     * @return true, if is map
     */
    private static boolean isMap(final Object target) {
        return target instanceof Map<?, ?>;
    }

    /**
     * Checks if is list.
     *
     * @param target the target
     * @return true, if is list
     */
    private static boolean isList(final Object target) {
        return target instanceof List<?>;
    }

    private static Object getValueFromField(final String field, final Object target)
            throws NoSuchFieldException, SecurityException, IllegalAccessException {

        if (target == null) {
            return null;
        }
        Field f = null;
        try {
            f = target.getClass().getDeclaredField(field);
        } catch (NoSuchFieldException n) {
            if (target.getClass().getSuperclass() != null) {
                f = target.getClass().getSuperclass().getDeclaredField(field);
            }
        }
        f.setAccessible(true);
        return f.get(target);
    }

    private static Object getValueFromMap(final String field, final Object target) {
        if (target == null || !isMap(target)) {
            return null;
        }
        return ((Map<?, ?>) target).get(field);
    }

    private static Object getValueFromList(final String field, final Object target)
            throws NoSuchFieldException, SecurityException, IllegalAccessException {

        if (target == null || !isList(target)) {
            return null;
        }
        if (isNumber(field)) {
            int index = Integer.parseInt(field);
            return ((List<?>) target).get(index);
        } else {
            return getValueFromField(field, target);
        }
    }

    public static void setByFieldName(final String field, final Object target, final Object value) {

        try {
            Field f = target.getClass().getDeclaredField(field);
            f.setAccessible(true);
            f.set(target, value);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalArgumentException("Exception accessing field");
        }
    }

    /**
     * Gets the by field "get" method.
     * <p>
     * @param field the field
     * @param target the target
     * <p>
     * @return the by field get method
     */
    public static Object getFieldByGetMethod(final String field, final Object target) {
        Objects.requireNonNull(field, "Field is Empty");
        String methodName = String.format("get%s", capitalizeFirstLetter(field));

        try {
            Method method = target.getClass().getMethod(methodName);
            return method.invoke(target);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            throw new IllegalArgumentException("Exception accessing field", ex);
        }
    }

    private static boolean isNumber(String field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
