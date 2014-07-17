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
package com.ppm.commons.logging;

import java.util.Map;

/**
 * The Simple File Logger Interface.
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public interface FileLogger extends LogOperations {

	/**
	 *
	 * @param message
	 * @param t
	 */
	void logInfo(final Object message, final Throwable t);

	/**
	 *
	 * @param message
	 * @param t
	 */
	void logWarn(final Object message, final Throwable t);

	/**
	 *
	 * @param message
	 * @param t
	 */
	void logError(final Object message, final Throwable t);

	/**
	 *
	 * @param message
	 * @param t
	 */
	void logDebug(final Object message, final Throwable t);

	/**
	 *
	 * @param logData
	 * @param t
	 * @return
	 */
	LogData logData(final Map<String, Object> logData, final Throwable t);
}
