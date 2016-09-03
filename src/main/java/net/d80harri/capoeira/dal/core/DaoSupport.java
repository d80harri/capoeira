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
}
