package br.com.ppm.commons;

import br.com.ppm.commons.model.Address;
import br.com.ppm.commons.model.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TypesTest {

    @Test
    public void isArray() {
        assertThat(Types.isArray(new String[]{"One", "Two", "Three"})).isTrue();
    }

    @Test
    public void hasImplementedToString() {
        assertThat(Types.hasImplementedToString(new Person())).isTrue();
    }

    @Test
    public void hasNotImplementedTiString() {
        Address address = new Address("Socorro street", 34, "21 floor");
        assertThat(Types.hasImplementedToString(address)).isFalse();
    }

    @Test
    public void booleanHasToBeWrapper() {
        assertThat(Types.isWrapper(Boolean.FALSE)).isTrue();
    }

    @Test
    public void integerHasToBeWrapper() {
        assertThat(Types.isWrapper(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void stringHasToBeWrapper() {
        assertThat(Types.isWrapper("String")).isTrue();
    }

    @Test
    public void doubleHasToBeWrapper() {
        assertThat(Types.isWrapper(Double.MAX_VALUE)).isTrue();
    }



    @Test
    public void isMap() {
    }

    @Test
    public void isCollection() {
    }

    @Test
    public void isList() {
    }
}