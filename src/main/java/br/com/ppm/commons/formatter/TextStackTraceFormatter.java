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

import br.com.ppm.commons.validation.ArgumentValidator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

/**
 * Plain Text Stack Trace Formatter
 *
 * @author pedrotoliveira
 */
class TextStackTraceFormatter implements StackTracerFormatter {

    private static final String SEPARATOR = "\n";

    @Override
    public String formatToString(Throwable throwable) {
        ArgumentValidator.notNullParameter(throwable, "Throwable should not be null");
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream(); PrintStream ps = new PrintStream(buffer)) {
            throwable.printStackTrace(ps);
            StringBuilder sb = new StringBuilder(buffer.toString(Charset.defaultCharset())).append(SEPARATOR);
            var cause = throwable.getCause();
            while (cause != null) {
                cause.printStackTrace(ps);
                sb.append(buffer).append(SEPARATOR);
                cause = cause.getCause();
            }
            return sb.toString();
        } catch (IOException ex) {
            return "Unable to get stack trace [ " + ex.getMessage() + " ]";
        }
    }
}
