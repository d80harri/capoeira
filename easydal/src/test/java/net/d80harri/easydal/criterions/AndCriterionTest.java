package net.d80harri.easydal.criterions;


import net.d80harri.easydal.ICriterion;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterionTest {
    @Rule
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        assertions.toHqlReturns(new AndCriterion(TestPerson.class, IsGreaterThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(TestPerson.class, 18)), IsEqualToCriterion.create(new PersonNameExpression(), new StringConstantExpression(TestPerson.class, "Harald")))).isEqualTo("age > 18 and name = \"Harald\"");
        assertions.toHqlReturns(new AndCriterion(TestPerson.class, IsGreaterThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(TestPerson.class, 18)), IsLessThanCriterion.create(new PersonAgeExpression(), new IntegerConstantExpression(TestPerson.class, 66)))).isEqualTo("age > 18 and age < 66");
        assertions.toHqlReturns(new AndCriterion(TestPerson.class, IsEqualToCriterion.create(new PersonNameExpression(), new StringConstantExpression(TestPerson.class, "Harald")), new PersonAddressCriterion(IsEqualToCriterion.create(new AddressStreetExpression(), new StringConstantExpression(TestAddress.class, "MyStreet"))))).isEqualTo("name = \"Harald\" and address.name = \"MyStreet\"");
    }

    private static class TestPerson {}
    private static class TestAddress {}

    private static class PersonNameExpression extends StringColumnExpression<TestPerson> {

        public PersonNameExpression() {
            super(TestPerson.class, "name");
        }
    }

    private static class PersonAgeExpression extends IntegerColumnExpression<TestPerson> {

        public PersonAgeExpression() {
            super(TestPerson.class, "age");
        }
    }

    public static class PersonAddressCriterion extends ToOneCriterion<TestPerson, TestAddress> {

        public PersonAddressCriterion(ICriterion<TestAddress> subExpression) {
            super(TestPerson.class, "address", subExpression);
        }
    }

    private static class AddressStreetExpression extends StringColumnExpression<TestAddress> {

        public AddressStreetExpression() {
            super(TestAddress.class, "name");
        }
    }
}