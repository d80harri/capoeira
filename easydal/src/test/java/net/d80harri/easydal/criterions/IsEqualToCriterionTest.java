package net.d80harri.easydal.criterions;

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
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnExpression(Object.class, "myProp"), new IntegerConstantExpression(Object.class, 5))).isEqualTo("myProp = 5");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerConstantExpression(Object.class, 5), new IntegerColumnExpression(Object.class, "myProp"))).isEqualTo("5 = myProp");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnExpression(Object.class, "myProp1"), new IntegerColumnExpression(Object.class, "myProp2"))).isEqualTo("myProp1 = myProp2");
        assertions.toHqlReturns(IsEqualToCriterion.create(new StringColumnExpression(Object.class, "myProp1"), new StringColumnExpression(Object.class, "myProp2"))).isEqualTo( "myProp1 = myProp2");
    }

}
