/*
 * Copyright (C) 2020 pedrotoliveira
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Plain Text Stack Trace Formatter
 *
 * @author pedrotoliveira
 */
class TextStackTraceFormatter implements StackTracerFormatter {

    private static final String SEPARATOR = "\n";

    @Override
    public String formatToString(Throwable throwable) {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream(); PrintStream ps = new PrintStream(buffer)) {
            throwable.printStackTrace(ps);
            StringBuilder sb = new StringBuilder(buffer.toString()).append(SEPARATOR);
            for (Throwable cause = throwable.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(ps);
                sb.append(buffer.toString()).append(SEPARATOR);
            }
            return sb.toString();
        } catch (IOException ex) {
            return "Unable to get stack trace [ " + ex.getMessage() + " ]";
        }
    }
}
