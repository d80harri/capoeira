package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ColumnCriterion<T, C> implements IComparableCriterion<C> {
    protected final String columnName;

    public ColumnCriterion(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toHql() {
        return columnName;
    }
}
