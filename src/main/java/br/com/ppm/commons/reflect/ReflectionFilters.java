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

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

interface ReflectionFilters {

    /**
     * <p>filterByMethodName.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.util.function.Predicate} object.
     */
    static Predicate<Method> filterByMethodName(String name) {
        return (method) -> method.getName().equals(name);
    }

    /**
     * filterByMethodParameterTypes.
     *
     * @param typeParams a {@link java.lang.Class} object.
     * @return a {@link java.util.function.Predicate} object.
     */
    static Predicate<Method> filterByMethodParameterTypes(Class<?>... typeParams) {
        return (method) -> Arrays.equals(typeParams, method.getParameterTypes());
    }
}
