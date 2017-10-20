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
 * PMD PmdControversial Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdControversial {

    /**
     * UnnecessaryConstructor: This rule detects when a constructor is not necessary; i.e., when there is only one
     * constructor,its public, has an empty body, and takes no arguments.
     */
    public static final String UnnecessaryConstructor = "PMD.UnnecessaryConstructor";

    /**
     * NullAssignment: Assigning a “null” to a variable (outside of its declaration) is usually bad form. Sometimes,
     * this typeof assignment is an indication that the programmer doesn’t completely understand what is going on in the
     * code.NOTE: This sort of assignment may used in some cases to dereference objects and encourage garbage collection.
     */
    public static final String NullAssignment = "PMD.NullAssignment";

    /**
     * OnlyOneReturn: A method should have only one exit point, and that should be the last statement in the method.
     */
    public static final String OnlyOneReturn = "PMD.OnlyOneReturn";

    /**
     * AssignmentInOperand: Avoid assignments in operands; this can make code more complicated and harder to read.
     */
    public static final String AssignmentInOperand = "PMD.AssignmentInOperand";

    /**
     * AtLeastOneConstructor: Each class should declare at least one constructor.
     */
    public static final String AtLeastOneConstructor = "PMD.AtLeastOneConstructor";

    /**
     * DontImportSun: Avoid importing anything from the ‘sun.*’ packages. These packages are not portable and are likely
     * to change.
     */
    public static final String DontImportSun = "PMD.DontImportSun";

    /**
     * SuspiciousOctalEscape: A suspicious octal escape sequence was found inside a String literal.The Java language
     * specification (section 3.10.6) says an octalescape sequence inside a literal String shall consist of a
     * backslashfollowed by: OctalDigit | OctalDigit OctalDigit | ZeroToThree OctalDigit OctalDigitAny octal escape
     * sequence followed by non-octal digits can be confusing,e.g. “\038” is interpreted as the octal escape sequence
     * “\03” followed bythe literal character “8”.
     */
    public static final String SuspiciousOctalEscape = "PMD.SuspiciousOctalEscape";

    /**
     * CallSuperInConstructor: It is a good practice to call super() in a constructor. If super() is not called
     * butanother constructor (such as an overloaded constructor) is called, this rule will not report it.
     */
    public static final String CallSuperInConstructor = "PMD.CallSuperInConstructor";

    /**
     * UnnecessaryParentheses: Sometimes expressions are wrapped in unnecessary parentheses, making them look like
     * function calls.
     */
    public static final String UnnecessaryParentheses = "PMD.UnnecessaryParentheses";

    /**
     * DefaultPackage: Use explicit scoping instead of accidental usage of default package private level.The rule allows
     * methods and fields annotated with Guava’s @VisibleForTesting.
     */
    public static final String DefaultPackage = "PMD.DefaultPackage";

    /**
     * DataflowAnomalyAnalysis: The dataflow analysis tracks local definitions, undefinitions and references to
     * variables on different paths on the data flow.From those informations there can be found various problems.1. UR -
     * Anomaly: There is a reference to a variable that was not defined before. This is a bug and leads to an error.2.
     * DU - Anomaly: A recently defined variable is undefined. These anomalies may appear in normal source text.3. DD -
     * Anomaly: A recently defined variable is redefined. This is ominous but don’t have to be a bug.
     */
    public static final String DataflowAnomalyAnalysis = "PMD.DataflowAnomalyAnalysis";

    /**
     * AvoidFinalLocalVariable: Avoid using final local variables, turn them into fields.
     */
    public static final String AvoidFinalLocalVariable = "PMD.AvoidFinalLocalVariable";

    /**
     * /** AvoidUsingShortType: Java uses the ‘short’ type to reduce memory usage, not to optimize calculation. In fact,
     * the JVM does not have any arithmetic capabilities for the short type: the JVM must convert the short into
     * an int, do the proper calculation and convert the int back to a short. Thus any storage gains found through use
     * of the ‘short’ type may be offset by adverse impacts on performance.
     */
    public static final String AvoidUsingShortType = "PMD.AvoidUsingShortType";

    /**
     * AvoidUsingVolatile: Use of the keyword ‘volatile’ is generally used to fine tune a Java application, and
     * therefore, requires a good expertise of the Java Memory Model. Moreover, its range of action is somewhat known.
     * Therefore,the volatile keyword should not be used for maintenance purpose and portability.
     */
    public static final String AvoidUsingVolatile = "PMD.AvoidUsingVolatile";

    /**
     * AvoidUsingNativeCode: Unnecessary reliance on Java Native Interface (JNI) calls directly reduces application
     * portability and increases the maintenance burden.
     */
    public static final String AvoidUsingNativeCode = "PMD.AvoidUsingNativeCode";

    /**
     * AvoidAccessibilityAlteration: Methods such as getDeclaredConstructors(), getDeclaredConstructor(Class[]) and
     * setAccessible(),as the interface PrivilegedAction, allows for the runtime alteration of variable, class, ormethod
     * visibility, even if they are private. This violates the principle of encapsulation.
     */
    public static final String AvoidAccessibilityAlteration = "PMD.AvoidAccessibilityAlteration";

    /**
     * DoNotCallGarbageCollectionExplicitly: Calls to System.gc(), Runtime.getRuntime().gc(), and
     * System.runFinalization() are not advised. Code should have the same behavior whether the garbage collection is
     * disabled using the option -Xdisableexplicitgc or not.Moreover, “modern” jvms do a very good job handling garbage
     * collections. If memory usage issues unrelated to memoryleaks develop within an application, it should be dealt
     * with JVM options rather than within the code itself.
     */
    public static final String DoNotCallGarbageCollectionExplicitly = "PMD.DoNotCallGarbageCollectionExplicitly";

    /**
     * OneDeclarationPerLine: Java allows the use of several variables declaration of the same type on one line.
     * However, it can lead to quite messy code. This rule looks for several declarations on the same line.
     */
    public static final String OneDeclarationPerLine = "PMD.OneDeclarationPerLine";

    /**
     * AvoidPrefixingMethodParameters: Prefixing parameters by ‘in’ or ‘out’ pollutes the name of the parameters and
     * reduces code readability.To indicate whether or not a parameter will be modify in a method, its better to
     * document method behavior with Javadoc.
     */
    public static final String AvoidPrefixingMethodParameters = "PMD.AvoidPrefixingMethodParameters";

    /**
     * AvoidLiteralsInIfCondition: Avoid using hard-coded literals in conditional statements. By declaring them as
     * static variables or private members with descriptive names maintainability is enhanced. By default, the literals
     * “-1” and “0” are ignored.More exceptions can be defined with the property “ignoreMagicNumbers”.
     */
    public static final String AvoidLiteralsInIfCondition = "PMD.AvoidLiteralsInIfCondition";

    /**
     * UseObjectForClearerAPI: When you write a public method, you should be thinking in terms of an API. If your method
     * is public, it means other class will use it, therefore, you want (or need) to offer a comprehensive and evolutive
     * API. If you pass a lot of information as a simple series of Strings, you may think of using an Object to
     * represent all those information. You’ll get a simplierAPI (such as doWork(Workload workload), rather than a
     * tedious series of Strings) and more importantly, if you need at some point to pass extra data, you’ll be able to
     * do so by simply modifying or extending Workload without any modification to your API.
     */
    public static final String UseObjectForClearerAPI = "PMD.UseObjectForClearerAPI";

    /**
     * UseConcurrentHashMap: Since Java5 brought a new implementation of the Map designed for multi-threaded access, you
     * can perform efficient map reads without blocking other threads.
     */
    public static final String UseConcurrentHashMap = "PMD.UseConcurrentHashMap";

    private PmdControversial() {
    }
}
