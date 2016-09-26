package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;
import net.d80harri.easydal.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsGreaterThanCriterion<T, C> extends ComparatorCriterion<T, C> {

    private IsGreaterThanCriterion(Class<T> entityType, IExpression<T, C> greater, IExpression<T, C> smaller) {
        super(entityType, greater, smaller);
    }
    public String toHql() {
        return first.toHql() + " > " + second.toHql();
    }

    public static <T, C> IsGreaterThanCriterion<T, C> create(IExpression<T, C> greater, IExpression<T, C> smaller) {
        Class<T> entityType = assumeAllSameTypes(greater, smaller);
        return new IsGreaterThanCriterion<T, C>(entityType, greater, smaller);
    }

}
