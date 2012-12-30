package org.mikeneck.twr;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author mike
 */
public class InnerOperator extends Operator {

    public InnerOperator(Class<? extends Operator> which, ExecutionPatterns patterns)
            throws ConstructorException {
        super(which, patterns);
    }

    @Override
    public void execute() throws OperationalException {
        printNow();
        decision.execute();
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void open() throws OpenException {
        printNow();
        decision.open();
    }

    @Override
    public void close() throws CloseException {
        printNow();
        decision.close();
    }
}
