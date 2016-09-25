package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsLessThanCriterion<T> extends ComparatorCriterion<T> {

    private IsLessThanCriterion(IComparableCriterion<T> left, IComparableCriterion<T> right) {
        super(left, right);
    }
    public String toHql() {
        return first.toHql() + " < " + second.toHql();
    }

    public static <T> IsLessThanCriterion<T> create(IComparableCriterion<T> left, IComparableCriterion<T> right) {
        return new IsLessThanCriterion<T>(left, right);
    }
}
