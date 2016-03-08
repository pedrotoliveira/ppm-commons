/*
 *  Copyright (C) 2010 Pedro T. Oliveira <pedro.oliveira.nom.br>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ppm.commons.test;

import com.ppm.commons.ToStringBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

/**
 * A Stress test for ToStringBuilder
 *
 * @author Pedro T. Oliveira
 *
 */
public class ToStringBuilderComparisonTest {

	public static void main(String[] args) throws Exception {

		int maxTasks = 1000000;

		List<ExecuteToStringTask> tasks = new ArrayList<>();
		for (int i = 0; i < maxTasks; i++) {
			PersonOne one = new PersonOne("one" + i, UUID.randomUUID().getLeastSignificantBits());
			tasks.add(new ExecuteToStringTask(one));
		}

		long startTime1 = System.currentTimeMillis();
		ForkJoinPool executor = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		@SuppressWarnings("unused")
		List<Future<String>> futures =  executor.invokeAll(tasks);
		executor.shutdown();
		while (!executor.isTerminated()){}
		long finTime1 = executionTime(startTime1);


		tasks = new ArrayList<>();
		for (int i = 0; i < maxTasks; i++) {
			PersonTwo two = new PersonTwo("two" + i, UUID.randomUUID().getLeastSignificantBits());
			tasks.add(new ExecuteToStringTask(two));
		}

		long startTime2 = System.currentTimeMillis();
		executor = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		@SuppressWarnings("unused")
		List<Future<String>> futures2 = executor.invokeAll(tasks);
		executor.shutdown();
		while (!executor.isTerminated()){}
		long finTime2 = executionTime(startTime2);

		System.out.println("1 Reflection. msecs=" + finTime1);
		System.out.println("2 Normal. msecs=" + finTime2);
		System.out.println("Terminated");
	}

	private static class PersonOne {

		private final String name;
		private final Long documentNumber;

		public PersonOne(String name, Long documentNumber) {
			this.name = name;
			this.documentNumber = documentNumber;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	private static class PersonTwo {

		private final String name;
		private final Long documentNumber;

		public PersonTwo(String name, Long documentNumber) {
			this.name = name;
			this.documentNumber = documentNumber;
		}

		@Override
		public String toString() {
			return "PersonTwo{" + "name=" + name + ", documentNumber=" + documentNumber + '}';
		}
	}

	private static long executionTime(long startTime) {
		return (System.currentTimeMillis() - startTime);
	}

	private static class ExecuteToStringTask implements Callable<String> {

		private final Object context;

		public ExecuteToStringTask(Object context) {
			this.context = context;
		}

		@Override
		public String call() throws Exception {
			try {
				//System.out.println("TEST: " + context.toString());
				return "OK";
			} catch (Exception ex) {
				//ex.printStackTrace();
				throw ex;
			}
		}
	}
}
