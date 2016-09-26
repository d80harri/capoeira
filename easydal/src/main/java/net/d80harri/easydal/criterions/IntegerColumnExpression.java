package net.d80harri.easydal.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class IntegerColumnExpression<T> extends ColumnExpression<T, Integer> {

    public IntegerColumnExpression(Class<T> entityType, String columnName) {
        super(entityType, columnName);
    }


}
