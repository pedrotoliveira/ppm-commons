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
 * Perf4J Operations
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public interface Perf4JOperations {

	/**
	 * Starts this StopWatch, which sets its startTime property to the current
	 * time and resets the elapsedTime property. For single-use StopWatch
	 * instance you should not need to call this method as a StopWatch is
	 * automatically started when it is created. Note any existing tag and
	 * message are not changed.
	 */
	void start();

	/**
	 * Starts this StopWatch and sets its tag to the specified value. For
	 * single-use StopWatch instance you should not need to call this method as
	 * a StopWatch is automatically started when it is created. Note any
	 * existing message on this StopWatch is not changed.
	 *
	 * @param tag
	 *            The grouping tag for this StopWatch
	 */
	void start(final String tag);

	/**
	 * In cases where a code block terminated by throwing an exception, you may
	 * wish to have the exception logged in addition to the time it took to
	 * execute the block, in which case this method will write out the
	 * exception's stack trace in addition to the StopWatch timing method.
	 *
	 * @return this.toString(), however, this should not be passed to a logger
	 *         as it will have already been logged.
	 */
	String stop();

	/**
	 *
	 * @param tag
	 * @return
	 */
	String stop(final String tag);

	/**
	 *
	 * @param tag
	 * @param ex
	 * @return
	 */
	String stop(final String tag, final Exception ex);

	/**
	 *
	 * @param tag
	 * @param message
	 * @return
	 */
	String stop(final String tag, final String message);

	/**
	 *
	 * @param tag
	 * @return
	 */
	String lap(final String tag);
}
