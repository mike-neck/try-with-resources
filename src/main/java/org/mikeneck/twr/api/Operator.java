package org.mikeneck.twr.api;

import org.mikeneck.twr.api.internal.Decision;
import org.mikeneck.twr.api.internal.DecisionMaterial;
import org.mikeneck.twr.exception.ConstructorException;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author : mike
 * @since : 12/12/25
 */
public abstract class Operator implements Operation {

    protected final Decision decision;

    @Deprecated
    protected Operator () throws ConstructorException {
        this.decision = new Decision.NoDecision();
    }

    public Operator (Operator operator) throws ConstructorException {
        Decision dec = operator.getDecision();
        DecisionMaterial material = new DecisionMaterial(dec.getCausedClass(), dec.getPattern(), this);
        this.decision = new Decision(material);
    }

    public Operator (Class<? extends Operator> which, ExecutionPatterns patterns)
            throws ConstructorException {
        DecisionMaterial material = new DecisionMaterial(which, patterns, this);
        decision = new Decision(material);
    }

    protected String now () {
        return now(3);
    }

    protected String now (int index) {
        Thread thread = Thread.currentThread();
        List<StackTraceElement> elements = Arrays.asList(thread.getStackTrace());
        StackTraceElement element = elements.get(1 + index);
        StringBuilder builder = new StringBuilder();
        return builder
                .append(element.getMethodName())
                .append(" method in ")
                .append(element.getClassName())
                .toString();
    }

    protected void printNow () {
        out.println(now());
    }

    private static class CallIndex {
        private int index = 1;
    }

    public Decision getDecision() {
        return decision;
    }
}
