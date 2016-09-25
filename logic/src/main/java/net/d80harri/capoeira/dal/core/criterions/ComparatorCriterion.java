package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ComparatorCriterion<T> implements ICriterion {
    protected final IComparableCriterion<T> first;
    protected final IComparableCriterion<T> second;

    protected ComparatorCriterion(IComparableCriterion<T> first, IComparableCriterion<T> second) {
        this.first = first;
        this.second = second;
    }
    public String toHql() {
        return second.toHql() + " > " + first.toHql();
    }

}
