package org.mikeneck.twr.exception

import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 *
 * @author : mike
 * @since : 12/12/24
 */
@RunWith (Enclosed)
class ExceptionsTest {

    static class OpenExceptionTest {
        @Test
        void testToString () {
            def exception = new OpenException(this)
            assert exception.toString().contains('OpenException caused at')
        }
    }

    static class CloseExceptionTest {
        @Test
        void testToString () {
            def exception = new CloseException(this)
            assert exception.toString().contains('CloseException caused at')
        }
    }

    static class OperationalExceptionTest {
        @Test
        void testToString () {
            def exception = new OperationalException(this)
            assert exception.toString().contains('OperationalException caused at ')
        }
    }
}
