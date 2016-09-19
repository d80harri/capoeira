package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.ElementLog;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogDao extends SupportedDao<ElementLog> {
    public ExerciseLogDao(DaoSupport daoSupport) {
        super(ElementLog.class, daoSupport);
    }
}
