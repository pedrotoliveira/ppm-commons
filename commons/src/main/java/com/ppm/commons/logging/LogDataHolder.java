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
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LogDataHolder implements LogData {

	private final Map<String, Object> logData;
	private final FileLogger fileLoggerDelegate;
	private final SplunkLogger splunkLoggerDelegate;

	/**
	 *
	 * @param logData
	 * @param fileLoggerDelegate
	 * @param splunkLoggerDelegate
	 */
	public LogDataHolder(final Map<String, Object> logData, FileLogger fileLoggerDelegate, SplunkLogger splunkLoggerDelegate) {
		super();
		this.logData = logData;
		this.fileLoggerDelegate = fileLoggerDelegate;
		this.splunkLoggerDelegate = splunkLoggerDelegate;
	}

	@Override
	public AsLevel asInfo() {
		return new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate).asInfo();
	}

	@Override
	public AsLevel asWarn() {
		return new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate).asWarn();
	}

	@Override
	public AsLevel asError() {
		return new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate).asError();
	}

	@Override
	public AsLevel asDebug() {
		return new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate).asDebug();
	}

	@Override
	public String getData() {
		return fileLoggerDelegate.logData(logData).getData();
	}
}
