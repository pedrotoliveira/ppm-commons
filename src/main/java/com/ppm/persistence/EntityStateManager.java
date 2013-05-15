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
