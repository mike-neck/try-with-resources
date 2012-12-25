package org.mikeneck.twr.api;

import org.mikeneck.twr.exception.OperationalException;

/**
 * @author : mike
 * @since : 12/12/24
 */
public interface Executable {

    public void execute () throws OperationalException;

    public boolean isReady ();
}
