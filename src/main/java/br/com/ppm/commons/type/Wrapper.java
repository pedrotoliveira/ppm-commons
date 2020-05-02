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

import br.com.ppm.commons.validation.ArgumentValidator;

import java.io.Serializable;

/**
 * Encapsulates commons operations from a Type
 *
 * @param <T> type to hide
 */
public class Wrapper<T> implements Serializable, Comparable<T> {

    private final T object;
    private String className;

    public Wrapper(T object) {
        ArgumentValidator.notNullParameter(object, "object");
        ArgumentValidator.isTrue(Types.isWrapper(object), "The object should be a Wrapper.");
        this.object = object;
        this.className = object.getClass().getName();
    }

    public T getObject() {
        return object;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public int compareTo(T o) {
        return ((Comparable<T>) object).compareTo(o);
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
