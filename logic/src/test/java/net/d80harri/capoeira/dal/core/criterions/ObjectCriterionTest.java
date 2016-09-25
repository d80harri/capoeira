package net.d80harri.capoeira.dal.core.criterions;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by d80harri on 25.09.16.
 */
public class ObjectCriterionTest {

    @Test
    public void test1() {
        Assertions.fail("NYI");
    }

    private static interface PersonQuery {}

    private static class PersonNameCriterion extends StringColumnCriterion implements PersonQuery {

        public PersonNameCriterion() {
            super("name");
        }
    }

    private static class PersonAgeCriterion extends IntegerColumnCriterion implements PersonQuery {

        public PersonAgeCriterion() {
            super("age");
        }
    }
}
