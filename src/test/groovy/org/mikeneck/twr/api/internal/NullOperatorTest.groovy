package org.mikeneck.twr.api.internal

import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2012/12/30
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
class NullOperatorTest {

    @Test
    void nullOperation () {
        def operator = new NullOperator()
        operator.open()
        operator.execute()
        operator.close()
        assert true
    }
}
