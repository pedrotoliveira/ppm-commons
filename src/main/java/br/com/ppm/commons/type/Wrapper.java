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
 * @author pedrotoliveira
 * @version $Id: $Id
 */
public class Wrapper<T> implements Serializable, Comparable<T> {

    private final T object;
    private WrapperTypes wrapperType;

    /**
     * <p>Constructor for Wrapper.</p>
     *
     * @param object a T object.
     */
    public Wrapper(T object) {
        ArgumentValidator.notNullParameter(object, "object");
        ArgumentValidator.isTrue(Types.isWrapper(object), "The object should be a Wrapper.");
        this.object = object;
        this.wrapperType = WrapperTypes.find(object);
    }

    /**
     * <p>Getter for the field <code>object</code>.</p>
     *
     * @return a T object.
     */
    public T getObject() {
        return object;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(T o) {
        return ((Comparable<T>) object).compareTo(o);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return  (wrapperType.isNumber())
                ? object.toString()
                : "'" + object.toString() + "'";
    }
}
