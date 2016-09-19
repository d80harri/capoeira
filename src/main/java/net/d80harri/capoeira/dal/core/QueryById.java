package net.d80harri.capoeira.dal.core;

import org.hibernate.Session;

/**
 * Created by d80harri on 19.09.16.
 */
public class QueryById<T extends CapoeiraEntity> implements SingleResultQuery<T> {
    private final Class<T> type;
    private final String id;

    public QueryById(Class<T> type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public T query(Session session) {
        return (T)session.createQuery("from " + type.getName() + " where id=:id").setParameter("id", id).getSingleResult();
    }
}
