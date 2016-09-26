package net.d80harri.easydal;

/**
 * Created by d80harri on 25.09.16.
 */
public interface ICriterion<T> {
    String toHql();

    Class<T> getEntityType();
}
