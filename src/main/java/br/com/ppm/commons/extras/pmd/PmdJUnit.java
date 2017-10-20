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
 * PMD JUnit Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdJUnit {

    /**
     * JUnitStaticSuite: The suite() method in a JUnit test needs to be both public and static.
     */
    public static final String JUnitStaticSuite = "PMD.JUnitStaticSuite";

    /**
     * JUnitSpelling: Some JUnit framework methods are easy to misspell.
     */
    public static final String JUnitSpelling = "PMD.JUnitSpelling";

    /**
     * JUnitAssertionsShouldIncludeMessage: JUnit assertions should include an informative message - i.e., use the
     * three-argument version of assertEquals(), not the two-argument version.
     */
    public static final String JUnitAssertionsShouldIncludeMessage = "PMD.JUnitAssertionsShouldIncludeMessage";

    /**
     * JUnitTestsShouldIncludeAssert: JUnit tests should include at least one assertion. This makes the tests more
     * robust, and using assert with messages provide the developer a clearer idea of what the test does.
     */
    public static final String JUnitTestsShouldIncludeAssert = "PMD.JUnitTestsShouldIncludeAssert";

    /**
     * TestClassWithoutTestCases: Test classes end with the suffix Test. Having a non-test class with that name is not a
     * good practice, since most people will assume it is a test case. Test classes have test methods named testXXX.
     */
    public static final String TestClassWithoutTestCases = "PMD.TestClassWithoutTestCases";

    /**
     * UnnecessaryBooleanAssertion: A JUnit test assertion with a boolean literal is unnecessary since it always will
     * evaluate to the same thing.Consider using flow control (in case of assertTrue(false) or similar) or simply
     * removing statements like assertTrue(true) and assertFalse(false). If you just want a test to halt after finding
     * an error, use the fail() method and provide an indication message of why it did.
     */
    public static final String UnnecessaryBooleanAssertion = "PMD.UnnecessaryBooleanAssertion";

    /**
     * UseAssertEqualsInsteadOfAssertTrue: This rule detects JUnit assertions in object equality. These assertions
     * should be made by more specific methods, like assertEquals.
     */
    public static final String UseAssertEqualsInsteadOfAssertTrue = "PMD.UseAssertEqualsInsteadOfAssertTrue";

    /**
     * UseAssertSameInsteadOfAssertTrue: This rule detects JUnit assertions in object references equality. These
     * assertions should be made by more specific methods, like assertSame, assertNotSame.
     */
    public static final String UseAssertSameInsteadOfAssertTrue = "PMD.UseAssertSameInsteadOfAssertTrue";

    /**
     * UseAssertNullInsteadOfAssertTrue: This rule detects JUnit assertions in object references equality. These
     * assertions should be made by more specific methods, like assertNull, assertNotNull.
     */
    public static final String UseAssertNullInsteadOfAssertTrue = "PMD.UseAssertNullInsteadOfAssertTrue";

    /**
     * SimplifyBooleanAssertion: Avoid negation in an assertTrue or assertFalse test.For example, rephrase:
     * assertTrue(!expr); as: assertFalse(expr);
     */
    public static final String SimplifyBooleanAssertion = "PMD.SimplifyBooleanAssertion";

    /**
     * JUnitTestContainsTooManyAsserts: JUnit tests should not contain too many asserts. Many asserts are indicative of
     * a complex test, for which it is harder to verify correctness. Consider breaking the test scenario into multiple,
     * shorter test scenarios. Customize the maximum number of assertions used by this Rule to suit your needs.
     */
    public static final String JUnitTestContainsTooManyAsserts = "PMD.JUnitTestContainsTooManyAsserts";

    /**
     * UseAssertTrueInsteadOfAssertEquals: When asserting a value is the same as a literal or Boxed boolean, use
     * assertTrue/assertFalse, instead of assertEquals.
     */
    public static final String UseAssertTrueInsteadOfAssertEquals = "PMD.UseAssertTrueInsteadOfAssertEquals";

    private PmdJUnit() {
    }

}
