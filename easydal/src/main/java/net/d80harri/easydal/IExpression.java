package net.d80harri.easydal;

/**
 * Created by d80harri on 25.09.16.
 */
public interface IExpression<T, C> {
    String toHql();

    Class<T> getEntityType();
}
