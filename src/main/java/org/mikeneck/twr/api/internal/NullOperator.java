package org.mikeneck.twr.api.internal;

import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author mike
 */
public class NullOperator extends Operator {

    @SuppressWarnings("deprecation")
    public NullOperator () throws ConstructorException {
        super();
    }

    @Override
    public void execute() throws OperationalException {}

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void open() throws OpenException {}

    @Override
    public void close() throws CloseException {}
}
