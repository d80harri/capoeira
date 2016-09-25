package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IsEqualToCriterion<T> implements ICriterion  {

    private StringColumnCriterion<?> left;
    private StringConstantCriterion right;

    private IsEqualToCriterion(StringColumnCriterion<?> left, StringConstantCriterion right) {
        this.left = left;
        this.right = right;
    }
    public String toHql() {
        return left.toHql() + " = " + right.toHql();
    }

    public static <T> IsEqualToCriterion<T> create(StringColumnCriterion<?> left, StringConstantCriterion right) {
        return new IsEqualToCriterion<T>(left, right);
    }
}
