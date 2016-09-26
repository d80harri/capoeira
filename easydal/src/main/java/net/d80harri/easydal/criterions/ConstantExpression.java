package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ConstantExpression<T, C> extends BaseExpression<T, C> {
    protected final C constantValue;

    public ConstantExpression(Class<T> entityType, C constantValue) {
        super(entityType);
        this.constantValue = constantValue;
    }
}
