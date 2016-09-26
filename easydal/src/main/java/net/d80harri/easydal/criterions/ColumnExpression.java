package net.d80harri.easydal.criterions;

import net.d80harri.easydal.IExpression;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ColumnExpression<T, C> extends BaseExpression<T, C> {
    protected final String columnName;

    public ColumnExpression(Class<T> entityType, String columnName) {
        super(entityType);
        this.columnName = columnName;
    }

    @Override
    public String toHql() {
        return columnName;
    }
}
