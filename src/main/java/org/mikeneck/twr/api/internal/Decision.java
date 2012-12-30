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

    @Deprecated
    protected Decision () {
        this (false);
    }

    @Deprecated
    private Decision (boolean classCondition) {
        this.classCondition = classCondition;
        this.pattern = null;
        this.operator = null;
    }

    public Decision (Decision decision, Operator op) throws ConstructorException {
        this (decision.pattern, decision.operator, op.getClass());
    }

    public Decision(DecisionMaterial material) throws ConstructorException {
        this (material.getPatterns(), material.getOperator(), material.getWhich());
    }

    private Decision (ExecutionPatterns pattern, Operator operator, Class<? extends Operator> which)
            throws ConstructorException {
        this.classCondition = operator.getClass().equals(which);
        this.pattern = pattern;
        this.operator = operator;

        construct();
    }

    private void construct() throws ConstructorException {
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
        return false;
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

    /**
     * @author mike
     */
    public static class NoDecision extends Decision {
        public NoDecision () {super();}
    }
}
