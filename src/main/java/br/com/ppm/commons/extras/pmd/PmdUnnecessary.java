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
 * PMD Unnecessary Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdUnnecessary {

    /**
     * UnnecessaryConversionTemporary: Avoid the use temporary objects when converting primitives to Strings. Use the
     * static conversion methods on the wrapper classes instead.
     */
    public static final String UnnecessaryConversionTemporary = "PMD.UnnecessaryConversionTemporary";

    /**
     * UnnecessaryReturn: Avoid the use of unnecessary return statements.
     */
    public static final String UnnecessaryReturn = "PMD.UnnecessaryReturn";

    /**
     * UnnecessaryFinalModifier: When a class has the final modifier, all the methods are automatically final and do not
     * need to be tagged as such.
     */
    public static final String UnnecessaryFinalModifier = "PMD.UnnecessaryFinalModifier";

    /**
     * UselessOverridingMethod: The overriding method merely calls the same method defined in a superclass.
     */
    public static final String UselessOverridingMethod = "PMD.UselessOverridingMethod";

    /**
     * UselessOperationOnImmutable: An operation on an Immutable object (String, BigDecimal or BigInteger) won’t change
     * the object it self since the result of the operation is a new object. Therefore, ignoring the operation result is
     * an error.
     */
    public static final String UselessOperationOnImmutable = "PMD.UselessOperationOnImmutable";

    /**
     * UnusedNullCheckInEquals: After checking an object reference for null, you should invoke equals() on that object
     * rather than passing it to another object’s equals() method.
     */
    public static final String UnusedNullCheckInEquals = "PMD.UnusedNullCheckInEquals";

    /**
     * UselessParentheses: Useless parentheses should be removed.
     */
    public static final String UselessParentheses = "PMD.UselessParentheses";

    /**
     * UselessQualifiedThis: Look for qualified this usages in the same class.
     */
    public static final String UselessQualifiedThis = "PMD.UselessQualifiedThis";

    private PmdUnnecessary() {
    }

}
