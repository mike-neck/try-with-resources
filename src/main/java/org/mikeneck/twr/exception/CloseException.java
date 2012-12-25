package org.mikeneck.twr.exception;

/**
 * @author : mike
 * @since : 12/12/24
 */
public class CloseException extends ResourceException {

    private static final long serialVersionUID = -1691831479L;

    public CloseException(Object o) {
        super(o);
    }
}
