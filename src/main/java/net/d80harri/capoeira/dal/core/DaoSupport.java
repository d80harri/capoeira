package net.d80harri.capoeira.dal.core;

import org.hibernate.Session;

/**
 * Created by d80harri on 02.09.16.
 */
public class DaoSupport {
    private Session session;

    public DaoSupport(Session session) {
        this.session = session;
    }

    public void persist(CapoeiraEntity entity) {
        session.persist(entity);
    }

    public <T extends CapoeiraEntity> T getById(Class<T> type, String id) {
        return (T)session.createQuery("from " + type.getName() + " where id=:id").setParameter("id", id).getSingleResult();
    }
}
