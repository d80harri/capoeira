package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterion<T, C> extends ComparatorCriterion<T, C> {

    public IsEqualToCriterion(Class<T> entityType, IExpression<T, C> left, IExpression<T, C> right) {
        super(entityType, left, right);
    }
    public String toHql() {
        return first.toHql() + " = " + second.toHql();
    }

    public static <T, C> IsEqualToCriterion<T, C> create(IExpression<T, C> left, IExpression<T, C> right) {
        Class<T> entityType = assumeAllSameTypes(left, right);
        return new IsEqualToCriterion<T, C>(entityType, left, right);
    }
}
