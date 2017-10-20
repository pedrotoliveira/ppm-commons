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
 * PMD Import Statements Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdImportStatements {

    /**
     * DuplicateImports: Duplicate or overlapping import statements should be avoided.
     */
    public static final String DuplicateImports = "PMD.DuplicateImports";

    /**
     * DontImportJavaLang: Avoid importing anything from the package ‘java.lang’. These classes are automatically
     * imported (JLS 7.5.3).
     */
    public static final String DontImportJavaLang = "PMD.DontImportJavaLang";

    /**
     * UnusedImports: Avoid the use of unused import statements to prevent unwanted dependencies.
     */
    public static final String UnusedImports = "PMD.UnusedImports";

    /**
     * ImportFromSamePackage: There is no need to import a type that lives in the same package.
     */
    public static final String ImportFromSamePackage = "PMD.ImportFromSamePackage";

    /**
     * TooManyStaticImports: If you overuse the static import feature, it can make your program unreadable and
     * unmaintainable, polluting its namespace with all the static members you import. Readers of your code (including
     * you, a few months after you wrote it) will not know which class a static member comes from (Sun 1.5 Language Guide).
     */
    public static final String TooManyStaticImports = "PMD.TooManyStaticImports";

    /**
     * UnnecessaryFullyQualifiedName: Import statements allow the use of non-fully qualified names. The use of a fully
     * qualified name which is covered by an import statement is redundant. Consider using the non-fully qualified name.
     */
    public static final String UnnecessaryFullyQualifiedName = "PMD.UnnecessaryFullyQualifiedName";

    private PmdImportStatements() {
    }

}
