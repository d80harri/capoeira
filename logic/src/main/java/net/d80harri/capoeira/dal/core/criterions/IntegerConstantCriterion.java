package net.d80harri.capoeira.dal.core.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class IntegerConstantCriterion extends ConstantCriterion {
    public IntegerConstantCriterion(int constantValue) {
        super(constantValue);
    }

    @Override
    public String toHql() {
        return ""+this.constantValue;
    }
}
