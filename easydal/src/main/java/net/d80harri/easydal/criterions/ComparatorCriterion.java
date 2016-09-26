package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;
import net.d80harri.easydal.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ComparatorCriterion<T, C> extends BaseCriterion<T> {
    protected final IExpression<T, C> first;
    protected final IExpression<T, C> second;

    protected ComparatorCriterion(Class<T> entityType, IExpression<T, C> first, IExpression<T, C> second) {
        super(entityType);
        this.first = first;
        this.second = second;
    }

    static <T> Class<T> assumeAllSameTypes(IExpression<T, ?> expr, IExpression<T, ?>... moreExpr) {
        Class<T> result = expr.getEntityType();

        for (IExpression<?, ?> it : moreExpr) {
            if (it.getEntityType() != result) {
                throw new RuntimeException();
            }
        }

        return result;
    }

    public String toHql() {
        return second.toHql() + " > " + first.toHql();
    }

}
