/*
 *     Copyright (C) 2020 - pedro.oliveira20@gmail.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons.object;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds a state of a call in the thread stack.
 *
 * @author Pedro T. Oliveira
 *
 */
final class ClassNameHolder {

	private final String className;
	private final int hashCode;
	private final AtomicInteger callCounts;
	private final int MAX_CALL_COUNTS = 2500;

	/**
	 * Instantiates a new stack trace holder.
	 * @param className class name
	 */
    ClassNameHolder(String className, int hashCode) {
		this.className = className;
		this.hashCode = hashCode;
		this.callCounts = new AtomicInteger(0);
	}

	static ClassNameHolder of(Object object) {
    	return new ClassNameHolder(object.getClass().getName(), Objects.hashCode(object));
	}

	/**
	 * Increment call count.
	 */
	 ClassNameHolder incrementCallCount() {
		this.callCounts.incrementAndGet();
		return this;
	}

	public boolean validateCallCounts() {
		return callCounts.get() <= MAX_CALL_COUNTS;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassNameHolder holder = (ClassNameHolder) o;
		return hashCode == holder.hashCode &&
				Objects.equals(className, holder.className);
	}

	@Override
	public int hashCode() {
		return Objects.hash(className, hashCode);
	}

	@Override
	public String toString() {
		return "ClassHolder{" +
				"className='" + className + '\'' +
				", hashCode=" + hashCode +
				", callCounts=" + callCounts +
				", MAX_CALL_COUNTS=" + MAX_CALL_COUNTS +
				'}';
	}
}
