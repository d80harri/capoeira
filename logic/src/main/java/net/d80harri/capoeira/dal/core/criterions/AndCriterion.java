package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterion<T> implements ICriterion<T> {
    private final ICriterion<T> and1;
    private final ICriterion<T> and2;

    public AndCriterion(ICriterion<T> and1, ICriterion<T> and2) {
        this.and1 = and1;
        this.and2 = and2;
    }

    @Override
    public String toHql() {
        return and1.toHql() + " and " + and2.toHql();
    }
}
