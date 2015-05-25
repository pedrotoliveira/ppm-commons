package com.ppm.commons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

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
				&& (paramType == null || Arrays.equals(new Class[]{paramType}, method.getParameterTypes()))) {
				toReturn = method;
				break;
			}
		}
		return toReturn;
	}
	
	public static void copyProperties(final Object src, final Object dest) {
		
	}
}
