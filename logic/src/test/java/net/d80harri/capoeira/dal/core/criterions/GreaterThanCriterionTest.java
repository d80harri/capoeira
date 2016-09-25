package net.d80harri.capoeira.dal.core.criterions;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by d80harri on 25.09.16.
 */
@RunWith(Parameterized.class)
public class GreaterThanCriterionTest {
    private GreaterThanCriterion criterion;
    private String result;

    public GreaterThanCriterionTest(GreaterThanCriterion criterion, String result) {
        this.criterion = criterion;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        ListOfArray result = new ListOfArray();
        result.add(GreaterThanCriterion.create(new IntegerColumnCriterion("myProp"), new IntegerConstantCriterion(5)), "myProp > 5");
        result.add(GreaterThanCriterion.create(new IntegerConstantCriterion(5), new IntegerColumnCriterion("myProp")), "5 > myProp");
        return result;
    }

    @Test
    public void test1() {
        Assertions.assertThat(criterion.toHql()).isEqualTo(result);
    }

    private static class ListOfArray<T> implements  Iterable<T[]>{
        private List<T[]> value = new ArrayList<>();


        @Override
        public Iterator<T[]> iterator() {
            return value.iterator();
        }

        public void add(T... values) {
            value.add(values);
        }
    }
}
