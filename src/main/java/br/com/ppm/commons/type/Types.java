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
        return Objects.nonNull(value) &&
                (value.getClass().isPrimitive() || WrapperTypes.anyMatch(value));
    }

    /**
     * Check if the Object value is an Interface
     *
     * @param value value to check
     * @return true if is an Interface
     */
    public static boolean isInterface(Object value) {
        return Objects.nonNull(value) && value.getClass().isInterface();
    }

    /**
     * Checks if the Object value is an Enum
     *
     * @param value value to check
     * @return true if is an Enum
     */
    public static boolean isEnum(Object value) {
        return Objects.nonNull(value) && value instanceof Enum<?>;
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
