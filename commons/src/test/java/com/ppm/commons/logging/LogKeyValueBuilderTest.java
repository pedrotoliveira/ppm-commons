package com.ppm.commons.logging;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests of class SplunkLogKeyBuilder
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LogKeyValueBuilderTest {
	
	@Mock
	private Logger logger;
	
	@Test
	public final void testNewKey() {
		assertThat(LogKeyValueBuilder.create(logger, "command").getKey(), equalTo("command="));
		assertThat(LogKeyValueBuilder.create(logger, "command=").getKey(), equalTo("command="));
	}

	
	@Test
	public final void testLogKeyValue() {
		
		LogKeyValueBuilder builder = LogKeyValueBuilder.create(logger, "command");		
		builder.value("tester");
		
		final String message = "command=tester ";
		
		builder.asInfo();
		verify(logger, atLeastOnce()).info(message);
		builder.asWarn();
		verify(logger, atLeastOnce()).warn(message);
		builder.asDebug();
		verify(logger, atLeastOnce()).debug(message);
		builder.asError();
		verify(logger, atLeastOnce()).error(message);
	}
	
	@Test(expected=NullPointerException.class)
	public final void testLogNullKey() {
		LogKeyValueBuilder builder = LogKeyValueBuilder.create(logger, "command");
		builder.logKey(null).value("sei não").asDebug();
	}
}
