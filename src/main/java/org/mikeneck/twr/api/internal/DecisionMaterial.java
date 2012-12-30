package org.mikeneck.twr.api.internal;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operator;

/**
 * @author mike
 */
public class DecisionMaterial {

    private final Class <? extends Operator> which;

    private final ExecutionPatterns patterns;

    private final Operator operator;

    public DecisionMaterial(Class<? extends Operator> which,
                            ExecutionPatterns patterns,
                            Operator operator) {
        this.which = which;
        this.patterns = patterns;
        this.operator = operator;
    }

    public Class<? extends Operator> getWhich() {
        return which;
    }

    public ExecutionPatterns getPatterns() {
        return patterns;
    }

    public Operator getOperator() {
        return operator;
    }
}
