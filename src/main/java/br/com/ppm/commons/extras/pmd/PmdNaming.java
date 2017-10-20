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
 * PMD Naming Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdNaming {

    /**
     * ShortVariable: Fields, local variables, or parameter names that are very short are not helpful to the reader.
     */
    public static final String ShortVariable = "PMD.ShortVariable";

    /**
     * LongVariable: Fields, formal arguments, or local variable names that are too long can make the code difficult to
     * follow.
     */
    public static final String LongVariable = "PMD.LongVariable";

    /**
     * ShortMethodName: Method names that are very short are not helpful to the reader.
     */
    public static final String ShortMethodName = "PMD.ShortMethodName";

    /**
     * VariableNamingConventions: A variable naming conventions rule - customize this to your liking. Currently, it
     * checks for final variables that should be fully capitalized and non-final variables that should not include
     * underscores.
     */
    public static final String VariableNamingConventions = "PMD.VariableNamingConventions";

    /**
     * MethodNamingConventions: Method names should always begin with a lower case character, and should not contain
     * underscores.
     */
    public static final String MethodNamingConventions = "PMD.MethodNamingConventions";

    /**
     * ClassNamingConventions: Class names should always begin with an upper case character.
     */
    public static final String ClassNamingConventions = "PMD.ClassNamingConventions";

    /**
     * AbstractNaming: Abstract classes should be named ‘AbstractXXX’.
     */
    public static final String AbstractNaming = "PMD.AbstractNaming";

    /**
     * AvoidDollarSigns: Avoid using dollar signs in variable/method/class/interface names.
     */
    public static final String AvoidDollarSigns = "PMD.AvoidDollarSigns";

    /**
     * MethodWithSameNameAsEnclosingClass: Non-constructor methods should not have the same name as the enclosing class.
     */
    public static final String MethodWithSameNameAsEnclosingClass = "PMD.MethodWithSameNameAsEnclosingClass";

    /**
     * SuspiciousHashcodeMethodName: The method name and return type are suspiciously close to hashCode(), which may
     * denote an intention to override the hashCode() method.
     */
    public static final String SuspiciousHashcodeMethodName = "PMD.SuspiciousHashcodeMethodName";

    /**
     * SuspiciousConstantFieldName: Field names using all uppercase characters - Sun’s Java naming conventions
     * indicating constants - should be declared as final.
     */
    public static final String SuspiciousConstantFieldName = "PMD.SuspiciousConstantFieldName";

    /**
     * SuspiciousEqualsMethodName: The method name and parameter number are suspiciously close to equals(Object), which
     * can denote an intention to override the equals(Object) method.
     */
    public static final String SuspiciousEqualsMethodName = "PMD.SuspiciousEqualsMethodName";

    /**
     * AvoidFieldNameMatchingTypeName: It is somewhat confusing to have a field name matching the declaring class
     * name.This probably means that type and/or field names should be chosen more carefully.
     */
    public static final String AvoidFieldNameMatchingTypeName = "PMD.AvoidFieldNameMatchingTypeName";

    /**
     * AvoidFieldNameMatchingMethodName: It can be confusing to have a field name with the same name as a method. While
     * this is permitted, having information (field) and actions (method) is not clear naming. Developers versed in
     * Smalltalk often prefer this approach as the methods denote accessor methods.
     */
    public static final String AvoidFieldNameMatchingMethodName = "PMD.AvoidFieldNameMatchingMethodName";

    /**
     * NoPackage: Detects when a class or interface does not have a package definition.
     */
    public static final String NoPackage = "PMD.NoPackage";

    /**
     * PackageCase: Detects when a package definition contains uppercase characters.
     */
    public static final String PackageCase = "PMD.PackageCase";

    /**
     * MisleadingVariableName: Detects when a non-field has a name starting with ‘m_’. This usually denotes a field and
     * could be confusing.
     */
    public static final String MisleadingVariableName = "PMD.MisleadingVariableName";

    /**
     * BooleanGetMethodName: Methods that return boolean results should be named as predicate statements to denote
     * this.I.e, ‘isReady()’, ‘hasValues()’, ‘canCommit()’, ‘willFail()’, etc. Avoid the use of the ’get’prefix for
     * these methods.
     */
    public static final String BooleanGetMethodName = "PMD.BooleanGetMethodName";

    /**
     * ShortClassName: Short Class names with fewer than e.g. five characters are not recommended.
     */
    public static final String ShortClassName = "PMD.ShortClassName";

    /**
     * GenericsNaming: Names for references to generic values should be limited to a single uppercase letter.
     */
    public static final String GenericsNaming = "PMD.GenericsNaming";

    private PmdNaming() {
    }
}
