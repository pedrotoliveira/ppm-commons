/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.type;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Expose type checks
 *
 * @author pedrotoliveira
 */
public final class Types {

    private Types() {
        throw new AssertionError("No instances for you!");
    }

    /**
     * Checks if is array.
     * <p>
     *
     * @param value the value
     *              <p>
     * @return true, if is array
     */
    public static boolean isArray(Object value) {
        return value.getClass().isArray();
    }

    /**
     * Have implemented to string.
     *
     * @param value the value
     * @return true, if successful
     */
    public static boolean hasImplementedToString(Object value) {
        try {
            Method toStringMethod = value.getClass().getDeclaredMethod("toString");
            return toStringMethod != null;
        } catch (SecurityException | NoSuchMethodException ex) {
            return false;
        }
    }

    /**
     * Checks if is wrapper.
     *
     * @param value the value
     * @return true, if is wrapper
     */
    public static boolean isWrapper(Object value) {
        return value.getClass().isPrimitive()
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
                || value instanceof Enum<?>;
    }

    /**
     * Check if the Object value is an Interface
     *
     * @param value value to check
     * @return true if is an Interface
     */
    public static boolean isInterface(Object value) {
        return value.getClass().isInterface();
    }

    /**
     * Checks if is a map
     *
     * @param value the value
     * @return true, if is map
     */
    public static boolean isMap(Object value) {
        return value instanceof Map;
    }

    /**
     * Checks if is collection.
     *
     * @param value the value
     * @return true, if is a Collection
     */
    public static boolean isCollection(Object value) {
        return value instanceof Collection;
    }

    /**
     * Checks if is List
     *
     * @param target the target
     * @return true, if is a List
     */
    public static boolean isList(final Object target) {
        return target instanceof List;
    }

}
