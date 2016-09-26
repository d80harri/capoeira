package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;

/**
 * Created by d80harri on 26.09.16.
 */
public abstract class BaseExpression<T, C> implements IExpression<T, C> {
    private final Class<T> entityType;

    public BaseExpression(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public Class<T> getEntityType() {
        return entityType;
    }
}
