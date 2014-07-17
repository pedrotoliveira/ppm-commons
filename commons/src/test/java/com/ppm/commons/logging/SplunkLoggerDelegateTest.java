package com.ppm.commons.logging;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests of class SplunkLoggerDelegate
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class SplunkLoggerDelegateTest {
	
	private SplunkLoggerDelegate delegate;
	
	private String message;
	
	@Mock
	private Logger logger;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		message = "Something to log";
		delegate = SplunkLoggerDelegate.create(logger);
	}
	
	@Test
	public final void testLogInfo() {
		delegate.logInfo(message);		
		verify(logger, atLeastOnce()).info(message);
	}
	
	@Test
	public final void testLogWarn() {
		delegate.logWarn(message);
		verify(logger, atLeastOnce()).warn(message);
	}
	
	@Test
	public final void testLogDebug() {
		delegate.logDebug(message);
		verify(logger, atLeastOnce()).debug(message);
	}
	
	@Test
	public final void testLogError() {
		delegate.logError(message);
		verify(logger, atLeastOnce()).error(message);		
	}
	
	@Test
	public final void testLogKeyValue() {
		delegate.logKey("key=").value("value").asInfo();
		verify(logger, atLeastOnce()).info("key=value ");
		
		delegate.logKey("key=").value("value").asDebug();
		verify(logger, atLeastOnce()).debug("key=value ");
		
		delegate.logKey("key=").value("value").asWarn();
		verify(logger, atLeastOnce()).warn("key=value ");
		
		delegate.logKey("key=").value("value").asError();
		verify(logger, atLeastOnce()).error("key=value ");
	}

}
