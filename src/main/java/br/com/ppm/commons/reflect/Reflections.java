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
package br.com.ppm.commons.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.ppm.commons.number.Numbers;
import br.com.ppm.commons.string.Strings;
import br.com.ppm.commons.validation.ArgumentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.ppm.commons.type.Types.*;
import static br.com.ppm.commons.reflect.ReflectionFilters.filterByMethodName;
import static br.com.ppm.commons.reflect.ReflectionFilters.filterByMethodParameterTypes;

/**
 * Reflections Operations
 *
 * @author Pedro T. Oliveira
 * @version $Id: $Id
 */
public interface Reflections {

    /** Constant <code>logger</code> */
    Logger logger = LogManager.getLogger(Reflections.class);

    /** Constant <code>FIELD="field"</code> */
    String FIELD = "field";
    /** Constant <code>FIELD_NOT_FOUND="Field Not Found"</code> */
    String FIELD_NOT_FOUND = "Field Not Found";
    /** Constant <code>EXCEPTION_ACCESSING_FIELD="Exception accessing field"</code> */
    String EXCEPTION_ACCESSING_FIELD = "Exception accessing field";
    /** Constant <code>FIELDS_SEPARATOR="\\."</code> */
    String FIELDS_SEPARATOR = "\\.";
    /** Constant <code>TARGET="target"</code> */
    String TARGET = "target";
    /** Constant <code>FIELD_NAME="fieldName"</code> */
    String FIELD_NAME = "fieldName";

    /**
     * Return the Method get "Accessor" to a given Class Field.
     *
     * @param field the field
     * @return the string "getFieldName"
     */
    static String methodGet(final Field field) {
        ArgumentValidator.notNullParameter(field, FIELD);
        final String fieldName = Strings.capitalizeFirstLetter(field.getName());
        return "get".concat(fieldName);
    }

    /**
     * Return Method set "Mutator" to a given Class Field
     *
     * @param field the field
     * @return the string "setFieldName"
     */
    static String methodSet(final Field field) {
        ArgumentValidator.notNullParameter(field, FIELD);
        final String fieldName = Strings.capitalizeFirstLetter(field.getName());
        return "set".concat(fieldName);
    }

    /**
     * Find method that has no parameters.
     *
     * @param clazz a class
     * @param name  the method name to find
     * @return an Optional of Method
     */
    static Optional<Method> findMethod(final Class<?> clazz, final String name) {
        return Arrays.stream(clazz.getMethods())
                .filter(filterByMethodName(name))
                .findFirst();
    }

    /**
     * Find a method with specified parameter.
     *
     * @param clazz      a class
     * @param name       the method name
     * @param typeParams the method type parameters
     * @return an Optional of Method
     */
    static Optional<Method> findMethod(Class<?> clazz, String name, Class<?>... typeParams) {
        return Arrays.stream(clazz.getMethods())
                .filter(filterByMethodName(name))
                .filter(filterByMethodParameterTypes(typeParams))
                .findFirst();
    }

    /**
     * Gets the value by field name spaces, navigating in object hierarchy
     * <p>
     * Use the dot notation to navigate to the desired field
     * Example: "thing.child"
     * To get Map fields use the same notation "some.mapField.thing"
     * To get List fields use the index "some.listField.0";
     * </p>
     *
     * @param <T>        return type
     * @param fieldName  the field name
     * @param target     the target instance
     * @param returnType expected type that will be use to cat the result.
     * @return the value
     */
    static <T> T getValueByNamespace(final String fieldName, final Object target, Class<T> returnType) {
        ArgumentValidator.notNullParameter(returnType, "returnType");
        Optional<Object> optional = getValueByNamespace(fieldName, target);
        return returnType.cast(optional.orElse(null));
    }

    /**
     * Gets the value by field name spaces, navigating in object hierarchy
     * <p>
     * Use the dot notation to navigate to the desired field
     * Example: "thing.child"
     * To get Map fields use the same notation "some.mapField.thing"
     * To get List fields use the index "some.listField.0";
     * </p>
     *
     * @param fieldName the field name
     * @param target    the target instance
     * @return the value
     */
    static Optional<Object> getValueByNamespace(final String fieldName, final Object target) {
        ArgumentValidator.notNullParameter(fieldName, FIELD_NAME);
        String[] fields = fieldName.split(FIELDS_SEPARATOR);
        try {
            Optional<Object> value = Optional.of(target);
            for (String name : fields) {
                if (value.isPresent()) {
                    if (isMap(value.get())) {
                        value = getMapValueByFieldName(name, value.get());
                    } else if (isList(value.get())) {
                        value = getListValueByFieldName(name, value.get());
                    } else {
                        value = getValueByFieldName(name, value.get());
                    }
                }
            }
            return value;
        } catch (SecurityException | IllegalArgumentException e) {
            throw new IllegalArgumentException(EXCEPTION_ACCESSING_FIELD, e);
        }
    }

    /**
     * Get a value from a given field name in the Target Object instance
     *
     * @param fieldName name of the field
     * @param target    instance
     * @return Optional of Object
     */
    static Optional<Object> getValueByFieldName(final String fieldName, final Object target) {
        if (target == null) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable(getValueFromField(fieldName, target.getClass(), target));
        } catch (IllegalArgumentException ex) {
            logger.warn(FIELD_NOT_FOUND.concat(String.format("[%s] - Trying Parent Class", ex.getMessage())));
            Class<?> superClass = target.getClass().getSuperclass();
            if (superClass != null) {
                return Optional.ofNullable(getValueFromField(fieldName, superClass, target));
            }
        }
        throw ArgumentValidator.handleIllegalArgumentException(FIELD_NOT_FOUND);
    }

    /**
     * <p>getValueFromField.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param targetClass a {@link java.lang.Class} object.
     * @param target a {@link java.lang.Object} object.
     * @return a {@link java.lang.Object} object.
     */
    static Object getValueFromField(final String fieldName, final Class<?> targetClass, final Object target) {
        try {
            Field targetField = targetClass.getDeclaredField(fieldName);
            targetField.setAccessible(true);
            return targetField.get(target);
        } catch (NoSuchFieldException | IllegalAccessException | SecurityException ex) {
            throw new IllegalArgumentException(FIELD_NOT_FOUND, ex);
        }
    }

    /**
     * <p>getMapValueByFieldName.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param target a {@link java.lang.Object} object.
     * @return a {@link java.util.Optional} object.
     */
    static Optional<Object> getMapValueByFieldName(final String fieldName, final Object target) {
        if (isMap(target)) {
            Object value = ((Map<?, ?>) target).get(fieldName);
            return Optional.ofNullable(value);
        }
        return Optional.empty();
    }

    /**
     * <p>getListValueByFieldName.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param target a {@link java.lang.Object} object.
     * @return a {@link java.util.Optional} object.
     */
    static Optional<Object> getListValueByFieldName(final String fieldName, final Object target) {
        if (isList(target) && Numbers.isNumber(fieldName)) {
            int index = Integer.parseInt(fieldName);
            Object value = ((List<?>) target).get(index);
            return Optional.ofNullable(value);
        } else {
            return getValueByFieldName(fieldName, target);
        }
    }

    /**
     * <p>setByFieldName.</p>
     *
     * @param field a {@link java.lang.String} object.
     * @param target a {@link java.lang.Object} object.
     * @param value a {@link java.lang.Object} object.
     */
    static void setByFieldName(final String field, final Object target, final Object value) {
        ArgumentValidator.notNullParameter(field, FIELD);
        ArgumentValidator.notNullParameter(target, TARGET);
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
     *
     * @param field  the field
     * @param target the target
     * @return the by field get method
     */
    static Object getFieldByGetMethod(final Field field, final Object target) {
        ArgumentValidator.notNullParameter(field, FIELD);
        ArgumentValidator.notNullParameter(target, TARGET);
        try {
            String methodName = methodGet(field);
            Method method = target.getClass().getMethod(methodName);
            return method.invoke(target);
        } catch (NoSuchMethodException
                | SecurityException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            throw new IllegalArgumentException(EXCEPTION_ACCESSING_FIELD, ex);
        }
    }

    /**
     * <p>getValueByField.</p>
     *
     * @param field a {@link java.lang.reflect.Field} object.
     * @param target a {@link java.lang.Object} object.
     * @return a {@link java.util.Optional} object.
     * @throws java.lang.IllegalAccessException if any.
     */
    static Optional<Object> getValueByField(Field field, Object target) throws IllegalAccessException {
        ArgumentValidator.notNullParameter(field, FIELD);
        ArgumentValidator.notNullParameter(target, TARGET);
        if (!field.canAccess(target)) {
            field.setAccessible(true);
        }
        return Optional.ofNullable(field.get(target));
    }
}
