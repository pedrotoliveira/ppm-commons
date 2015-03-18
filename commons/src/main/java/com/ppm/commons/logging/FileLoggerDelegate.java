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

import org.apache.log4j.Logger;

/**
 * File Logger Delegate
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class FileLoggerDelegate implements FileLogger {

	private final Logger logger;

	private FileLoggerDelegate(final Logger logger) {
		this.logger = logger;
	}

	/**
	 *
	 * @param logger
	 * @return
	 */
	protected static FileLoggerDelegate create(final Logger logger) {
		return new FileLoggerDelegate(logger);
	}

	@Override
	public void logInfo(Object message) {
		logger.info(message);
	}

	@Override
	public void logWarn(Object message) {
		logger.warn(message);
	}

	@Override
	public void logError(Object message) {
		logger.error(message);
	}

	@Override
	public void logDebug(Object message) {
		logger.debug(message);
	}

	@Override
	public void logInfo(Object message, Throwable t) {
		logger.info(message, t);
	}

	@Override
	public void logWarn(Object message, Throwable t) {
		logger.warn(message, t);
	}

	@Override
	public void logError(Object message, Throwable t) {
		logger.error(message, t);
	}

	@Override
	public void logDebug(Object message, Throwable t) {
		logger.debug(message, t);
	}

	@Override
	public LogData logData(Map<String, Object> logData) {
		return new LogDataBuilder(logger, logData);
	}

	@Override
	public LogData logData(Map<String, Object> logData, Throwable t) {
		return new LogDataBuilder(logger, logData, t);
	}

	@Override
	public LogKey logKey(String key) {
		return LogKeyValueBuilder.create(logger, key);
	}
}
