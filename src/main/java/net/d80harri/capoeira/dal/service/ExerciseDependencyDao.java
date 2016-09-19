package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.Vertex;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDependencyDao extends SupportedDao<Vertex> {
    public ExerciseDependencyDao(DaoSupport daoSupport) {
        super(Vertex.class, daoSupport);
    }
}
