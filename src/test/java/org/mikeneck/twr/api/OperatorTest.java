package org.mikeneck.twr.api;

import org.junit.Test;
import org.mikeneck.twr.api.util.MockOperator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author : mike
 * @since : 12/12/25
 */
public class OperatorTest {

    @Test
    public void testMethodName () {
        MockOperator operator = new MockOperator(null, null);
        assertThat(operator.delegateNow(),
                is("testMethodName method in org.mikeneck.twr.api.OperatorTest"));
    }
}
