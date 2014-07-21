/*
 * Copyright (C) 2014 cad_ptoliveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ppm.persistence;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cad_ptoliveira
 */
public class UnitOfWorkTest {

	public UnitOfWorkTest() {
	}

	@Before
	public void setUp() {
	}

	@Test
	public void testMarkToInsert_Object() {
	}

	@Test
	public void testMarkToInsert_Object_ObjectArr() {
	}

	@Test
	public void testMarkToUpdate() {
	}

	@Test
	public void testMarkToDelete() {
	}

	@Test
	public void testCommit() {
	}

	@Test
	public void testRollback() {
	}

	@Test
	public void testSetRollbackOnly() {
	}

	@Test
	public void testClean() {
	}

	@Test
	public void testGetStatus() {
	}

	public class UnitOfWorkImpl implements UnitOfWork {

		public void markToInsert(Object entity) {
		}

		public void markToInsert(Object entity, Object[] parents) {
		}

		public void markToUpdate(Object entity) {
		}

		public void markToDelete(Object entity) {
		}

		public void commit() {
		}

		public void rollback() {
		}

		public void setRollbackOnly() {
		}

		public void clean() {
		}

		public Status getStatus() {
			return null;
		}
	}

}
