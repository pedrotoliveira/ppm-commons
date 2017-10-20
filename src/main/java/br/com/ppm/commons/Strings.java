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
package br.com.ppm.commons;

/**
 * String Operations
 *
 * @author pedrotoliveira
 */
public final class Strings {

    /**
     * No instances for this class
     */
    private Strings() {
    }

    /**
     * Capitalize the first letter from a Text
     *
     * @param text the text string
     *
     * @return the new text with first letter Capitalized
     */
    public static String capitalizeFirstLetter(final String text) {
        return new StringBuilder(text.length())
                .append(Character.toUpperCase(text.charAt(0)))
                .append(text.substring(1))
                .toString();
    }

    public static boolean isEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isBlank(final String text) {
        return text != null && text.isEmpty();
    }

    /**
     * Mask a String
     * <p>
     * @param value the value
     * <p>
     * @return the object
     */
    public static String mask(String value) {
        Validator.notNullParameter(value, "value");
        final int size = value.length();

        if (size < 11) {
            return value.replaceAll("\\.", "*");
        }

        final int lastPart = 4;
        final int firstPart = 6;
        final int maskSize = size - lastPart - firstPart;

        final StringBuilder sb = new StringBuilder(value.substring(0, firstPart));
        for (int i = 0; i < maskSize; i++) {
            sb.append('*');
        }
        return sb.append(value.substring(size - lastPart, size)).toString();
    }
}
