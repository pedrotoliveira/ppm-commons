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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.ppm.commons.annotation.ReflectionCopyExclude;

/**
 *
 * @author Pedro T. Oliveira <pedro.oliveira.nom.br>
 */
public final class Reflections {

	/**
	 * No instances for this class
	 */
	private Reflections() {
	}

	/**
	 * Method get.
	 *
	 * @param field
	 *            the field
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
	 * @param field
	 *            the field
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
	 * @param str
	 *            the str
	 *
	 * @return the string
	 */
	private static String capitalizeFirstLetter(final String str) {
		return new StringBuilder(str.length())
				.append(Character.toUpperCase(str.charAt(0)))
				.append(str.substring(1)).toString();
	}

	/**
	 * Find method that has no parameters.
	 *
	 * @param clazz
	 *            the clazz
	 * @param name
	 *            the name
	 *
	 * @return the method
	 */
	public static Method findMethod(Class<?> clazz, String name) {
		return findMethod(clazz, name, null);
	}

	/**
	 * Find method.
	 *
	 * @param clazz
	 *            the clazz
	 * @param name
	 *            the name
	 * @param paramType
	 *            the param type
	 *
	 * @return the method
	 */
	public static Method findMethod(Class<?> clazz, String name,
			Class<?> paramType) {
		Method[] methods = clazz.getMethods();
		Method toReturn = null;
		for (Method method : methods) {
			if (method.getName().equals(name)
					&& (paramType == null || Arrays.equals(
							new Class[] { paramType },
							method.getParameterTypes()))) {
				toReturn = method;
				break;
			}
		}
		return toReturn;
	}

	/**
	 *
	 * @param src
	 * @param dest
	 */
	public static void copyProperties(final Object src, final Object dest) {

	}

	/**
	 * Copy properties from orig to dest, avoiding fields that are Null, empty
	 * Map or Set, or annoted with @ReflectionIgnore
	 *
	 * @param t
	 * @param orig
	 * @param dest
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void copyNonNullFields(Class<?> t, Object orig, Object dest)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		Field[] fields = t.getDeclaredFields();

		for (Field field : fields) {
			if (!ignore(field)) {
				String get = methodGet(field);
				String set = methodSet(field);

				Method getMethod = t.getMethod(get, (Class<?>[]) null);
				Method setMethod = t.getMethod(set, field.getType());

				Object value = getMethod.invoke(orig, (Object[]) null);
				if (value != null && !isEmpty(value)) {
					setMethod.invoke(dest, new Object[] { value });
				}
			}
		}
	}

	private static boolean ignore(Field field) {
		return field.isAnnotationPresent(ReflectionCopyExclude.class);
	}

	@SuppressWarnings("rawtypes")
	private static boolean isEmpty(Object o) {
		if (o instanceof Map) {
			return ((Map)o).isEmpty();
		} else if ( o instanceof Set) {
			return ((Set)o).isEmpty();
		} else {
			return false;
		}
	}
}
