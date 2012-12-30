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
class OuterOperatorSpec extends Specification {

    @Unroll
    def "OuterOperator throws #exception on #pattern" () {
        when   :
        def operator = new OuterOperator(OuterOperator, pattern)
        operator.open()
        operator.execute()
        operator.close()

        then   :
        def ex = thrown(exception)
        assert ex != null

        where  :
        pattern         | exception
        ON_CONSTRUCTOR  | ConstructorException
        ON_OPEN         | OpenException
        ON_EXECUTION    | OperationalException
        ON_CLOSE        | CloseException
    }
}
