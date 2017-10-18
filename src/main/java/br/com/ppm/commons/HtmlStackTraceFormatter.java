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
package br.com.ppm.commons;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Html Stack Trace Formatter
 *
 * @author pedrotoliveira
 */
class HtmlStackTraceFormatter implements StackTracerFormatter {

    private static final String OPEN_DIV = "<div id=\"stacktrace\">";
    private static final String CLOSE_DIV = "</div>";
    private static final String NEW_LINE = "<br />\n";

    @Override
    public String formatToString(Throwable throwable) {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream(); PrintStream ps = new PrintStream(buffer)) {
            return formatToHtml(throwable, ps, buffer);
        } catch (IOException ex) {
            return "Unable to get stack trace [ " + ex.getMessage() + " ]";
        }
    }

    private String formatToHtml(final Throwable throwable, final PrintStream ps, final ByteArrayOutputStream buffer) {
        throwable.printStackTrace(ps);
        StringBuilder sb = new StringBuilder(OPEN_DIV).append(buffer.toString().replaceAll("\n", NEW_LINE));
        for (Throwable cause = throwable.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(ps);
            sb.append(buffer.toString().replaceAll("\n", NEW_LINE));
        }
        return sb.append(CLOSE_DIV).toString();
    }
}
