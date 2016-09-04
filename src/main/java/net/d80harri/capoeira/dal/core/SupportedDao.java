package net.d80harri.capoeira.dal.core;

/**
 * Created by d80harri on 03.09.16.
 */
public class SupportedDao<T extends CapoeiraEntity> implements IDao<T> {
    private final DaoSupport daoSupport;
    private final Class<T> type;

    public SupportedDao(Class<T> type, DaoSupport daoSupport) {
        this.daoSupport = daoSupport;
        this.type = type;
    }

    @Override
    public void persist(T entity) {
        daoSupport.persist(entity);
    }

    @Override
    public T getById(String id) {
        return daoSupport.getById(type, id);
    }
}
