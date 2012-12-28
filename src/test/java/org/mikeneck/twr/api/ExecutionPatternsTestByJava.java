package org.mikeneck.twr.api;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mikeneck.twr.exception.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author mike
 */
@RunWith(Theories.class)
public class ExecutionPatternsTestByJava {

    public static class ExceptionNotHappened extends ResourceException {
        public ExceptionNotHappened(Object o) {
            super(o);
        }
    }

    public static class MockOperator extends Operator {
        public MockOperator(Class<? extends Operator> which, ExecutionPatterns patterns) {
            super(which, patterns);
        }
        @Override
        public void execute() throws OperationalException {
            this.patterns.execute(this);
        }
        @Override
        public boolean isReady() {
            return false;
        }
        @Override
        public void open() throws OpenException {
            this.patterns.open(this);
        }
        @Override
        public void close() throws CloseException {
            this.patterns.close(this);
        }
    }

    private static enum Regulations {
        CONSTRUCTOR {
            @Override
            Class<? extends ResourceException> expected() {
                return ConstructorException.class;
            }
            @Override
            ExecutionPatterns executePattern() {
                return ExecutionPatterns.ON_CONSTRUCTOR;
            }
        }, OPEN {
            @Override
            Class<? extends ResourceException> expected() {
                return OpenException.class;
            }
            @Override
            ExecutionPatterns executePattern() {
                return ExecutionPatterns.ON_OPEN;
            }
        }, OPERATION {
            @Override
            Class<? extends ResourceException> expected() {
                return OperationalException.class;
            }
            @Override
            ExecutionPatterns executePattern() {
                return ExecutionPatterns.ON_EXECUTION;
            }
        }, CLOSE {
            @Override
            Class<? extends ResourceException> expected() {
                return CloseException.class;
            }
            @Override
            ExecutionPatterns executePattern() {
                return ExecutionPatterns.ON_CLOSE;
            }
        };
        abstract Class <? extends ResourceException> expected ();
        abstract ExecutionPatterns executePattern();
    }

    @DataPoints
    public static Regulations[] regulations = Regulations.values();

    @Theory
    public void exceptionThrownValidly (Regulations regulation) {
        ExecutionPatterns ptn = regulation.executePattern();
        Operator operator = new MockOperator(MockOperator.class, ptn);
        ResourceException exception = new ResourceException(operator);
        try {
            ptn.work(operator);
        } catch (ResourceException e) {
            exception = e;
        }
        Class<? extends ResourceException> expected = regulation.expected();
        assertThat(
                ptn + "#work should throws " + expected,
                exception, is(instanceOf(expected)));
    }
}
