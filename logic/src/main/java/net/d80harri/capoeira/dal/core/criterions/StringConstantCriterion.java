package net.d80harri.capoeira.dal.core.criterions;

/**
 * Created by d80harri on 25.09.16.
 */
public class StringConstantCriterion extends ConstantCriterion<String> {
    public StringConstantCriterion(String constantValue) {
        super(constantValue);
    }

    @Override
    public String toHql() {
        return "\"" + this.constantValue + "\"";
    }
}