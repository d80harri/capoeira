package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsGreaterThanCriterion<T> implements ICriterion {
    private IComparableCriterion<T> smaller;
    private IComparableCriterion<T> greater;

    private IsGreaterThanCriterion(IComparableCriterion<T> greater, IComparableCriterion<T> smaller) {
        this.smaller = smaller;
        this.greater = greater;
    }
    public String toHql() {
        return greater.toHql() + " > " + smaller.toHql();
    }

    public static <T> IsGreaterThanCriterion<T> create(IComparableCriterion<T> greater, IComparableCriterion<T> smaller) {
        return new IsGreaterThanCriterion<T>(greater, smaller);
    }
}
