package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterion<T> extends ComparatorCriterion<T> {

    private IsEqualToCriterion(IComparableCriterion<T> left, IComparableCriterion<T> right) {
        super(left, right);
    }
    public String toHql() {
        return first.toHql() + " = " + second.toHql();
    }

    public static <T> IsEqualToCriterion<T> create(IComparableCriterion<T> left, IComparableCriterion<T> right) {
        return new IsEqualToCriterion<T>(left, right);
    }
}
