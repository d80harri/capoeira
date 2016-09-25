package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.criterions.IntegerColumnCriterion;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class ColumnCriterionTest {

    @Test
    public void test1() {
        IntegerColumnCriterion integerCC = new IntegerColumnCriterion("myProperty");
        Assertions.assertThat(integerCC.toHql()).isEqualTo("myProperty");
    }
}
