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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Pedro T. Oliveira <pedro.oliveira.nom.br>
 */
public class StackTraceFormatter {

	/**
	 * Padrões de formatação das StackTraces em String.
	 */
	public enum Format {

		/**
		 * HTML
		 */
		HTML("<br />"),
		/**
		 * PLAIN_TEXT
		 */
		PLAIN_TEXT("\n");
		private final String separator;

		private Format(String separator) {
			this.separator = separator;
		}

		private String formatToString(final Throwable t) {

			final StringBuilder sb = new StringBuilder();

			try (final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					final PrintStream ps = new PrintStream(buffer);) {

				t.printStackTrace(ps);
				sb.append(buffer.toString())
						.append(separator);

				for (Throwable cause = t.getCause(); cause != null; cause = cause.getCause()) {
					cause.printStackTrace(ps);
					sb.append(buffer.toString());
					if (cause.getCause() != null) {
						sb.append(separator);
					}
				}
			} catch (IOException ex) {
				sb.append("Não foi possível obter a stack trace [ ")
						.append(ex.getMessage())
						.append(" ]");
			}
			return sb.toString();
		}

		private Format get() {
			return this;
		}
	}

	/**
	 * Cant be instantiate
	 */
	private StackTraceFormatter() {
	}

	/**
	 * Transforma toda a cadeia de StackTraces da Exceção em String separando as
	 * stacks de acordo com o formato passado.
	 *
	 * @param t      Throwable
	 * @param format pode ser qualquer um dos formatos da classe {@link StackTraceFormatter.Format}
	 *
	 * @return
	 *         <code> String </code> StackTrace Formata em String.
	 *
	 */
	public static String formatToString(final Throwable t, Format format) {
		return format.get().formatToString(t);
	}

	/**
	 * Transforma toda a cadeia de StackTraces da Exceção em String separando
	 * as stacks no formato default.
	 *
	 * @param t Throwable
	 *
	 * @return <code> String </code> StackTrace Formata em String.
	 *
	 */
	public static String formatToString(final Throwable t) {
		return Format.PLAIN_TEXT.formatToString(t);
	}
}
