package net.d80harri.capoeira.dal.core;

/**
 * Created by d80harri on 03.09.16.
 */
public class SupportedDao<T extends CapoeiraEntity> implements IDao<T> {
    private final DaoSupport daoSupport;

    public SupportedDao(DaoSupport daoSupport) {
        this.daoSupport = daoSupport;
    }

    @Override
    public void persist(T entity) {
        daoSupport.persist(entity);
    }
}
