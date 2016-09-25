package net.d80harri.capoeira.dal.core.criterions;

import net.d80harri.capoeira.dal.core.IComparableCriterion;
import net.d80harri.capoeira.dal.core.ICriterion;

/**
 * Created by d80harri on 25.09.16.
 */
public class IntegerColumnCriterion<T> extends ColumnCriterion<T, Integer> {

    public IntegerColumnCriterion(String columnName) {
        super(columnName);
    }


}
