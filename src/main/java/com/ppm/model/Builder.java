/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppm.model;

/**
 * A Generic Builder.
 *
 * @author Pedro T. Oliveira <pedro.oliveira.nom.br>
 */
public abstract class Builder<T> {

	protected final T instance;

	public Builder(T instance) {
		this.instance = instance;
		fillDefaultValues();
	}

	public abstract void fillDefaultValues();

	public abstract T build();
}
