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
 * PMD PmdBraces Rules
 *
 * @author pedrotoliveira
 */
public final class PmdBraces {

    /**
     * IfStmtsMustUseBraces: Avoid using if statements without using braces to surround the code block. If the code
     * formatting or indentation is lost then it becomes difficult to separate the code being controlled from the rest.
     */
    public static final String IfStmtsMustUseBraces = "PMD.IfStmtsMustUseBraces";

    /**
     * WhileLoopsMustUseBraces: Avoid using ‘while’ statements without using braces to surround the code block. If the
     * code formatting or indentation is lost then it becomes difficult to separate the code being controlled from the
     * rest.
     */
    public static final String WhileLoopsMustUseBraces = "PMD.WhileLoopsMustUseBraces";

    /**
     * IfElseStmtsMustUseBraces: Avoid using if..else statements without using surrounding braces. If the code
     * formatting or indentation is lost then it becomes difficult to separate the code being controlled from the rest.
     */
    public static final String IfElseStmtsMustUseBraces = "PMD.IfElseStmtsMustUseBraces";

    /**
     * ForLoopsMustUseBraces: Avoid using ‘for’ statements without using curly braces. If the code formatting or
     * indentation is lost then it becomes difficult to separate the code being controlled from the rest.
     */
    public static final String ForLoopsMustUseBraces = "PMD.ForLoopsMustUseBraces";

    private PmdBraces() {
    }

}
