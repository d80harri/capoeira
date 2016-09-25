package net.d80harri.capoeira.dal.core.criterions;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterionTest {
    @Rule
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnCriterion("myProp"), new IntegerConstantCriterion(5))).isEqualTo("myProp = 5");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerConstantCriterion(5), new IntegerColumnCriterion("myProp"))).isEqualTo("5 = myProp");
        assertions.toHqlReturns(IsEqualToCriterion.create(new IntegerColumnCriterion("myProp1"), new IntegerColumnCriterion("myProp2"))).isEqualTo("myProp1 = myProp2");
        assertions.toHqlReturns(IsEqualToCriterion.create(new StringColumnCriterion("myProp1"), new StringColumnCriterion("myProp2"))).isEqualTo( "myProp1 = myProp2");
    }

}
