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
 * PMD PmdBasic Rules
 *
 * @author pedrotoliveira
 */
public final class PmdBasic {

    /**
     * JumbledIncrementer: Avoid jumbled loop incrementers - its usually a mistake, and is confusing even if
     * intentional.
     */
    public static final String JumbledIncrementer = "PMD.JumbledIncrementer";

    /**
     * ForLoopShouldBeWhileLoop: Some for loops can be simplified to while loops, this makes them more concise.
     */
    public static final String ForLoopShouldBeWhileLoop = "PMD.ForLoopShouldBeWhileLoop";

    /**
     * OverrideBothEqualsAndHashcode: Override both public boolean Object.equals(Object other), and public int
     * Object.hashCode(), or override neither. Even if you are inheriting a hashCode() from a parent class, consider
     * implementing hashCode and explicitly delegating to your superclass.
     */
    public static final String OverrideBothEqualsAndHashcode = "PMD.OverrideBothEqualsAndHashcode";

    /**
     * DoubleCheckedLocking: Partially created objects can be returned by the Double Checked Locking pattern when used
     * in Java.An optimizing JRE may assign a reference to the baz variable before it creates the object the reference
     * is intended to point to.For more details refer to:
     * <a href=http://www.javaworld.com/javaworld/jw-02-2001/jw-0209-double.htmlor>http://www.javaworld.com/javaworld/jw-02-2001/jw-0209-double.htmlor</a>
     * <a href=http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html>http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html</a>
     */
    public static final String DoubleCheckedLocking = "PMD.DoubleCheckedLocking";

    /**
     * ReturnFromFinallyBlock: Avoid returning from a finally block, this can discard exceptions.
     */
    public static final String ReturnFromFinallyBlock = "PMD.ReturnFromFinallyBlock";

    /**
     * UnconditionalIfStatement: Do not use “if” statements whose conditionals are always true or always false.
     */
    public static final String UnconditionalIfStatement = "PMD.UnconditionalIfStatement";

    /**
     * BooleanInstantiation: Avoid instantiating Boolean objects; you can reference Boolean.TRUE, Boolean.FALSE, or call
     * Boolean.valueOf() instead.
     */
    public static final String BooleanInstantiation = "PMD.BooleanInstantiation";

    /**
     * CollapsibleIfStatements: Sometimes two consecutive ‘if’ statements can be consolidated by separating their
     * conditions with a boolean short-circuit operator.
     */
    public static final String CollapsibleIfStatements = "PMD.CollapsibleIfStatements";

    /**
     * ClassCastExceptionWithToArray: When deriving an array of a specific class from your Collection, one should
     * provide an array of the same class as the parameter of the toArray() method. Doing otherwise you will will result
     * in a ClassCastException.
     */
    public static final String ClassCastExceptionWithToArray = "PMD.ClassCastExceptionWithToArray";

    /**
     * AvoidDecimalLiteralsInBigDecimalConstructor: One might assume that the result of “new BigDecimal(0.1)” is exactly
     * equal to 0.1, but it is actually equal to .1000000000000000055511151231257827021181583404541015625.This is
     * because 0.1 cannot be represented exactly as a double (or as a binary fraction of any finite length). Thus, the
     * long value * that is being passed in to the constructor is not exactly equal to 0.1,appearances
     * notwithstanding.The (String) constructor, on the other hand, is perfectly predictable: ‘new BigDecimal(“0.1”)’ is
     * exactly equal to 0.1, as one * would expect. Therefore, it is generally recommended that the(String) constructor
     * be used in preference to this one.
     */
    public static final String AvoidDecimalLiteralsInBigDecimalConstructor = "PMD.AvoidDecimalLiteralsInBigDecimalConstructor";

    /**
     * MisplacedNullCheck: The null check here is misplaced. If the variable is null a NullPointerException will be
     * thrown.Either the check is useless (the variable will never be “null”) or it is incorrect.
     */
    public static final String MisplacedNullCheck = "PMD.MisplacedNullCheck";

    /**
     * AvoidThreadGroup: Avoid using java.lang.ThreadGroup; although it is intended to be used in a threaded environment
     * it contains methods that are not thread-safe.
     */
    public static final String AvoidThreadGroup = "PMD.AvoidThreadGroup";

    /**
     * BrokenNullCheck: The null check is broken since it will throw a NullPointerException itself.It is likely that you
     * used || instead of && or vice versa.
     */
    public static final String BrokenNullCheck = "PMD.BrokenNullCheck";

    /**
     * BigIntegerInstantiation: Don’t create instances of already existing BigInteger (BigInteger.ZERO, BigInteger.ONE)
     * and for Java 1.5 onwards, BigInteger.TEN and BigDecimal (BigDecimal.ZERO,BigDecimal.ONE, BigDecimal.TEN)
     */
    public static final String BigIntegerInstantiation = "PMD.BigIntegerInstantiation";

    /**
     * AvoidUsingOctalValues: Integer literals should not start with zero since this denotes that the rest of literal
     * will be interpreted as an octal value.
     */
    public static final String AvoidUsingOctalValues = "PMD.AvoidUsingOctalValues";

    /**
     * AvoidUsingHardCodedIP: Application with hard-coded IP addresses can become impossible to deploy in some
     * cases.Externalizing IP adresses is preferable.
     */
    public static final String AvoidUsingHardCodedIP = "PMD.AvoidUsingHardCodedIP";

    /**
     * CheckResultSet: Always check the return values of navigation methods (next, previous, first, last) of a *
     * ResultSet.If the value return is ‘false’, it should be handled properly.
     */
    public static final String CheckResultSet = "PMD.CheckResultSet";
    /**
     * * AvoidMultipleUnaryOperators: The use of multiple unary operators may be problematic, and/or confusing.Ensure
     * that the intended usage is not a bug, or consider simplifying the expression.
     */
    public static final String AvoidMultipleUnaryOperators = "PMD.AvoidMultipleUnaryOperators";
    /**
     * * ExtendsObject: No need to explicitly extend Object.
     */
    public static final String ExtendsObject = "PMD.ExtendsObject";
    /**
     * * CheckSkipResult: The skip() method may skip a smaller number of bytes than requested. Check the returned value
     * to find out if it was the case or not.
     */
    public static final String CheckSkipResult = "PMD.CheckSkipResult";
    /**
     * * AvoidBranchingStatementAsLastInLoop: Using a branching statement as the last part of a loop may be a bug,
     * and/or is confusing.Ensure that the usage is not a bug, or consider using another approach.
     */
    public static final String AvoidBranchingStatementAsLastInLoop = "PMD.AvoidBranchingStatementAsLastInLoop";
    /**
     * * DontCallThreadRun: Explicitly calling Thread.run() method will execute in the caller’s thread of control.
     * Instead, call Thread.start() for the intended behavior.
     */
    public static final String DontCallThreadRun = "PMD.DontCallThreadRun";
    /**
     * * DontUseFloatTypeForLoopIndices: Don’t use floating point for loop indices. If you must use floating point, use
     * double unless you’re certain that float provides enough precision and you have a compelling performance need
     * (space or time).
     */
    public static final String DontUseFloatTypeForLoopIndices = "PMD.DontUseFloatTypeForLoopIndices";
    /**
     * SimplifiedTernary: Look for ternary operators with the form condition ? literalBoolean : foo or condition ? foo :
     * literalBoolean.These expressions can be simplified respectively to condition || foo when the literalBoolean is
     * true!condition && foo when the literalBoolean is false or!condition || foo when the literalBoolean is true
     * condition && foo when the literalBoolean is false
     */
    public static final String SimplifiedTernary = "PMD.SimplifiedTernary";

    private PmdBasic() {
    }
}
