package org.mikeneck.twr.api;

import org.mikeneck.twr.exception.*;

/**
 * @author : mike
 * @since : 12/12/26
 */
public enum  ExecutionPatterns {

    ON_CONSTRUCTOR {
        @Override
        protected void work(Object by) throws ResourceException {
            throw new ConstructorException(by);
        }

        @Override
        public void construction(Object by) throws ConstructorException {
            try {
                this.work(by);
            } catch (ResourceException e) {
                throw ConstructorException.class.cast(e);
            }
        }
    }, ON_OPEN {
        @Override
        protected void work(Object by) throws ResourceException {
            throw new OpenException(by);
        }

        @Override
        public void open(Object by) throws OpenException {
            try {
                this.work(by);
            } catch (ResourceException e) {
                throw OpenException.class.cast(e);
            }
        }
    }, ON_EXECUTION {
        @Override
        protected void work(Object by) throws ResourceException {
            throw new OperationalException(by);
        }

        @Override
        public void execute(Object by) throws OperationalException {
            try {
                this.work(by);
            } catch (ResourceException e) {
                throw OperationalException.class.cast(e);
            }
        }
    }, ON_CLOSE {
        @Override
        protected void work(Object by) throws ResourceException {
            throw new CloseException(by);
        }

        @Override
        public void close(Object by) throws CloseException {
            try {
                work(by);
            } catch (ResourceException e) {
                throw CloseException.class.cast(e);
            }
        }
    };

    public void construction(Object by) throws ConstructorException {}

    public void open(Object by) throws OpenException {}

    public void execute(Object by) throws OperationalException {}

    public void close(Object by) throws CloseException {}

    abstract protected void work (Object by) throws ResourceException;
}
