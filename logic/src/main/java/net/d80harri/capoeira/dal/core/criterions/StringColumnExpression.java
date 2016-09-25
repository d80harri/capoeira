package net.d80harri.capoeira.dal.core.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class StringColumnExpression<T> extends ColumnExpression<T, String> {

    StringColumnExpression(String columnName) {
        super(columnName);
    }
}
