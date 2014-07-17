package com.ppm.commons.samples;

import java.util.Hashtable;
import java.util.Map;

import com.ppm.commons.logging.FluentLogger;
import com.ppm.commons.logging.LoggerService;

/**
 * Log Sampler
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 * 
 */
public class LogSample {

	private static final FluentLogger logger = LoggerService.init(LogSample.class);

	public void logSomething() {

		logger.perf4j().start();

		// LOG IN DEBUG LEVEL A EXCEPTION!
		logger.file().logDebug("debug-exeception", new Exception("debug"));
		
		//CHAINNED CALL EXAMPLE!
		logger.all()
			.logKey("command=").value("command1")
			.logKey("merchant").value("loja-teste")
			.logKey("merchantCode").value("18655838")
			.asInfo().asError();
		
		//SIMPLE CALL INFO ON SPLUNK LOGGER WITH A LOG DATA MAP!
		Map<String, Object> logData = new Hashtable<String, Object>();
		logData.put("Key1", "Value1");
		logData.put("Key2", "Value2");
		logData.put("Key3", "Value3");
		logData.put("Key4", "Value4");
		
		logger.splunk()
			  .logKey("qualquercoisa").value("valordequalquercoisa")
			  .logKey("mais uma chave").value("valor da chave").asError();
		
		logger.splunk().logKey("aeee").value("aeee").asInfo();		
		logger.splunk().logKey("aee2").value("aee3").asError();
		
		logger.splunk().logData(logData).asInfo();
		
		// LOG ALL AS INFO, ERRO AND DEBUG
		logger.all().logData(logData).asInfo().asError().asDebug();

		// LOG ALL INFO
		logger.all().logInfo("LOG Info example");

		logger.all().logKey("info").value("aaa").asInfo().asWarn();

		// LOG SPLUNK SINGLE KEV-VALUE
		logger.splunk().logKey("command=").value("egwNotifyRouterCommand").asError();
		// LOG SPLUNK KEY-VALUE ANY MODES.
		logger.splunk().logKey("merchant=").value("bpagnovaiorque1").asInfo().asDebug().asWarn().asError();
		// LOG ALL AS ERROR
		logger.all().logError("hehe");

		// LOG PERF4J STOP
		logger.perf4j().stop();
	}	
}
