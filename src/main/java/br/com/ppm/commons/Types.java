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

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Expose type checks
 *
 * @author pedrotoliveira
 */
public final class Types {

    private Types() {
    }

    /**
     * Checks if is array.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is array
     */
    public static boolean isArray(Object value) {
        return value.getClass().isArray();
    }

    /**
     * Have implemented to string.
     * <p>
     * @param value the value
     * <p>
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
     * <p>
     * @param value the value
     * <p>
     * @return true, if is wrapper
     */
    public static boolean isWrapper(Object value) {
        return value.getClass().isPrimitive()
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
                || value instanceof Enum<?>;
    }

    /**
     * Checks if is map.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is map
     */
    public static boolean isMap(Object value) {
        return value instanceof Map;
    }

    /**
     * Checks if is collection.
     * <p>
     * @param value the value
     * <p>
     * @return true, if is collection
     */
    public static boolean isCollection(Object value) {
        return value instanceof Collection;
    }

    /**
     * Checks if is List
     *
     * @param target the target
     * @return true, if is list
     */
    public static boolean isList(final Object target) {
        return target instanceof List;
    }

}
