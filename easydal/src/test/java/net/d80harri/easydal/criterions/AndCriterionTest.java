package net.d80harri.easydal.criterions;


import net.d80harri.easydal.ICriterion;
import org.junit.Rule;
import org.junit.Test;

import java.util.function.Function;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterionTest {
    @Rule
    public final CriterionTestRule assertions = new CriterionTestRule();

    @Test
    public void test1() {
        TestPersonCB cb = new TestPersonCB();

        assertions.toHqlReturns(cb.and(cb.gt(cb.age, cb.integer(18)), cb.eq(cb.name, cb.string("Harald")))).isEqualTo("age > 18 and name = \"Harald\"");
        assertions.toHqlReturns(cb.and(cb.gt(cb.age, cb.integer(18)), cb.lt(cb.age, cb.integer(66)))).isEqualTo("age > 18 and age < 66");
        assertions.toHqlReturns(cb.and(cb.eq(cb.name, cb.string("Harald")), cb.address.with(acb -> acb.eq(acb.street, acb.string("MyStreet"))))).isEqualTo("name = \"Harald\" and address.street = \"MyStreet\"");
    }

    private static class TestPerson {}
    private static class TestAddress {}

    private static class TestPersonCB extends CriterionBuilder<TestPerson> {

        public TestPersonCB() {
            super(TestPerson.class);
        }

        public final Join<TestPerson, TestAddress, TestAddressCB> address = new Join<>(TestPerson.class, "address", new TestAddressCB());

        public final IntegerColumnExpression<TestPerson> age = new IntegerColumnExpression<>(TestPerson.class, "age");
        public final StringColumnExpression<TestPerson> name = new StringColumnExpression<>(TestPerson.class, "name");

    }

    private static class TestAddressCB extends CriterionBuilder<TestAddress> {

        public TestAddressCB() {
            super(TestAddress.class);
        }

        public final StringColumnExpression<TestAddress> street = new StringColumnExpression<>(TestAddress.class, "street");
    }

}