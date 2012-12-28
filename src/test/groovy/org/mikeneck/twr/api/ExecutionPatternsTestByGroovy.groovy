package org.mikeneck.twr.api

import org.mikeneck.twr.exception.CloseException
import org.mikeneck.twr.exception.ConstructorException
import org.mikeneck.twr.exception.OpenException
import org.mikeneck.twr.exception.OperationalException
import spock.lang.Specification
import static org.mikeneck.twr.api.ExecutionPatterns.*

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2012/12/28
 * Time: 1:31
 * To change this template use File | Settings | File Templates.
 */
class ExecutionPatternsTestByGroovy extends Specification {

    def "Exceptions thrown validly" () {
        when   :
        pattern.work(new MockOperator(MockOperator, pattern))

        then   :
        def e = thrown(exception)
        assert e.class == exception

        where  :
        pattern         | exception
        ON_CONSTRUCTOR  | ConstructorException
        ON_OPEN         | OpenException
        ON_EXECUTION    | OperationalException
        ON_CLOSE        | CloseException
    }

    static class MockOperator extends Operator {

        MockOperator (Class <? extends Operator> operator, ExecutionPatterns patterns) {
            super (operator, patterns)
            this.patterns.construction(this)
        }

        @Override
        void execute() throws OperationalException {
            this.patterns.execute(this)
        }

        @Override
        boolean isReady() {
            false
        }

        @Override
        void open() throws OpenException {
            this.patterns.open(this)
        }

        @Override
        void close() throws CloseException {
            this.patterns.close(this)
        }
    }
}
