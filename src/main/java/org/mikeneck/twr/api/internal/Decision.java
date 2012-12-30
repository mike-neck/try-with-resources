package org.mikeneck.twr.api.internal;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operation;
import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author mike
 */
public class Decision implements Operation {

    private final boolean classCondition;

    private final ExecutionPatterns pattern;

    private final Operator operator;

    public Decision(DecisionMaterial material) throws ConstructorException {
        this.operator = material.getOperator();
        this.classCondition = this.operator.getClass().equals(material.getWhich());
        this.pattern = material.getPatterns();

        if (workNow(ExecutionPatterns.ON_CONSTRUCTOR))
            pattern.construction(operator);
    }

    private boolean workNow (ExecutionPatterns ptn) {
        return classCondition && ptn.equals(pattern);
    }

    @Override
    public void execute() throws OperationalException {
        if (workNow(ExecutionPatterns.ON_EXECUTION))
            pattern.execute(operator);
    }

    @Override
    public boolean isReady() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void open() throws OpenException {
        if (workNow(ExecutionPatterns.ON_OPEN))
            pattern.open(operator);
    }

    @Override
    public void close() throws CloseException {
        if (workNow(ExecutionPatterns.ON_CLOSE))
            pattern.close(operator);
    }
}
