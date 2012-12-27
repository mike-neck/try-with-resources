package org.mikeneck.twr.api;

import org.mikeneck.twr.exception.CloseException;
import org.mikeneck.twr.exception.ConstructorException;
import org.mikeneck.twr.exception.OpenException;
import org.mikeneck.twr.exception.OperationalException;

/**
 * @author : mike
 * @since : 12/12/26
 */
public enum  ExecutionPatterns implements Operation {

    ON_CONSTRUCTOR {
        @Override
        public void execute() throws OperationalException {
            // TODO auto generated body

        }

        @Override
        public boolean isReady() {
            // TODO auto generated body
            return false;
        }

        @Override
        public void open() throws OpenException {
            // TODO auto generated body

        }

        @Override
        public void close() throws CloseException {
            // TODO auto generated body

        }

        @Override
        void construction() throws ConstructorException {
            // TODO auto generated body

        }
    }, ON_OPEN {
        @Override
        public void execute() throws OperationalException {
            // TODO auto generated body

        }

        @Override
        public boolean isReady() {
            // TODO auto generated body
            return false;
        }

        @Override
        public void open() throws OpenException {
            // TODO auto generated body

        }

        @Override
        public void close() throws CloseException {
            // TODO auto generated body

        }

        @Override
        void construction() throws ConstructorException {
            // TODO auto generated body

        }
    }, ON_EXECUTION {
        @Override
        public void execute() throws OperationalException {
            // TODO auto generated body

        }

        @Override
        public boolean isReady() {
            // TODO auto generated body
            return false;
        }

        @Override
        public void open() throws OpenException {
            // TODO auto generated body

        }

        @Override
        public void close() throws CloseException {
            // TODO auto generated body

        }

        @Override
        void construction() throws ConstructorException {
            // TODO auto generated body

        }
    }, ON_CLOSE {
        @Override
        public void execute() throws OperationalException {
            // TODO auto generated body

        }

        @Override
        public boolean isReady() {
            // TODO auto generated body
            return false;
        }

        @Override
        public void open() throws OpenException {
            // TODO auto generated body

        }

        @Override
        public void close() throws CloseException {
            // TODO auto generated body

        }

        @Override
        void construction() throws ConstructorException {
            // TODO auto generated body

        }
    };

    abstract void construction () throws ConstructorException;
}
