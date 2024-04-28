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
 * @version $Id: $Id
 */
public class Seq implements IntStream {

    private final IntStream internal;

    /**
     * <p>Constructor for Seq.</p>
     *
     * @param start a int.
     * @param end a int.
     */
    public Seq(int start, int end) {
        this.internal = IntStream.rangeClosed(start, end);
    }

    /**
     * <p>arr.</p>
     *
     * @param start a int.
     * @param end a int.
     * @return an array of {@link java.lang.Integer} objects.
     */
    public static Integer[] arr(int start, int end) {
        return new Seq(start, end)
                .boxed()
                .toArray(Integer[]::new);
    }

    /**
     * <p>array.</p>
     *
     * @param start a int.
     * @param end a int.
     * @return an array of {@link java.lang.Integer} objects.
     */
    public static Integer[] array(int start, int end) {
        return arr(start, end);
    }

    /**
     * <p>col.</p>
     *
     * @param start a int.
     * @param end a int.
     * @return a {@link java.util.List} object.
     */
    public static List<Integer> col(int start, int end) {
        return new Seq(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * <p>collection.</p>
     *
     * @param start a int.
     * @param end a int.
     * @return a {@link java.util.List} object.
     */
    public static List<Integer> collection(int start, int end) {
        return col(start, end);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream filter(IntPredicate predicate) {
        return internal.filter(predicate);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return internal.map(mapper);
    }

    /** {@inheritDoc} */
    @Override
    public <U> Stream<U> mapToObj(IntFunction<? extends U> mapper) {
        return internal.mapToObj(mapper);
    }

    /** {@inheritDoc} */
    @Override
    public LongStream mapToLong(IntToLongFunction mapper) {
        return internal.mapToLong(mapper);
    }

    /** {@inheritDoc} */
    @Override
    public DoubleStream mapToDouble(IntToDoubleFunction mapper) {
        return internal.mapToDouble(mapper);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream flatMap(IntFunction<? extends IntStream> mapper) {
        return internal.flatMap(mapper);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream distinct() {
        return internal.distinct();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream sorted() {
        return internal.sorted();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream peek(IntConsumer action) {
        return internal.peek(action);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream limit(long maxSize) {
        return internal.limit(maxSize);
    }

    /** {@inheritDoc} */
    @Override
    public IntStream skip(long n) {
        return internal.skip(n);
    }

    /** {@inheritDoc} */
    @Override
    public void forEach(IntConsumer action) {
        internal.forEach(action);
    }

    /** {@inheritDoc} */
    @Override
    public void forEachOrdered(IntConsumer action) {
        internal.forEachOrdered(action);
    }

    /** {@inheritDoc} */
    @Override
    public int[] toArray() {
        return internal.toArray();
    }

    /** {@inheritDoc} */
    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        return internal.reduce(identity, op);
    }

    /** {@inheritDoc} */
    @Override
    public OptionalInt reduce(IntBinaryOperator op) {
        return internal.reduce(op);
    }

    /** {@inheritDoc} */
    @Override
    public <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        return internal.collect(supplier, accumulator, combiner);
    }

    /** {@inheritDoc} */
    @Override
    public int sum() {
        return internal.sum();
    }

    /** {@inheritDoc} */
    @Override
    public OptionalInt min() {
        return internal.min();
    }

    /** {@inheritDoc} */
    @Override
    public OptionalInt max() {
        return internal.max();
    }

    /** {@inheritDoc} */
    @Override
    public long count() {
        return internal.count();
    }

    /** {@inheritDoc} */
    @Override
    public OptionalDouble average() {
        return internal.average();
    }

    /** {@inheritDoc} */
    @Override
    public IntSummaryStatistics summaryStatistics() {
        return internal.summaryStatistics();
    }

    /** {@inheritDoc} */
    @Override
    public boolean anyMatch(IntPredicate predicate) {
        return internal.anyMatch(predicate);
    }

    /** {@inheritDoc} */
    @Override
    public boolean allMatch(IntPredicate predicate) {
        return internal.allMatch(predicate);
    }

    /** {@inheritDoc} */
    @Override
    public boolean noneMatch(IntPredicate predicate) {
        return internal.noneMatch(predicate);
    }

    /** {@inheritDoc} */
    @Override
    public OptionalInt findFirst() {
        return internal.findFirst();
    }

    /** {@inheritDoc} */
    @Override
    public OptionalInt findAny() {
        return internal.findAny();
    }

    /** {@inheritDoc} */
    @Override
    public LongStream asLongStream() {
        return internal.asLongStream();
    }

    /** {@inheritDoc} */
    @Override
    public DoubleStream asDoubleStream() {
        return internal.asDoubleStream();
    }

    /** {@inheritDoc} */
    @Override
    public Stream<Integer> boxed() {
        return internal.boxed();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream sequential() {
        return internal.sequential();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream parallel() {
        return internal.parallel();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream unordered() {
        return internal.unordered();
    }

    /** {@inheritDoc} */
    @Override
    public IntStream onClose(Runnable closeHandler) {
        return internal.onClose(closeHandler);
    }

    /** {@inheritDoc} */
    @Override
    public void close() {
        internal.close();
    }

    /** {@inheritDoc} */
    @Override
    public PrimitiveIterator.OfInt iterator() {
        return internal.iterator();
    }

    /** {@inheritDoc} */
    @Override
    public Spliterator.OfInt spliterator() {
        return internal.spliterator();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isParallel() {
        return internal.isParallel();
    }
}
