package org.mikeneck.twr

import org.mikeneck.twr.exception.CloseException
import org.mikeneck.twr.exception.ConstructorException
import org.mikeneck.twr.exception.OpenException
import org.mikeneck.twr.exception.OperationalException
import spock.lang.Specification
import spock.lang.Unroll

import static org.mikeneck.twr.api.ExecutionPatterns.*

/**
 * @author mike
 */
class InnerOperatorSpec extends Specification {

    @Unroll
    def 'InnerOperator throws #exception on #pattern' () {
        when  :
        def operator = new InnerOperator(InnerOperator, pattern)
        operator.open()
        operator.execute()
        operator.close()

        then  :
        def ex = thrown(exception)
        assert ex.class == exception

        where :
        pattern        | exception
        ON_CONSTRUCTOR | ConstructorException
        ON_OPEN        | OpenException
        ON_EXECUTION   | OperationalException
        ON_CLOSE       | CloseException
    }

    @Unroll
    def 'Exception [#exception] caused by InnerOperator on #pattern' () {
        when  :
        def outer = new OuterOperator(InnerOperator, pattern)
        def operator = new InnerOperator(outer)
        operator.open()
        operator.execute()
        operator.close()

        then  :
        def ex = thrown(exception)
        assert ex.object.class == InnerOperator

        where :
        pattern        | exception
        ON_CONSTRUCTOR | ConstructorException
        ON_OPEN        | OpenException
        ON_EXECUTION   | OperationalException
        ON_CLOSE       | CloseException
    }
}
