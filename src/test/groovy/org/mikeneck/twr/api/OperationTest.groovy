package org.mikeneck.twr.api

import org.junit.Test
import org.mikeneck.twr.exception.CloseException
import org.mikeneck.twr.exception.OpenException
import org.mikeneck.twr.exception.OperationalException

/**
 *
 * @author : mike
 * @since : 12/12/24
 */
class OperationTest {

    @Test
    void testBuildMessage () {
        def implement = new Implement()
        def message = implement.buildMessage('testBuildMessage')
        assert message == 'testBuildMessage method in class org.mikeneck.twr.api.OperationTest$Implement'
    }

    static class Implement extends Operation {
        @Override
        void execute() throws OperationalException {}

        @Override
        boolean isReady() {
            return false
        }

        @Override
        void open() throws OpenException {}

        @Override
        void close() throws CloseException {}
    }
}
