package net.d80harri.capoeira.dal;

import net.d80harri.capoeira.dal.core.CapoeiraDao;
import org.hibernate.Session;

/**
 * Created by d80harri on 03.09.16.
 */
public class CapoeiraDalBuilder {
    private final Session session;
    private final CapoeiraDao dao;

    public CapoeiraDalBuilder(Session session) {
        this.session = session;
        this.dao = new CapoeiraDao(session);
    }

    public CapoeiraDao getDao() {
        return dao;
    }

    public Session getSession() {
        return session;
    }
}
