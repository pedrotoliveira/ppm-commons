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

/**
 * Maintains a list of objects affected by a business transaction and
 * coordinates the writing out of changes and the resolution of concurrency
 * problems.
 *
 * @author Pedro Oliveira
 */
public interface UnitOfWork {

    /**
     * The Enum Status.
     */
    enum Status {

		/** The NOT_INITIALIZED. */
		NOT_INITIALIZED,
		/** The NEW. */
		NEW,
		/** The ACTIVE. */
		ACTIVE,
		/** The COMMITING. */
		COMMITING,
		/** The COMMITTED. */
		COMMITTED,
		/** The ROLLING_BACK. */
		ROLLING_BACK,
		/** The ROLLEDBACK. */
		ROLLEDBACK,
		/** The SLEEPING. */
		SLEEPING,
		/** The ERROR. */
		ERROR
    }

    /**
     * Mark Entity to Insert.
     *
     * @param entity the entity
     */
    public void markToInsert(final Object entity);

    /**
     * Marca uma entidade para ser inserida, que depende das chaves dos pais.
     *
     * @param entity entidade a ser inserida.
     * @param parents pais que contem a chave para essa entidade.
     */
    public void markToInsert(final Object entity, final Object... parents);

    /**
     * Mark Entity to Update.
     *
     * @param entity the entity
     */
    public void markToUpdate(final Object entity);

    /**
     * Mark Entity to Delete.
     *
     * @param entity the entity
     */
    public void markToDelete(final Object entity);

    /**
     * Commit all Scheduled Operations.
     *
     */
    public void commit();

    /**
     * Rollback all Scheduled Operations.
     *
     */
    public void rollback();

    /**
     * Set all transactions to rollback.
     */
    public void setRollbackOnly();

    /**
     * Clean the state of the current Unit of Work.
     */
    public void clean();

    /**
     * The Current Status of the Unit of Work.
     *
     * @return the status
     */
    public Status getStatus();
}

