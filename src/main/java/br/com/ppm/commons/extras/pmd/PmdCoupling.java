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
 * PMD PmdCoupling Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdCoupling {

    /**
     * CouplingBetweenObjects: This rule counts the number of unique attributes, local variables, and return types
     * within an object. A number higher than the specified threshold can indicate a high degree of coupling.
     */
    public static final String CouplingBetweenObjects = "PMD.CouplingBetweenObjects";

    /**
     * ExcessiveImports: A high number of imports can indicate a high degree of coupling within an object. This rule
     * counts the number of unique imports and reports a violation if the count is above the user-specified threshold.
     */
    public static final String ExcessiveImports = "PMD.ExcessiveImports";

    /**
     * LooseCoupling: The use of implementation types as object references limits your ability to use alternate
     * implementations in the future as requirements change. Whenever available, referencing objects by their interface
     * types provides much more flexibility.
     */
    public static final String LooseCoupling = "PMD.LooseCoupling";

    /**
     * LoosePackageCoupling: Avoid using classes from the configured package hierarchy outside of the package hierarchy,
     * except when using one of the configured allowed classes.
     */
    public static final String LoosePackageCoupling = "PMD.LoosePackageCoupling";

    /**
     * LawOfDemeter: The Law of Demeter is a simple rule, that says “only talk to friends”. It helps to reduce coupling
     * between classes or objects. See also the references:Andrew Hunt, David Thomas, and Ward Cunningham. The Pragmatic
     * Programmer. From Journeyman to Master. Addison-Wesley Longman, Amsterdam, October 1999.;K.J. Lieberherr and I.M.
     * Holland. Assuring good style for object-oriented programs. Software, IEEE, 6(5):38???48, 1989.;
     * <a href="http://www.ccs.neu.edu/home/lieber/LoD.html;http://en.wikipedia.org/wiki/Law_of_Demeter">Law_of_Demeter</a>
     */
    public static final String LawOfDemeter = "PMD.LawOfDemeter";

    private PmdCoupling() {
    }
}
