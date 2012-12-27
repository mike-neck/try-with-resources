package org.mikeneck.twr.api;

import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author : mike
 * @since : 12/12/26
 */
public enum  ExecutionPatterns {

    ON_CONSTRUCTOR {
        @Override
        public void execute(Class <? extends Operator> which) throws OperationalException {
            // TODO auto generated body

        }

        @Override
        public boolean isReady(Class <? extends Operator> which) {
            // TODO auto generated body
            return false;
        }

        @Override
        public void open(Class <? extends Operator> which) throws OpenException {
            // TODO auto generated body

        }

        @Override
        public void close(Class <? extends Operator> which) throws CloseException {
            // TODO auto generated body

        }

        @Override
        public void construction(Class<? extends Operator> which) throws ConstructorException {
            // TODO auto generated body

        }
    }, ON_OPEN {
        @Override
        public void close(Class<? extends Operator> which) throws CloseException {
            // TODO auto generated body
        }

        @Override
        public void construction(Class<? extends Operator> which) throws ConstructorException {
            // TODO auto generated body
        }

        @Override
        public void execute(Class<? extends Operator> which) throws OperationalException {
            // TODO auto generated body
        }

        @Override
        public boolean isReady(Class<? extends Operator> which) {
            return false;  // TODO auto generated body
        }

        @Override
        public void open(Class<? extends Operator> which) throws OpenException {
            // TODO auto generated body
        }
    }, ON_EXECUTION {
        @Override
        public void close(Class<? extends Operator> which) throws CloseException {
            // TODO auto generated body
        }

        @Override
        public void construction(Class<? extends Operator> which) throws ConstructorException {
            // TODO auto generated body
        }

        @Override
        public void execute(Class<? extends Operator> which) throws OperationalException {
            // TODO auto generated body
        }

        @Override
        public boolean isReady(Class<? extends Operator> which) {
            return false;  // TODO auto generated body
        }

        @Override
        public void open(Class<? extends Operator> which) throws OpenException {
            // TODO auto generated body
        }
    }, ON_CLOSE {
        @Override
        public void close(Class<? extends Operator> which) throws CloseException {
            // TODO auto generated body
        }

        @Override
        public void construction(Class<? extends Operator> which) throws ConstructorException {
            // TODO auto generated body
        }

        @Override
        public void execute(Class<? extends Operator> which) throws OperationalException {
            // TODO auto generated body
        }

        @Override
        public boolean isReady(Class<? extends Operator> which) {
            return false;  // TODO auto generated body
        }

        @Override
        public void open(Class<? extends Operator> which) throws OpenException {
            // TODO auto generated body
        }
    };

    abstract public void construction(Class<? extends Operator> which) throws ConstructorException;

    abstract public void execute(Class <? extends Operator> which) throws OperationalException;

    abstract public boolean isReady(Class <? extends Operator> which);

    abstract public void open(Class <? extends Operator> which) throws OpenException;

    abstract public void close(Class <? extends Operator> which) throws CloseException;
}
