package br.com.ppm.commons;

import br.com.ppm.commons.model.Order;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepthControllerTest {

    @Test
    public void testIsAllowed() {
        assertThat("isAllowed should be true when called a single time",
                DepthController.isAllowed(new Order(1)), is(true));
    }

    @Test
    public void testIsAllowedWhenCall49Times() {
        for (int i = 0; i < 50; i++) {
            assertThat(String.format("isAllowed should be true when called %d times", i),
                    DepthController.isAllowed(new Order(2)), is(true));
        }
    }
}