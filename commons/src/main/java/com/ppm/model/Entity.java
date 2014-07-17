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
 * A Entity is any class that always has a unique Identity
 *
 * @author pedrot <pedro.oliveira20@gmail.com>
 * @param <I>
 */
public abstract class Entity<I extends Serializable> implements Serializable {

	/** The Serial Version UID */
	private static final long serialVersionUID = 1L;
	/** This Entity Identity */
	private I id;

	/** Default Constructor */
	public Entity() {
		id = null;
	}

	/**
	 * The Identity for this entity
	 *
	 * @param id <code> Identity </code>
	 *
	 * @throws NullPointerException to a invalid id field.
	 * @see Identity
	 */
	public Entity(I id) {
		Objects.requireNonNull(id, "this id is NULL");
		this.id = id;
	}

	/**
	 * Retrieve de Identity Field for this Entity
	 *
	 * @return a Identity<?>
	 */
	public I getId() {
		return id;
	}

	/**
	 * Mutator for this Identity.
	 *
	 * @param id
	 */
	public void setId(I id) {
		this.id = id;
	}

	/**
	 * Entities compare by identity, not by attributes.
	 *
	 * @param other The other entity.
	 *
	 * @return true if the identities are the same, regardless of other attributes.
	 */
	public boolean sameIdentityAs(final Entity<I> other) {
		return (other == null) ? false : other.getId().equals(id);
	}

	@Override
	public int hashCode() {
		return (id == null) ? super.hashCode() : id.hashCode();
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj instanceof Entity) {
			return sameIdentityAs((Entity<I>) obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
