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
 * PMD Code Size Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdCodeSize {

    /**
     * NPathComplexity: The NPath complexity of a method is the number of acyclic execution paths through that method.A
     * threshold of 200 is generally considered the point where measures should be taken to reduce complexity and
     * increase readability.
     */
    public static final String NPathComplexity = "PMD.NPathComplexity";

    /**
     * ExcessiveMethodLength: When methods are excessively long this usually indicates that the method is doing more
     * than its name/signature might suggest. They also become challenging for others to digest since excessive
     * scrolling * causes readers to lose focus.Try to reduce the method length by creating helper methods and removing
     * any copy/pasted code.
     */
    public static final String ExcessiveMethodLength = "PMD.ExcessiveMethodLength";

    /**
     * ExcessiveParameterList: Methods with numerous parameters are a challenge to maintain, especially if most of them
     * share the same datatype. These situations usually denote the need for new objects to wrap the numerous
     * parameters.
     */
    public static final String ExcessiveParameterList = "PMD.ExcessiveParameterList";

    /**
     * ExcessiveClassLength: Excessive class file lengths are usually indications that the class may be burdened with
     * excessive responsibilities that could be provided by external classes or functions. In breaking these methods
     * apart the code becomes more managable and ripe for reuse.
     */
    public static final String ExcessiveClassLength = "PMD.ExcessiveClassLength";

    /**
     * CyclomaticComplexity: Complexity directly affects maintenance costs is determined by the number of decision
     * points in a method plus one for the method entry. The decision points include ‘if’, ‘while’, ‘for’, and ‘case
     * labels’ calls. Generally, numbers ranging from 1-4 denote low complexity, 5-7 denote moderate complexity, 8-10
     * denote high complexity, and 11+ is very high complexity.
     */
    public static final String CyclomaticComplexity = "PMD.CyclomaticComplexity";

    /**
     * StdCyclomaticComplexity: Complexity directly affects maintenance costs is determined by the number of decision
     * points in a method plus one for the method entry. The decision points include ‘if’, ‘while’, ‘for’, and ‘case
     * labels’ calls. Generally, numbers ranging from 1-4 denote low complexity, 5-7 denote moderate complexity, 8-10
     * denote high complexity, and 11+ is very high complexity.
     */
    public static final String StdCyclomaticComplexity = "PMD.StdCyclomaticComplexity";

    /**
     * ModifiedCyclomaticComplexity: Complexity directly affects maintenance costs is determined by the number of
     * decision points in a method plus one for the method entry. The decision points include ‘if’, ‘while’, ‘for’, and
     * ‘case labels’ calls. Generally, numbers ranging from 1-4 denote low complexity, 5-7 denote moderate complexity,
     * 8-10 denote high complexity, and 11+ is very high complexity. Modified complexity treats switch statements as a
     * single decision point.
     */
    public static final String ModifiedCyclomaticComplexity = "PMD.ModifiedCyclomaticComplexity";

    /**
     * ExcessivePublicCount: Classes with large numbers of public methods and attributes require disproportionate
     * testing efforts since combinational side effects grow rapidly and increase risk. Refactoring these classes into
     * smaller ones not only increases testability and reliability but also allows new variations to be developed
     * easily.
     */
    public static final String ExcessivePublicCount = "PMD.ExcessivePublicCount";

    /**
     * TooManyFields: Classes that have too many fields can become unwieldy and could be redesigned to have fewer
     * fields,possibly through grouping related fields in new objects. For example, a class with individual
     * city/state/zip fields could park them within a single Address field.
     */
    public static final String TooManyFields = "PMD.TooManyFields";

    /**
     * NcssMethodCount: This rule uses the NCSS (Non-Commenting Source Statements) algorithm to determine the number of
     * lines of code for a given method. NCSS ignores comments, and counts actual statements. Using this algorithm,lines
     * of code that are split are counted as one.
     */
    public static final String NcssMethodCount = "PMD.NcssMethodCount";

    /**
     * NcssTypeCount: This rule uses the NCSS (Non-Commenting Source Statements) algorithm to determine the number of
     * lines of code for a given type. NCSS ignores comments, and counts actual statements. Using this algorithm,lines
     * of * code that are split are counted as one.
     */
    public static final String NcssTypeCount = "PMD.NcssTypeCount";

    /**
     * NcssConstructorCount: This rule uses the NCSS (Non-Commenting Source Statements) algorithm to determine the
     * number of lines of code for a given constructor. NCSS ignores comments, and counts actual statements. Using this
     * algorithm,lines of code that are split are counted as one.
     */
    public static final String NcssConstructorCount = "PMD.NcssConstructorCount";

    /**
     * TooManyMethods: A class with too many methods is probably a good suspect for refactoring, in order to reduce its
     * complexity and find a way to have more fine grained objects.
     */
    public static final String TooManyMethods = "PMD.TooManyMethods";

    private PmdCodeSize() {
    }
}
