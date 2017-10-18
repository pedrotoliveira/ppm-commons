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

/**
 * Utility Class to format Java Stack Traces.
 *
 * @author Pedro T. Oliveira
 */
public class StackTraces {

    /**
     * Can't be instantiate
     */
    private StackTraces() {
    }

    /**
     * Transforms the entire Stack Traces String of Exception by separating the stacks according to the format.
     *
     * @param throwable Exception to format
     * @param format Specified Format
     * @return <code> String </code> StackTrace String Formated.
     *
     */
    public static String toString(final Throwable throwable, StackTraceFormatters format) {
        return format.formatToString(throwable);
    }

    /**
     * Transforms the entire Stack Traces String of Exception by separating the stacks according to the default format.
     *
     * @param throwable Exception to format
     * @return <code> String </code> StackTrace String Formated.
     */
    public static String toString(final Throwable throwable) {
        return StackTraceFormatters.PLAIN_TEXT.formatToString(throwable);
    }
}
