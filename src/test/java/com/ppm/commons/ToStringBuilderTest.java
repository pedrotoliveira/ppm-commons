package com.ppm.commons;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.ppm.commons.annotation.ToStringStyle;
import com.ppm.commons.annotation.ToStringStyle.Style;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The Class ToStringBuilderTest.
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
public class ToStringBuilderTest {

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

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

		String toStringExpected = "Person[name=John Doe, age=35, address=Address[street=Some street, number=35, complement=Apto 2],"
				+ " numbers=[1, 3, 4, 5],"
				+ " alive=true, NULL_OBJECT=null,"
				+ " orders=ArrayList{ Order[id=12358], Order[id=12387], Order[id=821] },"
				+ " parents=Map{"
				+ " (k1=mother, v1=[Person[name=Willy Mae Doe, age=70, address=Address[street=Older street, number=82, complement=bloco a], numbers=[9, 7, 6, 8], alive=false, NULL_OBJECT=null, orders=null, parents=null,"
				+ " clazz=class com.ppm.commons.ToStringBuilderTest$Person]]),"
				+ " (k2=father, v2=[Person[name=Bill Doe, age=0, address=Address[street=Cemitery, number=582, complement=null], numbers=null, alive=false, NULL_OBJECT=null, orders=null, parents=null,"
				+ " clazz=class com.ppm.commons.ToStringBuilderTest$Person]]) }, clazz=class com.ppm.commons.ToStringBuilderTest$Person]";

		String result = person.toString();
		System.out.println(result);
		assertThat(result, equalTo(toStringExpected));
	}

	@SuppressWarnings("unused")
	private class Address {

		private final String street;
		private final int number;
		private final String complement;

		private Address(String street, int number, String complement) {
			super();
			this.number = number;
			this.street = street;
			this.complement = complement;
		}
	}

	@SuppressWarnings("unused")
	private class Order {

		private final int id;

		private Order(int id) {
			super();
			this.id = id;
		}
	}

	@SuppressWarnings("unused")
	private class Person implements Serializable {

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

	@Test
	public void testCyclicReferences() {
		A a = new A();
		B b = new B(a);
		a.setB(b);

		String result = ToStringBuilder.reflectionToString(b);
		System.out.println(result);
	}

	private class A {

		@SuppressWarnings("unused")
		private B b;

		private A() {
			super();
		}

		public void setB(B b) {
			this.b = b;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	private class B {

		@SuppressWarnings("unused")
		private A a;

		private B(A a) {
			super();
			this.a = a;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	@Test
	public void testMaskFields() {
		String number = "1058030000000055";
		String cvv = "***";
		String maskedNumber = "105803******0055";
		String expected = "Card[ccNumber=" + maskedNumber + ", cvv=" + "***" + "]";
		String result = new Card(number, cvv).toString();
		System.out.println(result);
		assertThat(result, equalTo(expected));
	}

	private class Card {

		@ToStringStyle(Style.MASK_FIELD)
		private final String ccNumber;

		@ToStringStyle(Style.MASK_FIELD)
		private final String cvv;

		public Card(String ccNumber, String cvv) {
			super();
			this.ccNumber = ccNumber;
			this.cvv = cvv;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
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
		System.out.println(result);
		assertThat(result, equalTo(toStringExpected));
	}

	@Test
	@Ignore("Teste a ser Implementado.")
	public void testArrays() {
		// TODO: Implementar!!
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
