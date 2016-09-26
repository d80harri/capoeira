package net.d80harri.easydal.criterions;

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
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerColumnExpression(Object.class, "myProp"), new IntegerConstantExpression(Object.class, 5))).isEqualTo("myProp > 5");
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerConstantExpression(Object.class, 5), new IntegerColumnExpression(Object.class, "myProp"))).isEqualTo("5 > myProp");
    }

}
