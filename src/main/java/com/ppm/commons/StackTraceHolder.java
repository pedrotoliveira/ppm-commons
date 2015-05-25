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
package com.ppm.commons;

/**
 * Holds a state of a call in the thread stack.
 * <p>
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 * <p>
 */
public class StackTraceHolder {

	/** The hashcode. */
	private volatile int hashcode;

	/** The object name. */
	private final String objectName;

	/** The method name. */
	private final String methodName;

	/** The call counts. */
	private int callCounts;

	/** The stack size. */
	private int stackSize;

	/**
	 * Instantiates a new stack trace holder.
	 *
	 * @param objectName the object name
	 * @param methodName the method name
	 */
	StackTraceHolder(String objectName, String methodName) {
		super();
		this.objectName = objectName;
		this.methodName = methodName;
	}

	/**
	 * Gets the call counts.
	 *
	 * @return the callCounts
	 */
	public int getCallCounts() {
		return callCounts;
	}

	/**
	 * Sets the call counts.
	 *
	 * @param callCounts the callCounts to set
	 */
	public void setCallCounts(int callCounts) {
		this.callCounts = callCounts;
	}

	/**
	 * Increment call count.
	 */
	public void incrementCallCount() {
		this.callCounts++;
	}

	/**
	 * Gets the stack size.
	 *
	 * @return the stackSize
	 */
	public int getStackSize() {
		return stackSize;
	}

	/**
	 * Sets the stack size.
	 *
	 * @param stackSize the stackSize to set
	 */
	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	/**
	 * Gets the object name.
	 *
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * Gets the method name.
	 *
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (hashcode == 0) {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
			hashcode = prime * result + ((objectName == null) ? 0 : objectName.hashCode());
		}
		return hashcode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		StackTraceHolder other = (StackTraceHolder) obj;
		if (hashcode != other.hashcode) {
			return false;
		}
		if (methodName == null) {
			if (other.methodName != null) {
				return false;
			}
		} else if (!methodName.equals(other.methodName)) {
			return false;
		}
		if (objectName == null) {
			if (other.objectName != null) {
				return false;
			}
		} else if (!objectName.equals(other.objectName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StackTraceHolder [hashcode=");
		builder.append(hashcode);
		builder.append(", objectName=");
		builder.append(objectName);
		builder.append(", methodName=");
		builder.append(methodName);
		builder.append(", callCounts=");
		builder.append(callCounts);
		builder.append(", stackSize=");
		builder.append(stackSize);
		builder.append("]");
		return builder.toString();
	}
}
