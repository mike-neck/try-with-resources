package org.mikeneck.twr.api;

import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.OpenException;

/**
 * @author : mike
 * @since : 12/12/24
 */
public interface Resource extends AutoCloseable {

    public void open () throws OpenException;

    @Override
    public void close() throws CloseException;
}
