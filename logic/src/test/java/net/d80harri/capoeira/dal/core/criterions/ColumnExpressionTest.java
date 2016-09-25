package net.d80harri.capoeira.dal.core.criterions;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class ColumnExpressionTest {

    @Test
    public void test1() {
        IntegerColumnExpression integerCC = new IntegerColumnExpression("myProperty");
        Assertions.assertThat(integerCC.toHql()).isEqualTo("myProperty");
    }
}
