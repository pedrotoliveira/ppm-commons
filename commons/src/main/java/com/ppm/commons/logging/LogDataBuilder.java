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
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * The Log Data Builder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LogDataBuilder implements LogData {

	private final Logger logger;
	private final String data;
	private final Throwable t;

	/**
	 *
	 * @param logger
	 * @param logData
	 */
	public LogDataBuilder(final Logger logger, final Map<String, Object> logData) {
		this(logger, logData, null);
	}

	/**
	 *
	 * @param logger
	 * @param logData
	 * @param t
	 */
	public LogDataBuilder(final Logger logger, final Map<String, Object> logData, final Throwable t) {
		this.logger = logger;
		this.data = transformLogData(logData);
		this.t = t;
	}

	@Override
	public AsLevel asInfo() {
		if (t == null) {
			logger.info(data);
		} else {
			logger.info(data, t);
		}
		return this;
	}

	@Override
	public AsLevel asWarn() {
		if (t == null) {
			logger.warn(data);
		} else {
			logger.warn(data, t);
		}
		return this;
	}

	@Override
	public AsLevel asError() {
		if (t == null) {
			logger.error(data);
		} else {
			logger.error(data, t);
		}
		return this;
	}

	@Override
	public AsLevel asDebug() {
		if (t == null) {
			logger.debug(data);
		} else {
			logger.debug(data, t);
		}
		return this;
	}

	@Override
	public String getData() {
		return data;
	}

	private String transformLogData(final Map<String, Object> logData) {
		StringBuilder sb = new StringBuilder(100);
		for (String key : logData.keySet()) {
			sb.append(key);
			final String value = String.valueOf(logData.get(key));
			if (stringHasSpaces(value)) {
				sb.append("=\"").append(value).append("\" ");
			} else {
				sb.append("=").append(value).append(" ");
			}
		}
		return sb.toString();
	}

	private boolean stringHasSpaces(final String s) {
		return Pattern.compile("\\s").matcher(s).find();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((logger == null) ? 0 : logger.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LogDataBuilder)) {
			return false;
		}
		LogDataBuilder other = (LogDataBuilder) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (logger == null) {
			if (other.logger != null) {
				return false;
			}
		} else if (!logger.equals(other.logger)) {
			return false;
		}
		if (t == null) {
			if (other.t != null) {
				return false;
			}
		} else if (!t.equals(other.t)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("LogDataBuilder [logger=%s, data=%s, t=%s]", logger, data, t);
	}
}
