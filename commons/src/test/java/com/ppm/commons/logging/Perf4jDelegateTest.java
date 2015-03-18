package com.ppm.commons.logging;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit Tests of class Perf4jDelegate
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class Perf4jDelegateTest {

	private Perf4jDelegate delegate;
	@Mock
	private Logger logger;
	
	@Before
	public void setUp() throws Exception {	
		delegate = Perf4jDelegate.create(logger);
	}

	@Test
	public final void test() {
		//FIXME: Infelismente não há muito o que testar nessa classe.
		//Já que todas as operações são delegadas ao StopWatch interno, que não pode ser mockado
		//da forma como foi implementado. O ideal seria alterar a implementação.
		delegate.start();	
		delegate.stop();		
		delegate.start("teste");
		delegate.stop("teste");
	}

	@Test
	public void testStart_0args() {
	}

	@Test
	public void testStart_String() {
	}

	@Test
	public void testStop_0args() {
	}

	@Test
	public void testStop_String() {
	}

	@Test
	public void testStop_String_Exception() {
	}

	@Test
	public void testLap() {
	}

	@Test
	public void testStop_String_String() {
	}

}
