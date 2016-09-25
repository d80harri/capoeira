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
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerColumnCriterion("myProp"), new IntegerConstantCriterion(5))).isEqualTo("myProp > 5");
        assertions.toHqlReturns(IsGreaterThanCriterion.create(new IntegerConstantCriterion(5), new IntegerColumnCriterion("myProp"))).isEqualTo("5 > myProp");
    }

}
