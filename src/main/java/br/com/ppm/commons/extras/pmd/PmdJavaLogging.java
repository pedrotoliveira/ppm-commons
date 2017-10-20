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
 * PMD Java Logging Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdJavaLogging {

    /**
     * MoreThanOneLogger: Normally only one logger is used in each class.
     */
    public static final String MoreThanOneLogger = "PMD.MoreThanOneLogger";

    /**
     * LoggerIsNotStaticFinal: In most cases, the Logger reference can be declared as static and final.
     */
    public static final String LoggerIsNotStaticFinal = "PMD.LoggerIsNotStaticFinal";

    /**
     * SystemPrintln: References to System.(out|err).print are usually intended for debugging purposes and can remain
     * in
     * the code base even in production code. By using a logger one can enable/disable this behavior at will (and by
     * priority) and avoid clogging the Standard out log.
     */
    public static final String SystemPrintln = "PMD.SystemPrintln";

    /**
     * AvoidPrintStackTrace: Avoid printStackTrace(); use a logger call instead.
     */
    public static final String AvoidPrintStackTrace = "PMD.AvoidPrintStackTrace";

    /**
     * GuardLogStatementJavaUtil: Whenever using a log level, one should check if the log level is actually enabled, or
     * otherwise skip the associate String creation and manipulation.
     */
    public static final String GuardLogStatementJavaUtil = "PMD.GuardLogStatementJavaUtil";

    private PmdJavaLogging() {
    }

}
