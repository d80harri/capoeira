package net.d80harri.easydal.criterions;

import net.d80harri.easydal.ICriterion;
import net.d80harri.easydal.IExpression;

import java.util.function.Function;

/**
 * Created by d80harri on 26.09.16.
 */
public abstract class CriterionBuilder<T> {
    private final Class<T> entityType;

    public CriterionBuilder(Class<T> entityType) {
        this.entityType = entityType;
    }

    public AndCriterion<T> and(ICriterion<T> and1, ICriterion<T> and2) {
        return new AndCriterion<>(entityType, and1, and2);
    }

    public <C> IsGreaterThanCriterion<T, C> gt(IExpression<T, C> greater, IExpression<T, C> smaller) {
        return new IsGreaterThanCriterion<>(entityType, greater, smaller);
    }

    public <C> IsLessThanCriterion<T, C> lt(IExpression<T, C> smaller, IExpression<T, C> greater){
        return new IsLessThanCriterion<>(entityType, smaller, greater);
    }

    public <C> IsEqualToCriterion<T, C> eq(IExpression<T, C> left, IExpression<T, C> right) {
        return new IsEqualToCriterion<>(entityType, left, right);
    }

    public IntegerConstantExpression integer(int constant) {
        return new IntegerConstantExpression(entityType, constant);
    }

    public StringConstantExpression string(String constant) {
        return new StringConstantExpression(entityType, constant);
    }

    public static class Join<T, U, V extends CriterionBuilder<U>> {
        private final Class<T> leftEntityType;
        private final String propertyName;
        private final V joinedBuilder;

        public Join(Class<T> leftEntityType, String propertyName, V joinedBuilder) {
            this.leftEntityType = leftEntityType;
            this.propertyName = propertyName;
            this.joinedBuilder = joinedBuilder;
        }

        public ToOneCriterion<T, U> with(Function<V, ICriterion<U>> fun) {
            return new ToOneCriterion<>(leftEntityType, propertyName, fun.apply(joinedBuilder));
        }
    }
}
