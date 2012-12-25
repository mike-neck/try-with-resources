package org.mikeneck.twr.api;

import static java.lang.System.out;

/**
 * @author : mike
 * @since : 12/12/24
 */
public abstract class Operation implements Executable, Resource {

    protected void now (String methodName) {
        String message = buildMessage(methodName);
        out.println (message);
    }

    String buildMessage(String methodName) {
        StringBuilder builder = new StringBuilder();
        return builder.append(methodName)
                .append(" method in ")
                .append(getClass())
                .toString();
    }
}
