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
 * PMD Strict Exceptions Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdStrictExceptions {

    /**
     * AvoidCatchingThrowable: Catching Throwable errors is not recommended since its scope is very broad. It includes
     * runtime issues such as OutOfMemoryError that should be exposed and managed separately.
     */
    public static final String AvoidCatchingThrowable = "PMD.AvoidCatchingThrowable";

    /**
     * SignatureDeclareThrowsException: Methods that declare the generic Exception as a possible throwable are not very
     * helpful since their failure modes are unclear. Use a class derived from RuntimeException or a more specific
     * checked exception.
     */
    public static final String SignatureDeclareThrowsException = "PMD.SignatureDeclareThrowsException";

    /**
     * ExceptionAsFlowControl: Using Exceptions as form of flow control is not recommended as they obscure true
     * exceptions when debugging.Either add the necessary validation or use an alternate control structure.
     */
    public static final String ExceptionAsFlowControl = "PMD.ExceptionAsFlowControl";

    /**
     * AvoidCatchingNPE: Code should never throw NullPointerExceptions under normal circumstances. A catch block may
     * hide the original error, causing other, more subtle problems later on.
     */
    public static final String AvoidCatchingNPE = "PMD.AvoidCatchingNPE";

    /**
     * AvoidThrowingRawExceptionTypes: Avoid throwing certain exception types. Rather than throw a raw RuntimeException,
     * Throwable, Exception, or Error, use a sub classed exception or error instead.
     */
    public static final String AvoidThrowingRawExceptionTypes = "PMD.AvoidThrowingRawExceptionTypes";

    /**
     * AvoidThrowingNullPointerException: Avoid throwing NullPointerExceptions. These are confusing because most people
     * will assume that the virtual machine threw it. Consider using an IllegalArgumentException instead; this will be
     * clearly seen as a programmer-initiated exception.
     */
    public static final String AvoidThrowingNullPointerException = "PMD.AvoidThrowingNullPointerException";

    /**
     * AvoidRethrowingException: Catch blocks that merely rethrow a caught exception only add to code size and runtime
     * complexity.
     */
    public static final String AvoidRethrowingException = "PMD.AvoidRethrowingException";

    /**
     * DoNotExtendJavaLangError: Errors are system exceptions. Do not extend them.
     */
    public static final String DoNotExtendJavaLangError = "PMD.DoNotExtendJavaLangError";

    /**
     * DoNotThrowExceptionInFinally: Throwing exceptions within a ‘finally’ block is confusing since they may mask other
     * exceptions or code defects.Note: This is a PMD implementation of the Lint4j rule “A throw in a finally block”
     */
    public static final String DoNotThrowExceptionInFinally = "PMD.DoNotThrowExceptionInFinally";

    /**
     * AvoidThrowingNewInstanceOfSameException: Catch blocks that merely rethrow a caught exception wrapped inside a new
     * instance of the same type only add tocode size and runtime complexity.
     */
    public static final String AvoidThrowingNewInstanceOfSameException = "PMD.AvoidThrowingNewInstanceOfSameException";

    /**
     * AvoidCatchingGenericException: Avoid catching generic exceptions such as NullPointerException, RuntimeException,
     * Exception in try-catch block
     */
    public static final String AvoidCatchingGenericException = "PMD.AvoidCatchingGenericException";

    /**
     * AvoidLosingExceptionInformation: Statements in a catch block that invoke accessors on the exception without using
     * the information only add to code size. Either remove the invocation, or use the return result.
     */
    public static final String AvoidLosingExceptionInformation = "PMD.AvoidLosingExceptionInformation";

    private PmdStrictExceptions() {
    }
}
