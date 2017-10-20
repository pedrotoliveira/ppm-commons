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
package br.com.ppm.commons.extras.pmd;

/**
 * PMD Jakarta Commons Logging Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdJakartaCommonsLogging {

    /**
     * UseCorrectExceptionLogging: To make sure the full stacktrace is printed out, use the logging statement with two
     * arguments: a String and a Throwable.
     */
    public static final String UseCorrectExceptionLogging = "PMD.UseCorrectExceptionLogging";

    /**
     * ProperLogger: A logger should normally be defined private static final and be associated with the correct
     * class.Private final Log log; is also allowed for rare cases where loggers need to be passed around,with the
     * restriction that the logger needs to be passed into the constructor.
     */
    public static final String ProperLogger = "PMD.ProperLogger";

    /**
     * GuardDebugLogging: When log messages are composed by concatenating strings, the whole section should be guarded
     * by a isDebugEnabled() check to avoid performance and memory issues.
     */
    public static final String GuardDebugLogging = "PMD.GuardDebugLogging";

    /**
     * GuardLogStatement: Whenever using a log level, one should check if the log level is actually enabled, or
     * otherwise skip the associate String creation and manipulation.
     */
    public static final String GuardLogStatement = "PMD.GuardLogStatement";

    private PmdJakartaCommonsLogging() {
    }

}
