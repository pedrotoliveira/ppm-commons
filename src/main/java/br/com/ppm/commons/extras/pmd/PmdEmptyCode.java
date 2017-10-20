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
 * PMD Empty Code Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdEmptyCode {

    /**
     * EmptyCatchBlock: Empty Catch Block finds instances where an exception is caught, but nothing is done. In most
     * circumstances, this swallows an exception which should either be acted on or reported.
     */
    public static final String EmptyCatchBlock = "PMD.EmptyCatchBlock";

    /**
     * EmptyIfStmt: Empty If Statement finds instances where a condition is checked but nothing is done about it.
     */
    public static final String EmptyIfStmt = "PMD.EmptyIfStmt";

    /**
     * EmptyWhileStmt: Empty While Statement finds all instances where a while statement does nothing. If it is a timing
     * loop, then you should use Thread.sleep() for it; if it is a while loop that does a lot in the exit expression,
     * rewrite it to make it clearer.
     */
    public static final String EmptyWhileStmt = "PMD.EmptyWhileStmt";

    /**
     * EmptyTryBlock: Avoid empty try blocks - what’s the point?
     */
    public static final String EmptyTryBlock = "PMD.EmptyTryBlock";

    /**
     * EmptyFinallyBlock: Empty finally blocks serve no purpose and should be removed.
     */
    public static final String EmptyFinallyBlock = "PMD.EmptyFinallyBlock";

    /**
     * EmptySwitchStatements: Empty switch statements serve no purpose and should be removed.
     */
    public static final String EmptySwitchStatements = "PMD.EmptySwitchStatements";

    /**
     * EmptySynchronizedBlock: Empty synchronized blocks serve no purpose and should be removed.
     */
    public static final String EmptySynchronizedBlock = "PMD.EmptySynchronizedBlock";

    /**
     * EmptyStatementNotInLoop: An empty statement (or a semicolon by itself) that is not used as the sole body of a
     * ‘for’ or ‘while’ loop is probably a bug. It could also be a double semicolon, which has no purpose and should be
     * removed.
     */
    public static final String EmptyStatementNotInLoop = "PMD.EmptyStatementNotInLoop";

    /**
     * EmptyInitializer: Empty initializers serve no purpose and should be removed.
     */
    public static final String EmptyInitializer = "PMD.EmptyInitializer";

    /**
     * EmptyStatementBlock: Empty block statements serve no purpose and should be removed.
     */
    public static final String EmptyStatementBlock = "PMD.EmptyStatementBlock";

    /**
     * EmptyStaticInitializer: An empty static initializer serve no purpose and should be removed.
     */
    public static final String EmptyStaticInitializer = "PMD.EmptyStaticInitializer";

    private PmdEmptyCode() {
    }
}
