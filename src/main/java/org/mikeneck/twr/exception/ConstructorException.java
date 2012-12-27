package org.mikeneck.twr.exception;

/**
 * @author : mike
 * @since : 12/12/26
 */
public class ConstructorException extends ResourceException {

    private static final long serialVersionUID = -735136522L;

    public ConstructorException(Object o) {
        super(o);
    }
}
