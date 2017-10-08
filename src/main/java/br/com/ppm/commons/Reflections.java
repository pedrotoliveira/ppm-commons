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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Reflections Operations
 *
 * @author Pedro T. Oliveira
 */
public final class Reflections {

    private static final Logger logger = LogManager.getLogger(Reflections.class);

    private static final String FIELD_NOT_FOUND = "Field Not Found";
    private static final String FIELD_CAN_NOT_BE_NULL = "Field Can not be null.";
    private static final String EXCEPTION_ACCESSING_FIELD = "Exception accessing field";
    private static final String FIELDS_SEPARATOR = "\\.";

    /**
     * No instances for this class
     */
    private Reflections() {
    }

    /**
     * Return the Method get "Accessor" to a given Class Field.
     *
     * @param field the field
     *
     * @return the string "getFieldName"
     */
    public static String methodGet(final Field field) {
        Validator.notNullParameter(field, FIELD_CAN_NOT_BE_NULL);
        final String fieldName = Strings.capitalizeFirstLetter(field.getName());
        return "get".concat(fieldName);
    }

    /**
     * Return Method set "Mutator" to a given Class Field
     *
     * @param field the field
     *
     * @return the string "setFieldName"
     */
    public static String methodSet(final Field field) {
        Validator.notNullParameter(field, FIELD_CAN_NOT_BE_NULL);
        final String fieldName = Strings.capitalizeFirstLetter(field.getName());
        return "set".concat(fieldName);
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
            throw new IllegalArgumentException(EXCEPTION_ACCESSING_FIELD, e);
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

    /**
     * Get a value from a given field in the Target Object
     *
     * @param fieldName
     * @param target
     * @return Object value
     */
    public static Object getValueFromField(final String fieldName, final Object target) {
        if (target == null) {
            return null;
        }
        try {
            return getValueFromField(fieldName, target.getClass(), target);
        } catch (IllegalArgumentException ex) {
            logger.warn(FIELD_NOT_FOUND.concat(String.format("[%s] - Trying Parent Class", ex.getMessage())));
            Class<?> superClass = target.getClass().getSuperclass();
            if (superClass != null) {
                return getValueFromField(fieldName, superClass, target);
            }
        }
        throw Validator.handleIllegalArgumentException(FIELD_NOT_FOUND);
    }

    private static Object getValueFromField(final String fieldName, final Class<?> targetClass, final Object target) {
        try {
            Field targetField = targetClass.getDeclaredField(fieldName);
            targetField.setAccessible(true);
            return targetField.get(target);
        } catch (NoSuchFieldException | IllegalAccessException | SecurityException ex) {
            throw new IllegalArgumentException(FIELD_NOT_FOUND, ex);
        }
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
        if (Numbers.isNumber(field)) {
            int index = Integer.parseInt(field);
            return ((List<?>) target).get(index);
        } else {
            return getValueFromField(field, target);
        }
    }

    /**
     *
     * @param field
     * @param target
     * @param value
     */
    public static void setByFieldName(final String field, final Object target, final Object value) {
        Validator.notNullParameter(field, "Field Can not Be Null");
        Validator.notNullParameter(target, "Target Can not Be Null");
        try {
            Field targetField = target.getClass().getDeclaredField(field);
            targetField.setAccessible(true);
            targetField.set(target, value);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            throw new IllegalArgumentException(EXCEPTION_ACCESSING_FIELD, ex);
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
    public static Object getFieldByGetMethod(final Field field, final Object target) {
        Validator.notNullParameter(field, "Field Can not Be Null");
        Validator.notNullParameter(target, "Target Can not Be Null");
        try {
            String methodName = methodGet(field);
            Method method = target.getClass().getMethod(methodName);
            return method.invoke(target);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            throw new IllegalArgumentException(EXCEPTION_ACCESSING_FIELD, ex);
        }
    }
}
