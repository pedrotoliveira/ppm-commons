/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.array;

import br.com.ppm.commons.ToStringBuilder;
import br.com.ppm.commons.annotation.ToStringStyle;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Array ToStringBuilder
 *
 * @author pedrotoliveira
 */
public final class ArrayToStringBuilder implements ToStringBuilder {

    private static final int PAGE_SIZE = 15;
    private final Stream<Object> arrayStream;

    public ArrayToStringBuilder(Object... array) {
        this.arrayStream = Arrays.stream(array);
    }

    @Override
    public String build(boolean ignoreSuperType, ToStringStyle.Style style) {
        return null;
    }
}
