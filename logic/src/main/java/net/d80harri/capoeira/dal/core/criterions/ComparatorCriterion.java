package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IExpression;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ComparatorCriterion<T> implements ICriterion {
    protected final IExpression<T> first;
    protected final IExpression<T> second;

    protected ComparatorCriterion(IExpression<T> first, IExpression<T> second) {
        this.first = first;
        this.second = second;
    }
    public String toHql() {
        return second.toHql() + " > " + first.toHql();
    }

}
