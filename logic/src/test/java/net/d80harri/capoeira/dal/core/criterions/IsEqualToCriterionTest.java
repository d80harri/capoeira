package net.d80harri.capoeira.dal.core.criterions;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterionTest {
    @Rule
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnExpression("myProp"), new IntegerConstantExpression(5))).isEqualTo("myProp = 5");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerConstantExpression(5), new IntegerColumnExpression("myProp"))).isEqualTo("5 = myProp");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnExpression("myProp1"), new IntegerColumnExpression("myProp2"))).isEqualTo("myProp1 = myProp2");
        assertions.toHqlReturns(IsEqualToCriterion.create(new StringColumnExpression("myProp1"), new StringColumnExpression("myProp2"))).isEqualTo( "myProp1 = myProp2");
    }

}
