package net.d80harri.easydal.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class StringConstantExpression<T> extends ConstantExpression<T, String> {
    public StringConstantExpression(Class<T> entityType, String constantValue) {
        super(entityType, constantValue);
    }

    @Override
    public String toHql() {
        return "\"" + this.constantValue + "\"";
    }
}
