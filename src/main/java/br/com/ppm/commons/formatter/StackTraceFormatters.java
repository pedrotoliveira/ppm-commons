/*
 * Copyright (C) 2017 pedrotoliveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.formatter;

/**
 * <p>StackTraceFormatters class.</p>
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public enum StackTraceFormatters implements StackTracerFormatter {

    HTML(new HtmlStackTraceFormatter()),
    PLAIN_TEXT(new TextStackTraceFormatter()),
    JSON(new JsonStackTraceFormatter());

    private final StackTracerFormatter formatter;

    StackTraceFormatters(StackTracerFormatter formatter) {
        this.formatter = formatter;
    }

    /** {@inheritDoc} */
    @Override
    public String formatToString(final Throwable t) {
        return this.formatter.formatToString(t);
    }
}
