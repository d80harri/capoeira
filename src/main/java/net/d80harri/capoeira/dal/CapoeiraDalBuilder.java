package net.d80harri.capoeira.dal;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.service.*;
import org.hibernate.Session;

/**
 * Created by d80harri on 03.09.16.
 */
public class CapoeiraDalBuilder {
    private final Session session;
    private final ExerciseDao exerciseDao;
    private final ExerciseDependencyDao exerciseDependencyDao;
    private final ExerciseLogDao exerciseLogDao;

    public CapoeiraDalBuilder(Session session) {
        DaoSupport daoSupport = new DaoSupport(session);

        this.session = session;
        this.exerciseDao = new ExerciseDao(daoSupport);
        this.exerciseDependencyDao = new ExerciseDependencyDao(daoSupport);
        this.exerciseLogDao = new ExerciseLogDao(daoSupport);
    }

    public ExerciseDao getExerciseDao() {
        return exerciseDao;
    }

    public ExerciseDependencyDao getExerciseDependencyDao() {
        return exerciseDependencyDao;
    }

    public ExerciseLogDao getExerciseLogDao() {
        return exerciseLogDao;
    }

    public Session getSession() {
        return session;
    }
}
