package net.d80harri.easydal.criterions;

import net.d80harri.easydal.ICriterion;
import net.d80harri.easydal.IExpression;

/**
 * Created by d80harri on 26.09.16.
 */
public abstract class ToOneCriterion<T, C> extends BaseCriterion<T> {

    private final String propertyName;
    private final ICriterion<C> criterion;

    public ToOneCriterion(Class<T> entityType, String propertyName, ICriterion<C> criterion) {
        super(entityType);
        this.propertyName = propertyName;
        this.criterion = criterion;
    }

    @Override
    public String toHql() {
        return propertyName + "." + criterion.toHql();
    }
}
