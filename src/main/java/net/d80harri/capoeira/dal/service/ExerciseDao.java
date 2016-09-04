package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.Exercise;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDao extends SupportedDao<Exercise> {
    public ExerciseDao(DaoSupport daoSupport) {
        super(Exercise.class, daoSupport);
    }
}
