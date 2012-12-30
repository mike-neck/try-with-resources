package org.mikeneck.twr.api.util;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author mike
 */
public class MockOperator extends Operator {
    public MockOperator(Class<? extends Operator> which, ExecutionPatterns patterns)
            throws ConstructorException {
        super(which, patterns);
    }
    @Override
    public void execute() throws OperationalException {
        this.decision.execute();
    }
    @Override
    public boolean isReady() {
        return false;
    }
    @Override
    public void open() throws OpenException {
        this.decision.open();
    }
    @Override
    public void close() throws CloseException {
        this.decision.close();
    }

    public String delegateNow () {
        return now();
    }
}
