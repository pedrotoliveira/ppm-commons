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

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Validator Utils - A class with some utilities methods
 * Useful for identifying programmer errors early and clearly at runtime.
 *
 * @author Pedro T. Oliveira
 */
public class ValidatorUtils {

	/** No instances for this class */
	private ValidatorUtils() {
	}

	/**
	 * Validate if a parameter is Null.
	 *
	 * @param param     a Object parameter.
	 * @param paramName the parameter name.
	 *
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public static final void notNullParameter(Object param, final String paramName) {
		notNull(param, invalidParam(paramName));
	}

	/**
	 * Validate if a Array is Empty.
	 *
	 * @param param     a Array parameter.
	 * @param paramName the parameter name.
	 *
	 * @throws IllegalArgumentException if the array parameter is empty
	 */
	public static final void notEmptyParameter(Object[] param, final String paramName) {
		notEmpty(param, invalidParam(paramName));
	}

	/**
	 * Validate if a Array contains null elements.
	 *
	 * @param param     a Array parameter.
	 * @param paramName the parameter name.
	 *
	 * @throws IllegalArgumentException if the array parameter contains null elements.
	 */
	public static final void noNullElementsParameter(Object[] param, final String paramName) {
		noNullElements(param, invalidParam(paramName));
	}

	/**
	 * Validate if a String is not empty or null!
	 *
	 * @param param     a String parameter
	 * @param paramName the parameter name.
	 *
	 * @throws IllegalArgumentException if the parameter is null or empty
	 */
	public static final void isNotEmpty(final String param, final String paramName) {
		if (param == null || param.isEmpty()) {
			throw handleIllegalArgumentException(paramName);
		}
	}

	/**
	 * Validate if size is different from the parameter
	 *
	 * @param collection a Collection
	 * @param size the size of the collection
	 * @param paramName  the parameter name.
	 *
	 * @throws IllegalArgumentException if the parameter size is different
	 */
	public static final void correctSize(final Collection<?> collection, final int size, final String paramName) {
		notEmpty(collection, invalidParam(paramName));
		if (collection.size() != size) {
			throw handleIllegalArgumentException(paramName);
		}
	}

	/**
	 * Create a NoSuchElementException with a message: element + " not found."
	 *
	 * @param element the element name.
	 *
	 * @return NoSuchElementException
	 */
	public static final NoSuchElementException handleNoSuchElement(final String element) {
		return new NoSuchElementException(element + " not found.");
	}

	/**
	 * Create a IllegalArgumentException with a message: paramName is invalid.
	 *
	 * @param paramName the parameter name.
	 *
	 * @return IllegalArgumentException
	 */
	public static final IllegalArgumentException handleIllegalArgumentException(final String paramName) {
		return new IllegalArgumentException(invalidParam(paramName));
	}

	/**
	 * Create a NoSuchElementException whith a message equal the message
	 *
	 * @param msg the message
	 *
	 * @return IllegalStateException
	 */
	public static final IllegalStateException handleIllegalStateException(final String msg) {
		return new IllegalStateException(msg);
	}

	private static String invalidParam(final String paramName) {
		return String.format("%s is invalid.", paramName);
	}

	private static void notEmpty(Object[] param, String message) {
		if (param == null || param.length < 1) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void notNull(Object param, String message) {
		if (param == null) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void noNullElements(Object[] param, String message) {
		if (param == null) {
			throw new IllegalArgumentException(message);
		}

		for (Object o : param) {
			if (o == null) {
				throw new IllegalArgumentException(message);
			}
		}
	}

	private static void notEmpty(Collection<?> collection, String message) {
		if (collection == null || collection.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}
}
