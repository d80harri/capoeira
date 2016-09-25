package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterion<T> extends ComparatorCriterion<T> {

    private IsEqualToCriterion(IExpression<T> left, IExpression<T> right) {
        super(left, right);
    }
    public String toHql() {
        return first.toHql() + " = " + second.toHql();
    }

    public static <T> IsEqualToCriterion<T> create(IExpression<T> left, IExpression<T> right) {
        return new IsEqualToCriterion<T>(left, right);
    }
}
