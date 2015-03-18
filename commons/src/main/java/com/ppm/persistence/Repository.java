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
package com.ppm.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * The Basic Data Access Object Operations
 * 
 * @param <T>
 *            The Generic Type
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
public interface Repository<T extends Serializable> {

	/**
	 * Persist a Entity on DataSource
	 * 
	 * @param entity
	 * @return
	 */
	T persist(final T entity);

	/**
	 * Find all entities.
	 * 
	 * @return the List of Entities
	 */
	List<T> findAll();

	/**
	 * Find a Entity by his Identity
	 * 
	 * @param id
	 *            a <code> Identity  </code>
	 * @return a Entity<T>
	 * @throws InfrastructureDaoException
	 */
	T findById(final Object id);

	/**
	 * Delete the Entity
	 * 
	 * @param entity
	 * @return 
	 * @throws InfrastructureDaoException
	 */
	boolean remove(final T entity);
}
