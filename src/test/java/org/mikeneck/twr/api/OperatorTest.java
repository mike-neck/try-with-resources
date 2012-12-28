package org.mikeneck.twr.api;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

import java.io.PrintStream;

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

    static class MockOperator extends Operator {
        public MockOperator(Class<? extends Operator> which, ExecutionPatterns patterns) {
            super(which, patterns);
        }

        @Override
        public void execute() throws OperationalException {}

        @Override
        public boolean isReady() { return false;}

        @Override
        public void open() throws OpenException {}

        @Override
        public void close() throws CloseException {}

        String delegateNow () {
            return now();
        }
    }
}
