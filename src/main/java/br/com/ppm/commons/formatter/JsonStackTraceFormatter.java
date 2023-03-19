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
package br.com.ppm.commons.formatter;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Json Stack Trace Formatter
 *
 * @author pedrotoliveira
 */
final class JsonStackTraceFormatter implements StackTracerFormatter {

    @Override
    public String formatToString(final Throwable throwable) {
        Objects.requireNonNull(throwable, "Throwable should not be null");
        var objectBuilder = Json.createObjectBuilder();
        var cause = throwable;
        AtomicInteger counter = new AtomicInteger();
        while (cause != null) {
            var index = counter.getAndIncrement();
            objectBuilder.add(String.format("exception-%d", index), cause.toString());
            objectBuilder.add(String.format("message-%d", index), cause.getMessage());
            objectBuilder.add(String.format("localizedMessage-%d", index), cause.getMessage());
            objectBuilder.add(String.format("stackTrace-%d", index), stackJson(cause));
            cause = cause.getCause();
        }
        return objectBuilder.build().toString();
    }

    private static JsonObjectBuilder stackJson(Throwable cause) {
        var objectBuilder = Json.createObjectBuilder();
        var elements = cause.getStackTrace();
        for (int index = 0; index < elements.length; index++) {
            objectBuilder.add(String.format("%d", index), elements[index].toString());
        }
        return objectBuilder;
    }

}
