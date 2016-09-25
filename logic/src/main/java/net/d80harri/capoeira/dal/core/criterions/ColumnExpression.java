package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ColumnExpression<T, C> implements IExpression<C> {
    protected final String columnName;

    public ColumnExpression(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toHql() {
        return columnName;
    }
}
