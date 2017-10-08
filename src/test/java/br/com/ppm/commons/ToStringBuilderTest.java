package br.com.ppm.commons;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ppm.commons.model.Address;
import br.com.ppm.commons.model.Card;
import br.com.ppm.commons.model.ClassA;
import br.com.ppm.commons.model.ClassB;
import br.com.ppm.commons.model.Order;
import br.com.ppm.commons.model.Person;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * The Class ToStringBuilderTest.
 *
 * @author Pedro T. Oliveira
 */
public class ToStringBuilderTest {

    /**
   	 * Test method for.
	 *
	 * {@link com.ppm..util.ToStringBuilder#reflectionToString(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testReflectionToString() {
		Person person = new Person();
		person.setName("John Doe");
		person.setAddress(new Address("Some street", 35, "Apto 2"));
		person.setAge(35);
		person.setAlive(true);
		person.setNumbers(new short[]{1, 3, 4, 5});
		person.setOrders(Arrays.asList(new Order[]{new Order(12358), new Order(12387), new Order(821)}));

		Map<String, Person> parents = new HashMap<>();
		Person father = new Person();
		father.setName("Bill Doe");
		father.setAddress(new Address("Cemitery", 582, null));
		father.setAge(0);
		father.setAlive(false);
		father.setNumbers(null);
		parents.put("father", father);

		Person mother = new Person();
		mother.setName("Willy Mae Doe");
		mother.setAddress(new Address("Older street", 82, "bloco a"));
		mother.setAge(70);
		mother.setAlive(false);
		mother.setNumbers(new short[]{9, 7, 6, 8});
		parents.put("mother", mother);

		person.setParents(parents);

        String toStringExpected = "Person[name=John Doe, age=35, "
                + "address=Address[street=Some street, number=35, complement=Apto 2], "
                + "numbers=[1, 3, 4, 5], "
                + "alive=true, "
                + "NULL_OBJECT=null, "
                + "orders=ArrayList{ Order[id=12358], Order[id=12387], Order[id=821] }, "
                + "parents=Map{ (k1=mother, v1=[Person[name=Willy Mae Doe, age=70, "
                + "address=Address[street=Older street, number=82, complement=bloco a], "
                + "numbers=[9, 7, 6, 8], alive=false, NULL_OBJECT=null, orders=null, parents=null, "
                + "clazz=class br.com.ppm.commons.model.Person]]), (k2=father, v2=[Person[name=Bill Doe, age=0, "
                + "address=Address[street=Cemitery, number=582, complement=null], numbers=null, alive=false, "
                + "NULL_OBJECT=null, orders=null, parents=null, clazz=class br.com.ppm.commons.model.Person]]) }, "
                + "clazz=class br.com.ppm.commons.model.Person]";

        String result = person.toString();
        assertThat("toString result should be equal to expected", result, equalTo(toStringExpected));
	}

    @Test
	public void testCyclicReferences() {
        ClassA a = new ClassA();
        ClassB b = new ClassB(a);
		a.setB(b);

		String result = ToStringBuilder.reflectionToString(b);
		System.out.println(result);
	}

	@Test
	public void testMaskFields() {
		String number = "1058030000000055";
		String cvv = "***";
		String maskedNumber = "105803******0055";
		String expected = "Card[ccNumber=" + maskedNumber + ", cvv=" + "***" + "]";
        String result = new Card(number, cvv).toString();
        assertThat("CardNumber should be masked", result, equalTo(expected));
	}

	/**
	 * Test collections.
	 */
	@Test
	public void testCollections() {
		final List<String> l = Arrays.asList(new String[]{"one", "two", "three"});
		final List<List<String>> listWithList = new ArrayList<>();
		listWithList.add(l);
		listWithList.add(l);
		listWithList.add(l);

		String toStringExpected = "ArrayList{"
				+ " ArrayList{ [one], [two], [three] },"
				+ " ArrayList{ [one], [two], [three] },"
				+ " ArrayList{ [one], [two], [three] }"
				+ " }";

        String result = ToStringBuilder.reflectionToString(listWithList);
        assertThat("toString of Collections should be equal to expected", result, equalTo(toStringExpected));
	}

    @Test
	public void testArrays() {

	}

	@Test
	@Ignore("Teste a ser Implementado.")
	public void testWrappers() {
		//TODO: Implementar!!
	}

	@Test
	@Ignore("Teste a ser Implementado.")
	public void testMap() {
		//TODO: Implementar!!
	}
}
