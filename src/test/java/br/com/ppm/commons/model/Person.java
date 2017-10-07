/*
 * Copyright (C) 2017 ppm
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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.ppm.commons.ToStringBuilder;

/**
 *
 * @author pedrotoliveira
 */
public final class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String CONSTANTE = "constante";
    private String name;
    private int age;
    private Address address;
    private short[] numbers;
    private boolean alive;
    private final String NULL_OBJECT = null;
    private List<Order> orders;
    private Map<String, Person> parents;
    private final Class<Person> clazz = Person.class;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setNumbers(short[] numbers) {
        this.numbers = numbers;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setParents(Map<String, Person> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
