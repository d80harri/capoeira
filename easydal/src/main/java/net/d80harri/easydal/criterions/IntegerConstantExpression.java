package net.d80harri.easydal.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class IntegerConstantExpression<T> extends ConstantExpression<T, Integer> {
    public IntegerConstantExpression(Class<T> entityType, int constantValue) {
        super(entityType, constantValue);
    }

    @Override
    public String toHql() {
        return ""+this.constantValue;
    }
}
