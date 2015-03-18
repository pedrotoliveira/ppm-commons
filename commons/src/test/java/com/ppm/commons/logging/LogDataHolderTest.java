package com.ppm.commons.logging;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogDataHolderTest {
	
	private LogDataHolder holder;
	
	private Map<String, Object> logData = new HashMap<String, Object>();
	
	@Mock
	private SplunkLogger splunkLoggerDelegate;
	@Mock
	private FileLogger fileLoggerDelegate;
	@Mock
	private LogData mockedData;

	@Before
	public void setUp() throws Exception {
		logData.put("command", "tester");		
		when(fileLoggerDelegate.logData(logData)).thenReturn(mockedData);
		when(splunkLoggerDelegate.logData(logData)).thenReturn(mockedData);		
	}

	@After
	public void tearDown() throws Exception {
		holder = null;
	}

	@Test
	public final void testAsInfo() {
		holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		holder.asInfo();		
		verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
		verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
		verify(mockedData, atLeastOnce()).asInfo();
	}

	@Test
	public final void testAsWarn() {
		holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		holder.asWarn();
		verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
		verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
		verify(mockedData, atLeastOnce()).asWarn();
	}

	@Test
	public final void testAsError() {
		holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		holder.asError();
		verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
		verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
		verify(mockedData, atLeastOnce()).asError();
	}

	@Test
	public final void testAsDebug() {
		holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		holder.asDebug();
		verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
		verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
		verify(mockedData, atLeastOnce()).asDebug();
	}

	@Test
	public final void testGetData() {
		holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
		when(mockedData.getData()).thenReturn("command=tester ");
		assertThat(holder.getData(), equalTo("command=tester "));
	}

}
