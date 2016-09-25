package net.d80harri.capoeira.dal.core.criterions;


import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterionTest {

    @Test
    public void test1() {
        IsGreaterThanCriterion<Integer> older18 = IsGreaterThanCriterion.create(new PersonAgeCriterion(), new IntegerConstantCriterion(18));
        IsEqualToCriterion<String> nameIsEqualToHarald = IsEqualToCriterion.create(new PersonNameCriterion(), new StringConstantCriterion("Harald"));
        AndCriterion andC = new AndCriterion(older18, nameIsEqualToHarald);
        Assertions.assertThat(andC.toHql()).isEqualTo("age > 18 and name = \"Harald\"");
    }

    private static class MyEntity {}

    private static class PersonNameCriterion extends StringColumnCriterion<MyEntity> {

        public PersonNameCriterion() {
            super("name");
        }
    }

    private static class PersonAgeCriterion extends IntegerColumnCriterion<MyEntity> {

        public PersonAgeCriterion() {
            super("age");
        }
    }
}