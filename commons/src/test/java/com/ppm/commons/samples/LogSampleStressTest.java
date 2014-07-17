package com.ppm.commons.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class LogSampleStressTest {
	
	public static void main(String[] args) throws InterruptedException {		
		int maxTasks = 1;

		LogSample sample = new LogSample();
		
		List<ExecuteServiceTask> tasks = new ArrayList<ExecuteServiceTask>();
		for (int i = 0; i < maxTasks; i++) {
			tasks.add(new ExecuteServiceTask(sample));
		}

		ExecutorService executor = Executors.newFixedThreadPool(200);
		@SuppressWarnings("unused")
		List<Future<String>> futures = executor.invokeAll(tasks);
		executor.shutdown();
		while (!executor.isTerminated()){}
		System.out.println("Terminated");
	}
	
	
	static class ExecuteServiceTask implements Callable<String> {
		
		private LogSample sample;
		
		public ExecuteServiceTask(LogSample sample) {			
			this.sample = sample;
		}
				
		@Override
		public String call() throws Exception {
			sample.logSomething();
			return "OK";
		}
	}
}
