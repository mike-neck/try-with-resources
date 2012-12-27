package org.mikeneck.twr.api;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author : mike
 * @since : 12/12/25
 */
public abstract class Operator implements Operation {

    protected final Class <? extends Operator> which;

    protected final ExecutionPatterns patterns;

    public Operator (Class<? extends Operator> which, ExecutionPatterns patterns) {
        this.which = which;
        this.patterns = patterns;
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
}
