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
 * PMD Migration Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdMigration {

    /**
     * ReplaceVectorWithList: Consider replacing Vector usages with the newer java.util.ArrayList if expensive
     * thread-safe operations are not required.
     */
    public static final String ReplaceVectorWithList = "PMD.ReplaceVectorWithList";

    /**
     * ReplaceHashtableWithMap: Consider replacing Hashtable usage with the newer java.util.Map if thread safety is not
     * required.
     */
    public static final String ReplaceHashtableWithMap = "PMD.ReplaceHashtableWithMap";

    /**
     * ReplaceEnumerationWithIterator: Consider replacing Enumeration usages with the newer java.util.Iterator
     */
    public static final String ReplaceEnumerationWithIterator = "PMD.ReplaceEnumerationWithIterator";

    /**
     * AvoidEnumAsIdentifier: Use of the term ‘enum’ will conflict with newer versions of Java since it is a reserved
     * word.
     */
    public static final String AvoidEnumAsIdentifier = "PMD.AvoidEnumAsIdentifier";

    /**
     * AvoidAssertAsIdentifier: Use of the term ‘assert’ will conflict with newer versions of Java since it is a
     * reserved word.
     */
    public static final String AvoidAssertAsIdentifier = "PMD.AvoidAssertAsIdentifier";

    /**
     * IntegerInstantiation: Calling new Integer() causes memory allocation that can be avoided by the static
     * Integer.valueOf().It makes use of an internal cache that recycles earlier instances making it more memory
     * efficient.
     */
    public static final String IntegerInstantiation = "PMD.IntegerInstantiation";

    /**
     * ByteInstantiation: Calling new Byte() causes memory allocation that can be avoided by the static
     * Byte.valueOf().It makes use of an internal cache that recycles earlier instances making it more memory efficient.
     */
    public static final String ByteInstantiation = "PMD.ByteInstantiation";

    /**
     * ShortInstantiation: Calling new Short() causes memory allocation that can be avoided by the static
     * Short.valueOf().It makes use of an internal cache that recycles earlier instances making it more memory
     * efficient.
     */
    public static final String ShortInstantiation = "PMD.ShortInstantiation";

    /**
     * LongInstantiation: Calling new Long() causes memory allocation that can be avoided by the static
     * Long.valueOf().It makes use of an internal cache that recycles earlier instances making it more memory efficient.
     */
    public static final String LongInstantiation = "PMD.LongInstantiation";

    /**
     * JUnit4TestShouldUseBeforeAnnotation: In JUnit 3, the setUp method was used to set up all data entities required
     * in running tests. JUnit 4 skips the setUp method and executes all methods annotated with @Before before all tests
     */
    public static final String JUnit4TestShouldUseBeforeAnnotation = "PMD.JUnit4TestShouldUseBeforeAnnotation";

    /**
     * JUnit4TestShouldUseAfterAnnotation: In JUnit 3, the tearDown method was used to clean up all data entities
     * required in running tests. JUnit 4 skips the tearDown method and executes all methods annotated with @After after
     * running each test
     */
    public static final String JUnit4TestShouldUseAfterAnnotation = "PMD.JUnit4TestShouldUseAfterAnnotation";

    /**
     * JUnit4TestShouldUseTestAnnotation: In JUnit 3, the framework executed all methods which started with the word
     * test as a unit test. In JUnit 4, only methods annotated with the @Test annotation are executed.
     */
    public static final String JUnit4TestShouldUseTestAnnotation = "PMD.JUnit4TestShouldUseTestAnnotation";

    /**
     * JUnit4SuitesShouldUseSuiteAnnotation: In JUnit 3, test suites are indicated by the suite() method. In JUnit 4,
     * suites are indicated through the @RunWith(Suite.class) annotation.
     */
    public static final String JUnit4SuitesShouldUseSuiteAnnotation = "PMD.JUnit4SuitesShouldUseSuiteAnnotation";

    /**
     * JUnitUseExpected: In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions.
     */
    public static final String JUnitUseExpected = "PMD.JUnitUseExpected";

    private PmdMigration() {
    }

}
