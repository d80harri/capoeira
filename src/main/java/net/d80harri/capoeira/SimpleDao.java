package net.d80harri.capoeira;

import net.d80harri.capoeira.entities.CapoeiraEntity;
import org.hibernate.Session;

/**
 * Created by d80harri on 02.09.16.
 */
public class SimpleDao {
    private Session session;

    public SimpleDao(Session session) {
        this.session = session;
    }

    public void persist(CapoeiraEntity entity) {
        session.persist(entity);
    }
}
