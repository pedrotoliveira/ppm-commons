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
package br.com.ppm.commons.fixtures;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import br.com.ppm.commons.ToStringBuilder;

/**
 *
 * @author pedrotoliveira
 */
public final class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String CONSTANT = "constant";
    private String name;
    private int age;
    private Address address;
    private short[] numbers;
    private boolean alive;
    private final String NULL_OBJECT = null; //NOPMD
    private List<Order> orders;
    private Map<String, Person> parents;
    private final Class<Person> clazz = Person.class;

    public Person() {
        super();
    }

    public Person(String name, int age, boolean alive) {
        this.name = name;
        this.age = age;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public short[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    public void setNumbers(short... numbers) {
        if (numbers != null) {
            this.numbers = Arrays.copyOf(numbers, numbers.length);
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Map<String, Person> getParents() {
        return parents;
    }

    public void setParents(Map<String, Person> parents) {
        this.parents = parents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.age;
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Arrays.hashCode(this.numbers);
        hash = 97 * hash + (this.alive ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.clazz);
        return hash;
    }

    @Override
    @SuppressWarnings("PMD.SimplifyBooleanReturns")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.alive != other.alive) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Arrays.equals(this.numbers, other.numbers)) {
            return false;
        }
        if (!Objects.equals(this.clazz, other.clazz)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return ToStringBuilder.toString(this);
    }

}
