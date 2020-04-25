/*
 * Copyright (C) 2020.
 */

package br.com.ppm.commons.fixtures;

import java.util.List;
import java.util.Map;

public final class PersonBuilder {
    private Person person;

    private PersonBuilder() {
        person = new Person();
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name) {
        person.setName(name);
        return this;
    }

    public PersonBuilder withAge(int age) {
        person.setAge(age);
        return this;
    }

    public PersonBuilder withAddress(Address address) {
        person.setAddress(address);
        return this;
    }

    public PersonBuilder withNumbers(short[] numbers) {
        person.setNumbers(numbers);
        return this;
    }

    public PersonBuilder withAlive(boolean alive) {
        person.setAlive(alive);
        return this;
    }

    public PersonBuilder withOrders(List<Order> orders) {
        person.setOrders(orders);
        return this;
    }

    public PersonBuilder withParents(Map<String, Person> parents) {
        person.setParents(parents);
        return this;
    }

    public Person build() {
        return person;
    }
}
