package org.mikeneck.twr;

import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.api.Operator;
import org.mikeneck.twr.exception.ResourceException;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author mike
 */
public class TryWithResources implements Runnable {

    private static final List<Class<? extends Operator>> OPERATORS =
            Arrays.asList(OuterOperator.class, InnerOperator.class);

    public static void main (String... args) {
        TryWithResources tryWithResources = new TryWithResources();
        tryWithResources.run();
    }

    @Override
    public void run() {
        for (ExecutionPatterns pattern : ExecutionPatterns.values()) {
            for (Class<? extends Operator> operatorClass : OPERATORS) {
                printCondition (operatorClass, pattern);
                ResourceException exception = execute (operatorClass, pattern);
                printResult (operatorClass, pattern, exception);
                out.println();
            }
        }
    }

    private void printResult(Class<? extends Operator> operatorClass, ExecutionPatterns pattern, ResourceException exception) {
        StringBuilder builder = new StringBuilder();
        builder .append("If ")
                .append(operatorClass)
                .append(" throws Exception on ")
                .append(pattern)
                .append(", [")
                .append(exception)
                .append("] is thrown.");
        out.println(builder.toString());
    }

    private ResourceException execute(Class<? extends Operator> operatorClass, ExecutionPatterns pattern) {
        ResourceException exception = new ResourceException(this);
        try (
                OuterOperator outer = new OuterOperator(operatorClass, pattern);
                InnerOperator inner = new InnerOperator(outer)) {
            inner.open();
            inner.execute();
            inner.close();
        } catch (ResourceException e) {
            exception = e;
        }
        return exception;
    }

    private void printCondition(Class<? extends Operator> operatorClass, ExecutionPatterns pattern) {
        StringBuilder builder = new StringBuilder();
        builder .append("If ")
                .append(operatorClass)
                .append(" throws Exception on ")
                .append(pattern);
        out.println(builder.toString());
    }
}
