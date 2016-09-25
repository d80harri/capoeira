package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class AndCriterion implements ICriterion {
    private final IsGreaterThanCriterion and1;
    private final IsEqualToCriterion<String> and2;

    public AndCriterion(IsGreaterThanCriterion and1, IsEqualToCriterion<String> and2) {
        this.and1 = and1;
        this.and2 = and2;
    }

    @Override
    public String toHql() {
        return and1.toHql() + " and " + and2.toHql();
    }
}
