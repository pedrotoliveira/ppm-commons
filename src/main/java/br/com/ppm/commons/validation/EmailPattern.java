/*
 * Copyright (C) 2020 pedrotoliveira
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
package br.com.ppm.commons.validation;

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
    
    private static final String REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,6}$";
    private final Pattern pattern;
    private final Matcher matcher;
    
    public EmailPattern(final String toMatch) {
        this.pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        this.matcher = pattern.matcher(toMatch);
    }
    
    public boolean matches() {
        return matcher.matches();
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailPattern that = (EmailPattern) o;
        return Objects.equals(pattern, that.pattern) &&
                Objects.equals(matcher, that.matcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, matcher);
    }

    @Override
    public String toString() {
        return "EmailPattern{" +
                "pattern=" + pattern +
                ", matcher=" + matcher +
                '}';
    }
}
