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

/**
 * LogKeyValue Builder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LogKeyValueBuilder implements LogKey, RecursiveLogKey {

	private String key;
	private final KeyValue keyValue;

	private LogKeyValueBuilder(final Logger logger, final String key) {
		this.key = key;
		this.keyValue = new KeyValue(this, logger);
	}

	/**
	 *
	 * @param logger
	 * @param key
	 * @return
	 */
	protected static LogKeyValueBuilder create(final Logger logger, final String key) {
		return (key.contains("=")) ? new LogKeyValueBuilder(logger, key) : new LogKeyValueBuilder(logger, key + "=");
	}

	@Override
	public RecursiveLogKey value(final Object msg) {
		return keyValue.setValue(key, msg);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	@Override
	public LogKey logKey(String key) {
		return changeKey(key);
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public LogKey changeKey(String key) {
		this.key = (key.contains("=")) ? key : key + "=";
		return this;
	}

	@Override
	public AsLevel asInfo() {
		return keyValue.asInfo();
	}

	@Override
	public AsLevel asWarn() {
		return keyValue.asWarn();
	}

	@Override
	public AsLevel asError() {
		return keyValue.asError();
	}

	@Override
	public AsLevel asDebug() {
		return keyValue.asDebug();
	}
}
