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
 * PMD Clone Implementation Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdCloneImplementation {

    /**
     * ProperCloneImplementation: Object clone() should be implemented with super.clone().
     */
    public static final String ProperCloneImplementation = "PMD.ProperCloneImplementation";

    /**
     * CloneThrowsCloneNotSupportedException: The method clone() should throw a CloneNotSupportedException.
     */
    public static final String CloneThrowsCloneNotSupportedException = "PMD.CloneThrowsCloneNotSupportedException";

    /**
     * CloneMethodMustImplementCloneable: The method clone() should only be implemented if the class implements the
     * Cloneable interface with the exception of a final method that only throws CloneNotSupportedException.
     */
    public static final String CloneMethodMustImplementCloneable = "PMD.CloneMethodMustImplementCloneable";

    /**
     * CloneMethodReturnTypeMustMatchClassName: If a class implements Cloneable the return type of the method clone()
     * must be the class name. That way, the caller of the clone method doesn’t need to cast the returned clone to the
     * correct type.Note: This is only possible with Java 1.5 or higher.
     */
    public static final String CloneMethodReturnTypeMustMatchClassName = "PMD.CloneMethodReturnTypeMustMatchClassName";

    /**
     * CloneMethodMustBePublic: The java Manual says “By convention, classes that implement this interface should
     * overrideObject.clone (which is protected) with a public method.”
     */
    public static final String CloneMethodMustBePublic = "PMD.CloneMethodMustBePublic";

    private PmdCloneImplementation() {
    }

}
