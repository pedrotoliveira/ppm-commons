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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * DepthController - controls consecutive calls of ToStringBuilder.reflectiveToString for the same thread
 *
 * @author Pedro T. Oliveira
 * @since 2.1.2
 */
final class DepthController {

	private static final ThreadLocal<Set<ClassNameHolder>> HOLDERS = ThreadLocal.withInitial(HashSet::new);

	/**
	 * No instances
	 */
	private DepthController() {
	}

	/**
	 * Checks if is allowed.
	 *
	 * @return true, if is allowed
	 */
    public static boolean isAllowed(final Object object) {
    	return object == null || registerCaller(object).validateCallCounts();
	}

	private static ClassNameHolder registerCaller(final Object object) {
    	ClassNameHolder holder = ClassNameHolder.of(object);
		Optional<ClassNameHolder> item = HOLDERS
				.get()
				.stream()
				.filter(holder::equals)
				.findFirst();

		if (item.isPresent()) {
			return item.get().incrementCallCount();
		} else {
			HOLDERS.get().add(holder);
			return holder.incrementCallCount();
		}
	}
}
