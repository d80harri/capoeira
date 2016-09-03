package net.d80harri.capoeira.dal.core;

/**
 * Created by d80harri on 03.09.16.
 */
public interface IDao<T extends CapoeiraEntity> {
    void persist(T entity);
}
