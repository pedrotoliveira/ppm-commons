/*
 *  Copyright (C) 2016 Pedro T. Oliveira <pedro.oliveira.nom.br>
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
package br.com.ppm.commons;

import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * RecursiveToStringDepthController - controls concurrent calls of ToStringBuilder.reflectiveToString.
 *
 * @author Pedro T. Oliveira
 *
 */
final class RecursiveToStringDepthController {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(RecursiveToStringDepthController.class);

	/** The Constant SUCCESS. */
	private static final boolean SUCCESS = true;

	/** The Constant FAIL. */
	private static final boolean FAIL = !SUCCESS;

	/** The Constant TO_STRING_BUILDER_CLASS_NAME. */
	private static final String TO_STRING_BUILDER_CLASS_NAME = ToStringBuilder.class.getName();

	/** The Constant MAX_DEPTH. */
	private static final int MAX_DEPTH = 100;

	/** The Constant MAX_STACK_SIZE. */
	private static final int MAX_STACK_SIZE = 1024;

	/** The Constant allHoldersInCurrentThread. */
	private static final ThreadLocal<Set<StackTraceHolder>> allHoldersInCurrentThread = new ThreadLocal<Set<StackTraceHolder>>() {
		@Override
		protected Set<StackTraceHolder> initialValue() {
			return new HashSet<>();
		}
	};

	/** The Constant currentHolder. */
	private static final ThreadLocal<StackTraceHolder> currentHolder = new ThreadLocal<>();

	/**
	 * Instantiates a new recursive to string depth controller.
	 */
	private RecursiveToStringDepthController() {
		/** No instances for this class */
	}

	/**
	 * Checks if is allowed.
	 *
	 * @return true, if is allowed
	 */
	static boolean isAllowed() {
		return registerCaller() ? validateCallCounts() : false;
	}

	/**
	 * Validate call counts.
	 *
	 * @return true, if successful
	 */
	private static boolean validateCallCounts() {
		boolean valid = true;
		if (getCurrentHolder() != null) {
			int count = getCurrentHolder().getCallCounts();
			if (count > MAX_DEPTH) {
				valid = false;
				logger.error("ToString not allowed, " + getCurrentHolder());
			}
		}
		return valid;
	}

	/**
	 * Register caller.
	 *
	 * @return true, if successful
	 */
	private static boolean registerCaller() {
		try {
			final int stackTraceLength = Thread.currentThread().getStackTrace().length;
			if (stackTraceLength == MAX_STACK_SIZE) {
				logger.error("ToString not allowed, Max Stack Size " + MAX_STACK_SIZE + " Reached!");
				getAllholdersInCurrentThread().clear();
				return FAIL;
			}

			if (stackTraceLength > 4) {
				StackTraceElement stackElement = Thread.currentThread().getStackTrace()[5];
				if (TO_STRING_BUILDER_CLASS_NAME.equals(stackElement.getClassName())) {
					return SUCCESS;
				}
				StackTraceHolder holder = new StackTraceHolder(stackElement.getClassName(), stackElement.getMethodName());
				if (getAllholdersInCurrentThread().contains(holder)) {
					holder = retrieveHolder(holder);
					if (holder.getStackSize() < stackTraceLength) {
						holder.setCallCounts(0);
						holder.setStackSize(stackTraceLength);
					} else {
						holder.incrementCallCount();
						holder.setStackSize(stackTraceLength);
					}
				} else {
					holder.incrementCallCount();
					holder.setStackSize(stackTraceLength);
				}
				getAllholdersInCurrentThread().remove(holder);
				getAllholdersInCurrentThread().add(holder);
				setCurrentHolder(holder);
			}
			return SUCCESS;

		} catch (SecurityException ex) {
			// nothing to do now...
			return SUCCESS;
		}
	}

	/**
	 * Retrieve holder.
	 *
	 * @param holder the holder
	 *
	 * @return the stack trace holder
	 */
	private static StackTraceHolder retrieveHolder(StackTraceHolder holder) {
		for (StackTraceHolder holderInSet : allHoldersInCurrentThread.get()) {
			if (holderInSet.equals(holder)) {
				return holderInSet;
			}
		}
		return holder;
	}

	/**
	 * Gets the callers.
	 *
	 * @return the callers
	 */
	static StackTraceElement[] getCallers() {
		StackTraceElement[] callers = null;
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		if (stacks != null) {
			int offset = (stacks.length < 10) ? stacks.length : 10;
			callers = new StackTraceElement[offset];
			System.arraycopy(stacks, 0, callers, 0, offset);
		}
		return callers;
	}

	/**
	 * Gets the current holder.
	 *
	 * @return the currentholder
	 */
	static StackTraceHolder getCurrentHolder() {
		return currentHolder.get();
	}

	/**
	 * Sets the current holder.
	 *
	 * @param holder the new current holder
	 */
	static void setCurrentHolder(StackTraceHolder holder) {
		currentHolder.set(holder);
	}

	/**
	 * Gets the allholders in current thread.
	 *
	 * @return the allholdersincurrentthread
	 */
	static Set<StackTraceHolder> getAllholdersInCurrentThread() {
		return allHoldersInCurrentThread.get();
	}
}
