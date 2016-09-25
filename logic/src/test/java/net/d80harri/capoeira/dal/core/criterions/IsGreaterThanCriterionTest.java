package net.d80harri.capoeira.dal.core.criterions;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsGreaterThanCriterionTest {
    @Rule
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerColumnExpression("myProp"), new IntegerConstantExpression(5))).isEqualTo("myProp > 5");
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerConstantExpression(5), new IntegerColumnExpression("myProp"))).isEqualTo("5 > myProp");
    }

}
