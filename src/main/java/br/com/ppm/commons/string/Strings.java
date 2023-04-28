/*
 *     Copyright (C) 2023 - pedro.oliveira20@gmail.com
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

import br.com.ppm.commons.validation.ArgumentValidator;

/**
 * String Operations
 *
 * @author pedrotoliveira
 */
public interface Strings {

    /**
     * Capitalize the first letter from a Text
     *
     * @param text the text string
     *
     * @return the new text with first letter Capitalized
     */
    static String capitalizeFirstLetter(final String text) {
        return Character.toUpperCase(text.charAt(0)) +
                text.substring(1);
    }

    static boolean isEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    static boolean isBlank(final String text) {
        return text != null && text.isEmpty();
    }

    /**
     * Mask a String
     *
     * @param value the value
     * @return the masked string
     */
    static String mask(final String value) {
        ArgumentValidator.notNullParameter(value, "value");
        final int size = value.length();

        if (size < 11) {
            return value.replaceAll("\\.", "*");
        }

        final int lastPart = 4;
        final int firstPart = 6;
        final int maskSize = size - lastPart - firstPart;

        return value.substring(0, firstPart) + "*".repeat(maskSize) +
                value.substring(size - lastPart, size);
    }
}
