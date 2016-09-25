package net.d80harri.capoeira.dal.core.criterions;


import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterionTest {
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        assertions.toHqlReturns(new AndCriterion(IsGreaterThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(18)), IsEqualToCriterion.create(new PersonNameExpression(), new StringConstantExpression("Harald")))).isEqualTo("age > 18 and name = \"Harald\"");
        assertions.toHqlReturns(new AndCriterion(IsGreaterThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(18)), IsLessThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(66)))).isEqualTo("age > 18 and age < 66");
    }

    private static class MyEntity {}

    private static class PersonNameExpression extends StringColumnExpression<MyEntity> {

        public PersonNameExpression() {
            super("name");
        }
    }

    private static class PersonAgeExpression extends IntegerColumnExpression<MyEntity> {

        public PersonAgeExpression() {
            super("age");
        }
    }
}