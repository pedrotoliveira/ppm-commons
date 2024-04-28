/*
 *     Copyright (C) 2020 - pedro.oliveira20@gmail.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.string;

/**
 * Constants Used in ToStringBuilder Classes
 *
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public final class ToStringConstants {

    /** Constant <code>OPEN_MAP_BRACKET="Map{ "</code> */
    public static final String OPEN_MAP_BRACKET = "Map{ ";
    /** Constant <code>OPEN_BRACKET="{ "</code> */
    public static final String OPEN_BRACKET = "{ ";
    /** Constant <code>CLOSE_BRACKET=" }"</code> */
    public static final String CLOSE_BRACKET = " }";
    /** Constant <code>OPEN_SQUARE_BRACKET="["</code> */
    public static final String OPEN_SQUARE_BRACKET = "[";
    /** Constant <code>CLOSE_SQUARE_BRACKET="]"</code> */
    public static final String CLOSE_SQUARE_BRACKET = "]";
    /** Constant <code>EQUAL="="</code> */
    public static final String EQUAL = "=";
    /** Constant <code>COMMA=", "</code> */
    public static final String COMMA = ", ";
    /** Constant <code>IGNORE_SUPER_TYPES=true</code> */
    public static final boolean IGNORE_SUPER_TYPES = true;
    /** Constant <code>NOT_IGNORE_SUPER_TYPES=false</code> */
    public static final boolean NOT_IGNORE_SUPER_TYPES = false;

    private ToStringConstants() {
    }
}
