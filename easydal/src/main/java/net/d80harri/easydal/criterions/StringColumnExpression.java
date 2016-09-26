package net.d80harri.easydal.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class StringColumnExpression<T> extends ColumnExpression<T, String> {

    protected StringColumnExpression(Class<T> entityType, String columnName) {
        super(entityType, columnName);
    }
}
