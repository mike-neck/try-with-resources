package org.mikeneck.twr;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.api.internal.NullOperator;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author mike
 */
public class InnerOperator extends Operator {

    private final Operator outer;

    public InnerOperator (Operator out) throws ConstructorException {
        super(out);
        this.outer = out;
    }

    public InnerOperator(Class<? extends Operator> which, ExecutionPatterns patterns)
            throws ConstructorException {
        super(which, patterns);
        this.outer = new NullOperator();
    }

    @Override
    public void execute() throws OperationalException {
        printNow();
        outer.execute();
        decision.execute();
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void open() throws OpenException {
        printNow();
        outer.open();
        decision.open();
    }

    @Override
    public void close() throws CloseException {
        printNow();
        decision.close();
        outer.close();
    }
}
