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
package com.ppm.model;

import java.io.Serializable;
import java.util.Objects;

import com.ppm.commons.ToStringBuilder;

/**
 * Saves a database ID field in an object to maintain indentity between an
 * in-memory object and a database row.
 *
 * @param <T> The Identity Type
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
public class Identity<T> implements Serializable {

	/**
	 * The Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected T value;

	/**
	 * Default Constructor
	 *
	 * @param type the identity type
	 */
	public Identity(T type) {
		this.value = type;
	}

	/**
	 * A Generic Constructor raw type.
	 *
	 * @param <T>
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Identity<T> newId(Object value) {
		return new Identity<>((T) value);
	}

	/**
	 * Get the field value.
	 *
	 * @return this filed Object
	 */
	public T value() {
		return value;
	}

	/**
	 * Get the field value.
	 *
	 * @return this filed Object
	 */
	public T get() {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Identity) {
			final Identity<T> other = (Identity<T>) obj;
			return Objects.equals(this.value, other.value());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
