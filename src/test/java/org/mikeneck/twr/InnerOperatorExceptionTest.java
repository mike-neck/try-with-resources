package org.mikeneck.twr;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mikeneck.twr.api.ExecutionPatterns;
import org.mikeneck.twr.exception.*;
import org.mikeneck.twr.util.DataPattern;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mikeneck.twr.api.ExecutionPatterns.*;

/**
 * @author mike
 */
@RunWith(Theories.class)
public class InnerOperatorExceptionTest {

    @Theory
    public void doOperations (DataPattern<ExecutionPatterns, Class<? extends ResourceException>> ptn) {
        try {
            InnerOperator operator = new InnerOperator(InnerOperator.class, ptn.condition());
            operator.open();
            operator.execute();
            operator.close();
            fail ("Exception should be thrown. But in this case " + ptn + ", exception isn't thrown.");
        } catch (ResourceException e) {
            assertThat(ptn + " expected ", ptn.result().equals(e.getClass()), is(true));
        }
    }

    @DataPoints
    @SuppressWarnings("unchecked")
    public static DataPattern<ExecutionPatterns, Class<? extends ResourceException>>[] datas =
            new DataPattern[] {
                    DataPattern.when(ON_CONSTRUCTOR).then(ConstructorException.class),
                    DataPattern.when(ON_OPEN)       .then(OpenException.class),
                    DataPattern.when(ON_EXECUTION)  .then(OperationalException.class),
                    DataPattern.when(ON_CLOSE)      .then(CloseException.class)
            };
}
