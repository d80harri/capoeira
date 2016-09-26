package net.d80harri.easydal.criterions;

import net.d80harri.easydal.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterion<T> extends BaseCriterion<T> {
    private final ICriterion<T> and1;
    private final ICriterion<T> and2;

    public AndCriterion(Class<T> entityType, ICriterion<T> and1, ICriterion<T> and2) {
        super(entityType);
        this.and1 = and1;
        this.and2 = and2;
    }

    @Override
    public String toHql() {
        return and1.toHql() + " and " + and2.toHql();
    }
}
