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

/**
 * Interface that contains methods "as some log level" to use in a fluent way.
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public interface AsLevel {

	/**
	 * Log information as Info
	 * @return AsLevel
	 */
	AsLevel asInfo();

	/**
	 * Log information as Warn
	 * @return AsLevel
	 */
	AsLevel asWarn();

	/**
	 * Log information as Error
	 * @return AsLevel
	 */
	AsLevel asError();

	/**
	 * Log information as Debug
	 * @return AsLevel
	 */
	AsLevel asDebug();
}
