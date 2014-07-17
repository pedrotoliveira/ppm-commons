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
import com.ppm.commons.logging.FluentLogger;
import com.ppm.commons.logging.LoggerService;


/**
 * ToStringBuilder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public final class ToStringBuilder {

	private static final FluentLogger logger = LoggerService.init(ToStringBuilder.class);
	private static final int PAGE_SIZE = 15;
	private static final String EQUAL = "=";
	private static final String COMMA = ", ";
	private static final boolean IGNORE_SUPER_TYPES = true;

	/**
	 * Create a toString Pattern for an object and its super type, if any.
	 *
	 * @param o the Object
	 * @return toString Pattern
	 */
	public static String reflectionToString(final Object o) {
		return reflectionToString(o, false);
	}

	/**
	 * Create a toString Pattern for an object and its super type, if we want to.
	 *
	 * @param o the Object
	 * @param ignoreSuperType has to ignore the superType ?
	 * @return toString Pattern
	 */
	public static String reflectionToString(final Object o, boolean ignoreSuperType) {
		if (o == null) {
			return "Object=null ";
		}
		StringBuilder builder = new StringBuilder(o.getClass().getSimpleName());
		builder.append("[");
		Field[] fields = (ignoreSuperType) ? o.getClass().getDeclaredFields() : extractSuperClassFields(o);
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String name = field.getName();
			Style style = getFieldStyle(field);
			if (isToPrintField(field, name)) {
				appendValue(o, field, name, builder, style);
			} else {
				continue;
			}
		}
		builder.delete(builder.length() - 2, builder.length());
		builder.append("]");
		return builder.toString();
	}

	private static Style getFieldStyle(Field field) {
		return (field.isAnnotationPresent(ToStringStyle.class)) ? field.getAnnotation(ToStringStyle.class).value() : Style.REFLECTION;
	}

	/**
	 *
	 * @param o
	 * @param ignoreSuperType
	 * @param style
	 * @return
	 */
	public static String reflectionToString(Object o, boolean ignoreSuperType, Style style) {
		if (o == null) {
			return "Object=null ";
		}
		StringBuilder builder = new StringBuilder(o.getClass().getSimpleName());
		builder.append("[");
		Field[] fields = (ignoreSuperType) ? o.getClass().getDeclaredFields() : extractSuperClassFields(o);
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String name = field.getName();
			if (isToPrintField(field, name)) {
				appendValue(o, field, name, builder, style);
			} else {
				continue;
			}
		}
		builder.delete(builder.length() - 2, builder.length());
		builder.append("]");
		return builder.toString();
	}

	private static Field[] extractSuperClassFields(Object o) {
		Field[] classFields = o.getClass().getDeclaredFields();
		if (hasSuperType(o)) {
			Field[] superFields = o.getClass().getSuperclass().getDeclaredFields();
			List<Field> fields = new ArrayList<Field>();
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

	private static boolean isNotOn(Field[] classFields, Field field) {
		for (Field classField : classFields) {
			if (field.getName().equals(classField.getName())
					&& field.getType().equals(classField.getType())) {
				return false;
			}
		}
		return true;
	}

	private static boolean hasSuperType(Object o) {
		return !(o.getClass().getSuperclass().equals(Object.class));
	}

	private static boolean isToPrintField(Field field, String name) {
		return	!(field.isAnnotationPresent(ToStringExclude.class)
					|| "serialVersionUID".equals(name)
					|| "this$0".equals(name)
					|| Modifier.isStatic(field.getModifiers()));
	}

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
			} else if (isWrapper(value) || Style.CALL_TO_STRING.equals(style) || haveImplementedToString(value)) {
				builder.append(name).append(EQUAL);
				builder.append(value);
			} else if (isCollection(value)) {
				builder.append(name).append(EQUAL);
				appendCollection((Collection<?>)value, builder);
			} else if (isMap(value)) {
				builder.append(name).append(EQUAL);
				appendMap((Map<?,?>) value, builder);
			} else {
				builder.append(name).append(EQUAL);
				builder.append(reflectionToString(value, IGNORE_SUPER_TYPES, style));
			}

			builder.append(COMMA);

		} catch (Exception ex) {
			logger.file().logError("We got some error on ToStringBuilder!", ex);
			builder.append("<We got some error on ToStringBuilder!>");
		}
	}

	private static boolean isArray(Object value) {
		return value.getClass().isArray();
	}

	private static boolean haveImplementedToString(Object value) {
		try {
			Method toString = value.getClass().getDeclaredMethod("toString");
			return (toString != null);
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}

	private static boolean isWrapper(Object value) {
		return (value.getClass().isPrimitive()
				|| value instanceof String
				|| value instanceof Integer
				|| value instanceof Double
				|| value instanceof Short
				|| value instanceof Long
				|| value instanceof Float
				|| value instanceof Character
				|| value instanceof Boolean
				|| value instanceof Byte
				|| value instanceof Class<?>);
	}

	private static boolean isMap(Object value) {
		return (value instanceof Map);
	}

	private static boolean isCollection(Object value) {
		return (value instanceof Collection);
	}

	private static void appendArrayValues(Object o, Field field, StringBuilder builder) throws IllegalArgumentException,
			IllegalAccessException {
		Object array = field.get(o);
		appendArrayValues(array, builder);
	}

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

	@SuppressWarnings("unchecked")
	private static void appendCollection(Collection<?> collection, StringBuilder builder) {
		builder.append(collection.getClass().getSimpleName()).append("{ ");
		for (Iterator<Object> it = (Iterator<Object>) collection.iterator(); it.hasNext();) {
			Object element = it.next();
			appendCollectionValue(element, builder);
			if (it.hasNext()) {
				builder.append(COMMA);
			}
		}
		builder.append(" }");
	}

	private static void appendCollectionValue(Object element, StringBuilder builder) {
		if (element == null) {
			builder.append(element);
		} else if (isWrapper(element)) {
			builder.append("[");
			builder.append(element);
			builder.append("]");
		} else {
			builder.append(reflectionToString(element, IGNORE_SUPER_TYPES));
		}
	}

	@SuppressWarnings("unchecked")
	private static void appendMap(Map<?, ?> map, StringBuilder builder) {
		builder.append("Map{ ");
		int counter = 1;
		for (Iterator<Object> keyIt = (Iterator<Object>) map.keySet().iterator(); keyIt.hasNext();) {
			Object key = keyIt.next();
			builder.append("(K").append(counter).append(EQUAL);
			builder.append(key);
			builder.append(", V").append(counter).append(EQUAL);
			appendCollectionValue(map.get(key), builder);
			builder.append(")");
			if (keyIt.hasNext()) {
				builder.append(COMMA);
			}
			counter++;
		}
		builder.append(" }");
	}
}
