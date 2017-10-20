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
 * PMD Unused Code Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdUnusedCode {

    /**
     * UnusedPrivateField: Detects when a private field is declared and/or assigned a value, but not used.
     */
    public static final String UnusedPrivateField = "PMD.UnusedPrivateField";

    /**
     * UnusedLocalVariable: Detects when a local variable is declared and/or assigned, but not used.
     */
    public static final String UnusedLocalVariable = "PMD.UnusedLocalVariable";

    /**
     * UnusedPrivateMethod: Unused Private Method detects when a private method is declared but is unused.
     */
    public static final String UnusedPrivateMethod = "PMD.UnusedPrivateMethod";

    /**
     * UnusedFormalParameter: Avoid passing parameters to methods or constructors without actually referencing them in
     * the method body.
     */
    public static final String UnusedFormalParameter = "PMD.UnusedFormalParameter";

    /**
     * UnusedModifier: Fields in interfaces are automatically public static final, and methods are public
     * abstract.Classes or interfaces nested in an interface are automatically public and static (all nested interfaces
     * are automatically static).For historical reasons, modifiers which are implied by the context are accepted by the
     * compiler, but are superfluous.
     */
    public static final String UnusedModifier = "PMD.UnusedModifier";

    private PmdUnusedCode() {
    }

}
