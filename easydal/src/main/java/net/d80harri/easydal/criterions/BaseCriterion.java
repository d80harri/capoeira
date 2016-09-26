package net.d80harri.easydal.criterions;

import net.d80harri.easydal.ICriterion;

/**
 * Created by d80harri on 26.09.16.
 */
public abstract class BaseCriterion<T> implements ICriterion<T> {
    protected final Class<T> entityType;

    public BaseCriterion(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public Class<T> getEntityType() {
        return entityType;
    }
}
