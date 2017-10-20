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
 * PMD Finalizer Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdFinalizer {

    /**
     * EmptyFinalizer: Empty finalize methods serve no purpose and should be removed.
     */
    public static final String EmptyFinalizer = "PMD.EmptyFinalizer";

    /**
     * FinalizeOnlyCallsSuperFinalize: If the finalize() is implemented, it should do something besides just calling
     * super.finalize().
     */
    public static final String FinalizeOnlyCallsSuperFinalize = "PMD.FinalizeOnlyCallsSuperFinalize";

    /**
     * FinalizeOverloaded: Methods named finalize() should not have parameters. It is confusing and most likely an
     * attempt to overload Object.finalize(). It will not be called by the VM.
     */
    public static final String FinalizeOverloaded = "PMD.FinalizeOverloaded";

    /**
     * FinalizeDoesNotCallSuperFinalize: If the finalize() is implemented, its last action should be to call
     * super.finalize.
     */
    public static final String FinalizeDoesNotCallSuperFinalize = "PMD.FinalizeDoesNotCallSuperFinalize";

    /**
     * FinalizeShouldBeProtected: When overriding the finalize(), the new method should be set as protected. If made
     * public, other classes may invoke it at inappropriate times.
     */
    public static final String FinalizeShouldBeProtected = "PMD.FinalizeShouldBeProtected";

    /**
     * AvoidCallingFinalize: The method Object.finalize() is called by the garbage collector on an object when garbage
     * collection determines that there are no more references to the object. It should not be invoked by application
     * logic.
     */
    public static final String AvoidCallingFinalize = "PMD.AvoidCallingFinalize";

    private PmdFinalizer() {
    }

}
