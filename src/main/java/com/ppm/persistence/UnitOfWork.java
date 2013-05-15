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
     * @return true if service is done.
     */
    public void commit();

    /**
     * Rollback all Scheduled Operations.
     * 
     * @return true if service is done.
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

