package com.ppm.commons.logging;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests of class AsLevelBuilder
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class AsLevelBuilderTest {

	private AsLevelBuilder builder;

	private Map<String, Object> logData = new HashMap<String, Object>();
	@Mock
	private FileLogger fileLoggerDelegate;
	@Mock
	private SplunkLogger splunkLoggerDelegate;
	@Mock
	private LogData value;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		logData.put("command", "tester");
		builder = new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		when(fileLoggerDelegate.logData(logData)).thenReturn(value);
		when(splunkLoggerDelegate.logData(logData)).thenReturn(value);
	}

	/**
	 * Test method for
	 * {@link com.ppm..util.logging.AsLevelBuilder#asInfo()}.
	 */
	@Test
	public final void testAsInfo() {
		builder.asInfo();
		verify(fileLoggerDelegate, atMost(1)).logData(logData);
		verify(splunkLoggerDelegate, atMost(1)).logData(logData);
		verify(value, atLeastOnce()).asInfo();
	}

	/**
	 * Test method for
	 * {@link com.ppm..util.logging.AsLevelBuilder#asWarn()}.
	 */
	@Test
	public final void testAsWarn() {
		builder.asWarn();
		verify(fileLoggerDelegate, atMost(1)).logData(logData);
		verify(splunkLoggerDelegate, atMost(1)).logData(logData);
		verify(value, atLeastOnce()).asWarn();
	}

	/**
	 * Test method for
	 * {@link com.ppm..util.logging.AsLevelBuilder#asError()}.
	 */
	@Test
	public final void testAsError() {
		builder.asError();
		verify(fileLoggerDelegate, atMost(1)).logData(logData);
		verify(splunkLoggerDelegate, atMost(1)).logData(logData);
		verify(value, atLeastOnce()).asError();		
	}

	/**
	 * Test method for
	 * {@link com.ppm..util.logging.AsLevelBuilder#asDebug()}.
	 */
	@Test
	public final void testAsDebug() {
		builder.asDebug();
		verify(fileLoggerDelegate, atMost(1)).logData(logData);
		verify(splunkLoggerDelegate, atMost(1)).logData(logData);
		verify(value, atLeastOnce()).asDebug();
	}
}
