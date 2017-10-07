/*
 * Copyright (C) 2017 ppm
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
package br.com.ppm.commons;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author pedrotoliveira
 */
public enum StackTraceFormatters implements StackTracerFormatter {

    HTML("<br />"),
    PLAIN_TEXT("\n");

    private final String separator;

    private StackTraceFormatters(String separator) {
        this.separator = separator;
    }

    @Override
    public String formatToString(final Throwable t) {
        try (final ByteArrayOutputStream buffer = new ByteArrayOutputStream();final PrintStream ps = new PrintStream(buffer)) {
            t.printStackTrace(ps);
            final StringBuilder sb = new StringBuilder(buffer.toString()).append(separator);
            for (Throwable cause = t.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(ps);
                sb.append(buffer.toString());
                if (cause.getCause() != null) {
                    sb.append(separator);
                }
            }
            return sb.toString();
        } catch (IOException ex) {
            return "Unable to get stack trace [ " + ex.getMessage() + " ]";
        }
    }

    StackTraceFormatters get() {
        return this;
    }

}
