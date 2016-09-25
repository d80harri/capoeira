package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ConstantExpression<T> implements IExpression<T> {
    protected final T constantValue;

    public ConstantExpression(T constantValue) {
        this.constantValue = constantValue;
    }
}
