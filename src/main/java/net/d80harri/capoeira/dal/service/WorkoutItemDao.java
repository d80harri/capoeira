package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.WorkoutItem;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutItemDao extends SupportedDao<WorkoutItem> {
    public WorkoutItemDao(DaoSupport daoSupport) {
        super(WorkoutItem.class, daoSupport);
    }
}
