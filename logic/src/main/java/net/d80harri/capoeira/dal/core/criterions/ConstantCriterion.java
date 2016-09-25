package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public abstract class ConstantCriterion<T> implements IComparableCriterion<T> {
    protected final T constantValue;

    public ConstantCriterion(T constantValue) {
        this.constantValue = constantValue;
    }
}
