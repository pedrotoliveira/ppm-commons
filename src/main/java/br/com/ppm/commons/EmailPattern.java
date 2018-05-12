/*
 * Copyright (C) 2018 pedrotoliveira
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

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class EmailPattern Holds email regex patterns
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 12/05/18 09:47
 */
public class EmailPattern {
    
    public static final String REGEX = "^([A-Z0-9._%+-]+){1,32}@([\\w&&[^_]]+){2,255}.[a-z]{4,}$";
    public final Pattern VALID_EMAIL_PATTERN = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
    
    private final Matcher matcher;
    
    public EmailPattern(final String toMatch) {
        this.matcher = VALID_EMAIL_PATTERN.matcher(toMatch);
    }
    
    public boolean matches() {
        return matcher.matches();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailPattern)) return false;
        EmailPattern that = (EmailPattern) o;
        return Objects.equals(VALID_EMAIL_PATTERN, that.VALID_EMAIL_PATTERN) &&
                Objects.equals(matcher, that.matcher);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(VALID_EMAIL_PATTERN, matcher);
    }
}
