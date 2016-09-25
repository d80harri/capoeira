package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IExpression;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsGreaterThanCriterion<T> implements ICriterion {
    private IExpression<T> smaller;
    private IExpression<T> greater;

    private IsGreaterThanCriterion(IExpression<T> greater, IExpression<T> smaller) {
        this.smaller = smaller;
        this.greater = greater;
    }
    public String toHql() {
        return greater.toHql() + " > " + smaller.toHql();
    }

    public static <T> IsGreaterThanCriterion<T> create(IExpression<T> greater, IExpression<T> smaller) {
        return new IsGreaterThanCriterion<T>(greater, smaller);
    }
}
