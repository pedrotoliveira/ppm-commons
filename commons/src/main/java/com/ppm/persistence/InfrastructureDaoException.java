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
 * This Exception will be launched when occurs a Infrastructure Exception in the Data Mapping Layer
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
public class InfrastructureDaoException extends RuntimeException {

    /**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5062665471168786299L;

	/**
	 *
	 * @param cause
	 */
	public InfrastructureDaoException(Throwable cause) {
        super(cause);
    }

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public InfrastructureDaoException(String message, Throwable cause) {
        super(message, cause);
    }

	/**
	 *
	 * @param message
	 */
	public InfrastructureDaoException(String message) {
        super(message);
    }

	/**
	 *
	 */
	public InfrastructureDaoException() {
    }
}
