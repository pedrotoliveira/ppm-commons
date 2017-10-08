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
package br.com.ppm.commons.model;

import br.com.ppm.commons.ToStringBuilder;

/**
 *
 * @author pedrotoliveira
 */
public final class ClassB {

    private final ClassA a;

    public ClassB(ClassA a) {
        this.a = a;
    }

    public ClassA getA() {
        return a;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
