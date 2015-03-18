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

import java.util.Objects;

/**
 * Implements FluentLogger
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
public class LoggerService implements FluentLogger {

	private final LoggerHolder holder;

	private LoggerService(Class<?> clazz) {
		Objects.requireNonNull(clazz, "Class cannot be null.");
		holder = new LoggerHolder(clazz);
	}

	/**
	 * Initialize a new Fluent Logger based on a class
	 * @param clazz
	 * @return FluentLogger
	 */
	public static FluentLogger init(final Class<?> clazz) {
		return new LoggerService(clazz);
	}

	@Override
	public LogOperations all() {
		return holder;
	}

	@Override
	public Perf4JOperations perf4j() {
		return holder.getPerf4jDelegate();
	}

	@Override
	public FileLogger file() {
		return holder.getFileLoggerDelegate();
	}

	@Override
	public SplunkLogger splunk() {
		return holder.getSplunkLoggerDelegate();
	}
}
