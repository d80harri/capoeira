package net.d80harri.capoeira.dal.core;

import org.hibernate.Session;

/**
 * Created by d80harri on 19.09.16.
 */
public interface SingleResultQuery<T extends CapoeiraEntity> {
    T query(Session session);
}
