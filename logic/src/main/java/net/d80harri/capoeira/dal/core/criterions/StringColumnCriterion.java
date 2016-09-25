package net.d80harri.capoeira.dal.core.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class StringColumnCriterion<T> extends ColumnCriterion<T, String> {

    public StringColumnCriterion(String columnName) {
        super(columnName);
    }
}
