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
 * PMD String and StringBuffer Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdStringAndStringBuffer {

    /**
     * AvoidDuplicateLiterals: Code containing duplicate String literals can usually be improved by declaring the String
     * as a constant field.
     */
    public static final String AvoidDuplicateLiterals = "PMD.AvoidDuplicateLiterals";

    /**
     * StringInstantiation: Avoid instantiating String objects; this is usually unnecessary since they are immutable and
     * can be safely shared.
     */
    public static final String StringInstantiation = "PMD.StringInstantiation";

    /**
     * StringToString: Avoid calling toString() on objects already known to be string instances; this is unnecessary.
     */
    public static final String StringToString = "PMD.StringToString";

    /**
     * InefficientStringBuffering: Avoid concatenating non-literals in a StringBuffer constructor or append() since
     * intermediate buffers will need to be be created and destroyed by the JVM.
     */
    public static final String InefficientStringBuffering = "PMD.InefficientStringBuffering";

    /**
     * UnnecessaryCaseChange: Using equalsIgnoreCase() is faster than using toUpperCase/toLowerCase().equals()
     */
    public static final String UnnecessaryCaseChange = "PMD.UnnecessaryCaseChange";

    /**
     * UseStringBufferLength: Use StringBuffer.length() to determine StringBuffer length rather than using
     * StringBuffer.toString().equals("")or StringBuffer.toString().length() == …
     */
    public static final String UseStringBufferLength = "PMD.UseStringBufferLength";

    /**
     * AppendCharacterWithChar: Avoid concatenating characters as strings in StringBuffer/StringBuilder.append methods.
     */
    public static final String AppendCharacterWithChar = "PMD.AppendCharacterWithChar";

    /**
     * ConsecutiveAppendsShouldReuse: Consecutively calls to StringBuffer/StringBuilder .append should reuse the target
     * object. This can improve the performance.
     */
    public static final String ConsecutiveAppendsShouldReuse = "PMD.ConsecutiveAppendsShouldReuse";

    /**
     * ConsecutiveLiteralAppends: Consecutively calling StringBuffer/StringBuilder.append with String literals
     */
    public static final String ConsecutiveLiteralAppends = "PMD.ConsecutiveLiteralAppends";

    /**
     * UseIndexOfChar: Use String.indexOf(char) when checking for the index of a single character; it executes faster.
     */
    public static final String UseIndexOfChar = "PMD.UseIndexOfChar";

    /**
     * InefficientEmptyStringCheck: String.trim().length() is an inefficient way to check if a String is really empty,
     * as it creates a new String object just to check its size. Consider creating a static function that loops through
     * a string, checking Character.isWhitespace() on each character and returning false if a non-whitespace character
     * is     * found.
     */
    public static final String InefficientEmptyStringCheck = "PMD.InefficientEmptyStringCheck";

    /**
     * InsufficientStringBufferDeclaration: Failing to pre-size a StringBuffer or StringBuilder properly could cause it
     * to re-size many times during runtime. This rule attempts to determine the total number the characters that are
     * actually passed into StringBuffer.append(), but represents a best guess “worst case” scenario. An
     * emptyStringBuffer/StringBuilder constructor initializes the object to 16 characters. This default is assumed if
     * the length of the constructor can not be determined.
     */
    public static final String InsufficientStringBufferDeclaration = "PMD.InsufficientStringBufferDeclaration";

    /**
     * UselessStringValueOf: No need to call String.valueOf to append to a string; just use the valueOf() argument
     * directly.
     */
    public static final String UselessStringValueOf = "PMD.UselessStringValueOf";

    /**
     * StringBufferInstantiationWithChar: Individual character values provided as initialization arguments will be
     * converted into integers.This can lead to internal buffer sizes that are larger than expected. Some examples:new
     * StringBuffer() // 16new StringBuffer(6) // 6new StringBuffer(“hello world”) // 11 + 16 = 27new StringBuffer(‘A’)
     * // chr(A) = 65new StringBuffer(“A”) // 1 + 16 = 17 new StringBuilder() // 16new StringBuilder(6) // 6new
     * StringBuilder(“hello world”) // 11 + 16 = 27new StringBuilder(‘C’) // chr(C) = 67new StringBuilder(“A”) // 1 + 16
     * = 17
     */
    public static final String StringBufferInstantiationWithChar = "PMD.StringBufferInstantiationWithChar";

    /**
     * UseEqualsToCompareStrings: Using ‘==’ or ‘!=’ to compare strings only works if intern version is used on both
     * sides.Use the equals() method instead.
     */
    public static final String UseEqualsToCompareStrings = "PMD.UseEqualsToCompareStrings";

    /**
     * AvoidStringBufferField: StringBuffers/StringBuilders can grow considerably, and so may become a source of memory
     * leaks if held within objects with long lifetimes.
     */
    public static final String AvoidStringBufferField = "PMD.AvoidStringBufferField";

    private PmdStringAndStringBuffer() {
    }

}
