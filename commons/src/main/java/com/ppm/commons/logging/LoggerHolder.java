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
 * Logger Holder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LoggerHolder implements LogOperations {

	private final Perf4jDelegate perf4jDelegate;

	private final FileLoggerDelegate fileLoggerDelegate;

	private final SplunkLoggerDelegate splunkLoggerDelegate;

	/**
	 *
	 * @param clazz
	 */
	public LoggerHolder(final Class<?> clazz) {
		this.perf4jDelegate = Perf4jDelegate.create(Logger.getLogger("perf4j=" + clazz.getName()));
		this.splunkLoggerDelegate = SplunkLoggerDelegate.create(Logger.getLogger("splunk=" + clazz.getName()));
		this.fileLoggerDelegate = FileLoggerDelegate.create(Logger.getLogger(clazz));
	}

	/**
	 * @return the perf4jDelegate
	 */
	Perf4jDelegate getPerf4jDelegate() {
		return perf4jDelegate;
	}

	/**
	 * @return the fileLoggerDelegate
	 */
	FileLoggerDelegate getFileLoggerDelegate() {
		return fileLoggerDelegate;
	}

	/**
	 * @return the splunkLoggerDelegate
	 */
	SplunkLoggerDelegate getSplunkLoggerDelegate() {
		return splunkLoggerDelegate;
	}

	@Override
	public void logInfo(final Object message) {
		fileLoggerDelegate.logInfo(message);
		splunkLoggerDelegate.logInfo(message);
	}

	@Override
	public void logWarn(final Object message) {
		fileLoggerDelegate.logWarn(message);
		splunkLoggerDelegate.logWarn(message);
	}

	@Override
	public void logError(final Object message) {
		fileLoggerDelegate.logError(message);
		splunkLoggerDelegate.logError(message);
	}

	@Override
	public void logDebug(final Object message) {
		fileLoggerDelegate.logDebug(message);
		splunkLoggerDelegate.logDebug(message);
	}

	@Override
	public LogDataHolder logData(final Map<String, Object> logData) {
		return new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
	}

	@Override
	public LogKey logKey(String key) {
		return new LogKeyValueBuilderHolder(key, fileLoggerDelegate, splunkLoggerDelegate);
	}
}
