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
package br.com.ppm.commons.collection;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Creates an Sequence of Integers, it can be used as a shortcut to IntStreams class.
 * This sequence is always a closed stream.
 *
 * @author pedrotoliveira
 */
public class Seq implements IntStream {

    private final IntStream internal;

    public Seq(int start, int end) {
        this.internal = IntStream.rangeClosed(start, end);
    }

    public static Integer[] arr(int start, int end) {
        return new Seq(start, end)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static Integer[] array(int start, int end) {
        return arr(start, end);
    }

    public static List<Integer> col(int start, int end) {
        return new Seq(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> collection(int start, int end) {
        return col(start, end);
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return internal.filter(predicate);
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return internal.map(mapper);
    }

    @Override
    public <U> Stream<U> mapToObj(IntFunction<? extends U> mapper) {
        return internal.mapToObj(mapper);
    }

    @Override
    public LongStream mapToLong(IntToLongFunction mapper) {
        return internal.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(IntToDoubleFunction mapper) {
        return internal.mapToDouble(mapper);
    }

    @Override
    public IntStream flatMap(IntFunction<? extends IntStream> mapper) {
        return internal.flatMap(mapper);
    }

    @Override
    public IntStream distinct() {
        return internal.distinct();
    }

    @Override
    public IntStream sorted() {
        return internal.sorted();
    }

    @Override
    public IntStream peek(IntConsumer action) {
        return internal.peek(action);
    }

    @Override
    public IntStream limit(long maxSize) {
        return internal.limit(maxSize);
    }

    @Override
    public IntStream skip(long n) {
        return internal.skip(n);
    }

    @Override
    public void forEach(IntConsumer action) {
        internal.forEach(action);
    }

    @Override
    public void forEachOrdered(IntConsumer action) {
        internal.forEachOrdered(action);
    }

    @Override
    public int[] toArray() {
        return internal.toArray();
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        return internal.reduce(identity, op);
    }

    @Override
    public OptionalInt reduce(IntBinaryOperator op) {
        return internal.reduce(op);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return internal.collect(supplier, accumulator, combiner);
    }

    @Override
    public int sum() {
        return internal.sum();
    }

    @Override
    public OptionalInt min() {
        return internal.min();
    }

    @Override
    public OptionalInt max() {
        return internal.max();
    }

    @Override
    public long count() {
        return internal.count();
    }

    @Override
    public OptionalDouble average() {
        return internal.average();
    }

    @Override
    public IntSummaryStatistics summaryStatistics() {
        return internal.summaryStatistics();
    }

    @Override
    public boolean anyMatch(IntPredicate predicate) {
        return internal.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(IntPredicate predicate) {
        return internal.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(IntPredicate predicate) {
        return internal.noneMatch(predicate);
    }

    @Override
    public OptionalInt findFirst() {
        return internal.findFirst();
    }

    @Override
    public OptionalInt findAny() {
        return internal.findAny();
    }

    @Override
    public LongStream asLongStream() {
        return internal.asLongStream();
    }

    @Override
    public DoubleStream asDoubleStream() {
        return internal.asDoubleStream();
    }

    @Override
    public Stream<Integer> boxed() {
        return internal.boxed();
    }

    @Override
    public IntStream sequential() {
        return internal.sequential();
    }

    @Override
    public IntStream parallel() {
        return internal.parallel();
    }

    @Override
    public IntStream unordered() {
        return internal.unordered();
    }

    @Override
    public IntStream onClose(Runnable closeHandler) {
        return internal.onClose(closeHandler);
    }

    @Override
    public void close() {
        internal.close();
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return internal.iterator();
    }

    @Override
    public Spliterator.OfInt spliterator() {
        return internal.spliterator();
    }

    @Override
    public boolean isParallel() {
        return internal.isParallel();
    }
}
