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

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

/**
 * Perf4J Logger Delegate, delegate all operations for a real instance of StopWatch.
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class Perf4jDelegate implements Perf4JOperations {

	private final StopWatch stopWatch;

	private Perf4jDelegate(final Logger perf4j) {
		stopWatch = new Log4JStopWatch("Perf4J Timer Logger", perf4j);
	}

	/**
	 *
	 * @param perf4j
	 * @return
	 */
	protected static Perf4jDelegate create(final Logger perf4j) {
		return new Perf4jDelegate(perf4j);
	}

	@Override
	public void start() {
		stopWatch.start();
	}

	@Override
	public void start(String tag) {
		stopWatch.start(tag);
	}

	@Override
	public String stop() {
		return stopWatch.stop();
	}

	@Override
	public String stop(String tag) {
		return stopWatch.stop(tag);
	}

	@Override
	public String stop(String tag, Exception ex) {
		return stopWatch.stop(tag, ex.getMessage());
	}


	@Override
	public String lap(String tag) {
		return stopWatch.lap(tag);
	}

	@Override
	public String stop(String tag, String message) {
		return stopWatch.stop(tag, message);
	}
}
