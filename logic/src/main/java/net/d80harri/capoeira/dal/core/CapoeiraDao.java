package net.d80harri.capoeira.dal.core;

import org.hibernate.Session;

/**
 * Created by d80harri on 03.09.16.
 */
public class CapoeiraDao {
    private Session session;

    public CapoeiraDao(Session session) {
        this.session = session;
    }

    public void persist(CapoeiraEntity entity) {
        session.persist(entity);
    }

    public <T extends CapoeiraEntity> T getById(Class<T> type, String id) {
        return new QueryById<>(type, id).query(this.session);
    }
}
