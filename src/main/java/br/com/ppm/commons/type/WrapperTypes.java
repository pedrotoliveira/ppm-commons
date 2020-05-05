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
package br.com.ppm.commons.type;

import br.com.ppm.commons.number.Numbers;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public enum WrapperTypes {

    String(java.lang.String.class),
    Integer(java.lang.Integer.class),
    Double(java.lang.Double.class),
    Short(java.lang.Short.class),
    Long(java.lang.Long.class),
    Float(java.lang.Float.class),
    Character(java.lang.Character.class),
    Boolean(java.lang.Boolean.class),
    Byte(java.lang.Byte.class),
    Date(java.util.Date.class),
    Calendar(java.util.Calendar.class),
    GregorianCalendar(java.util.GregorianCalendar.class),
    SQLDate(java.sql.Date.class),
    LocalDate(java.time.LocalDate.class),
    LocalDateTime(java.time.LocalDateTime.class),
    LocalTime(java.time.LocalTime.class),
    ZonedDateTime(java.time.ZonedDateTime.class),
    ZoneId(java.time.ZoneId.class),
    ZoneOffset(java.time.ZoneOffset.class),
    Locale(java.util.Locale.class),
    Class(java.lang.Class.class);

    private final String name;
    private final Class<?> classType;
    private final boolean isNumber;

    WrapperTypes(Class<?> classType) {
        this.name = classType.getName();
        this.classType = classType;
        this.isNumber = Numbers.isNumber(classType);
    }

    public static boolean anyMatch(Object value) {
        return Arrays.stream(values()).anyMatch(matcher(value));
    }

    public static Predicate<WrapperTypes> matcher(Object object) {
        return wrapperTypes -> wrapperTypes.getName().equals(object.getClass().getName());
    }

    public static <T> WrapperTypes find(T object) {
       return Arrays.stream(values())
               .filter(matcher(object))
               .findFirst()
               .orElseThrow(NoSuchElementException::new);
    }

    public String getName() {
        return name;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public boolean isNumber() {
        return isNumber;
    }

    @Override
    public java.lang.String toString() {
        return "WrapperTypes{" +
                "name='" + name + '\'' +
                ", classType=" + classType +
                ", isNumber=" + isNumber +
                '}';
    }
}
