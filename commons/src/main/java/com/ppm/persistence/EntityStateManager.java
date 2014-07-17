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

import java.util.Set;

/**
 * The Entity State Manager Interface.
 * @author Pedro Oliveira
 */
public interface EntityStateManager extends UnitOfWork {

	/**
	 * Begin.
	 */
	void begin();

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#markToInsert(java.lang.Object)
	 */
	@Override
	void markToInsert(final Object entity);

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#markToInsert(java.lang.Object,
	 * java.lang.Object[])
	 */
	@Override
	void markToInsert(final Object entity, final Object... parents);

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#markToUpdate(java.lang.Object)
	 */
	@Override
	void markToUpdate(final Object entity);

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#markToDelete(java.lang.Object)
	 */
	@Override
	void markToDelete(final Object entity);

	/**
	 * Mark all to insert.
	 *
	 * @param collection the collection
	 */
	void markAllToInsert(final Set<?> collection);

	/**
	 * Mark all to update.
	 *
	 * @param collection the collection
	 */
	void markAllToUpdate(final Set<?> collection);

	/**
	 * Mark all to remove.
	 *
	 * @param collection the collection
	 */
	void markAllToRemove(final Set<?> collection);

	/**
	 * Find by id.
	 *
	 * @param classz the classz
	 * @param id the id
	 *
	 * @return the object
	 */
	Object findById(final Class<?> classz, final Object id);

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#commit()
	 */
	@Override
	void commit();

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#rollback()
	 */
	@Override
	void rollback();

	/*
	 * (non-Javadoc) @see
	 * com.porto.portoprint.automovel.persistence.UnitOfWork#setRollbackOnly()
	 */
	@Override
	void setRollbackOnly();
}
