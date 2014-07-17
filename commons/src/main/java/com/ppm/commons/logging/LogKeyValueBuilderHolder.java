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
 * LogKeyValueBuilderHolder holds multiples builders.
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LogKeyValueBuilderHolder implements LogKey, RecursiveLogKey {

	private final LogKeyValueBuilder fileLogKeyValue;
	private final LogKeyValueBuilder splunkLogKeyvalue;

	/**
	 * Construct a new LogKeyValueBuilderHolder
	 * @param key
	 * @param fileLoggerDelegate
	 * @param splunkLoggerDelegate
	 */
	public LogKeyValueBuilderHolder(final String key, final FileLogger fileLoggerDelegate, final SplunkLogger splunkLoggerDelegate) {
		this.fileLogKeyValue = (LogKeyValueBuilder) fileLoggerDelegate.logKey(key);
		this.splunkLogKeyvalue = (LogKeyValueBuilder) splunkLoggerDelegate.logKey(key);
	}

	/* (non-Javadoc)
	 * @see com.ppm..util.logging.LogKey#value(java.lang.Object)
	 */
	@Override
	public RecursiveLogKey value(Object msg) {
		fileLogKeyValue.value(msg);
		splunkLogKeyvalue.value(msg);
		return this;
	}

	@Override
	public AsLevel asInfo() {
		fileLogKeyValue.asInfo();
		splunkLogKeyvalue.asInfo();
		return this;
	}

	@Override
	public AsLevel asWarn() {
		fileLogKeyValue.asWarn();
		splunkLogKeyvalue.asWarn();
		return this;
	}

	@Override
	public AsLevel asError() {
		fileLogKeyValue.asError();
		splunkLogKeyvalue.asError();
		return this;
	}

	@Override
	public AsLevel asDebug() {
		fileLogKeyValue.asDebug();
		splunkLogKeyvalue.asDebug();
		return this;
	}

	@Override
	public LogKey logKey(String key) {
		fileLogKeyValue.logKey(key);
		splunkLogKeyvalue.logKey(key);
		return this;
	}
}
