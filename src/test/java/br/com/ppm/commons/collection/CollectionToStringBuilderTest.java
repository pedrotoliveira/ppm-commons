/*
 * Copyright (C) 2020.
 */
package br.com.ppm.commons.collection;

import java.util.Arrays;
import java.util.List;

import br.com.ppm.commons.collection.CollectionToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 * @author pedrotoliveira
 */
//@RunWith(Parameterized.class)
public class CollectionToStringBuilderTest {

    @Test
    public void testBuild() {
        List<String> collection = Arrays.asList("one", "two", "three");
        String toStringExpected = "[one, two, three]";
        String result = new CollectionToStringBuilder(collection).build();
        assertThat("toString of Collections should be equal to expected", result, equalTo(toStringExpected));
    }

}
