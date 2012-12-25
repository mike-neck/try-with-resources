package org.mikeneck.twr.exception;

/**
 * @author : mike
 * @since : 12/12/23
 */
public class ResourceException extends Exception {

    private static final long serialVersionUID = -255146189L;

    protected Object object;

    public ResourceException (Object o) {
        super();
        this.object = o;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder
                .append(getClass().getName())
                .append(" caused at ")
                .append(object)
                .append(";")
                .toString();
    }
}
