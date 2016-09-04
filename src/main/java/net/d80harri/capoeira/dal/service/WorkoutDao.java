package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.Workout;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutDao extends SupportedDao<Workout> {
    public WorkoutDao(DaoSupport daoSupport) {
        super(Workout.class, daoSupport);
    }
}
