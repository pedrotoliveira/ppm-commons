/*
 * Copyright (C) 2020 pedrotoliveira
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
package br.com.ppm.commons.type;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Wrappers implements Map<String, Wrapper> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Wrapper get(Object key) {
        return null;
    }

    @Override
    public Wrapper put(String key, Wrapper value) {
        return null;
    }

    @Override
    public Wrapper remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Wrapper> m) {
    }

    @Override
    public void clear() {
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Wrapper> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Wrapper>> entrySet() {
        return null;
    }
}
