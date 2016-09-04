package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.dal.data.ExerciseLog;
import net.d80harri.capoeira.dal.service.ExerciseDao;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ExerciseLogDto;

import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogLogic extends SupportedBusinessLogic<ExerciseLogDto, ExerciseLog> {
    private final ExerciseDao exerciseDao;

    public ExerciseLogLogic(BusinessLogicSupport<ExerciseLogDto, ExerciseLog> support, ExerciseDao exerciseDao) {
        super(support);
        this.exerciseDao = exerciseDao;
    }

    @Override
    public ExerciseLogDto persist(ExerciseLogDto dto) {
        ExerciseLog log = support.map(dto);
        String exerciseId = dto.getExercise().getId();
        Exercise exercise = exerciseDao.getById(exerciseId);

        ExerciseLog currentLastLog = exercise.getLastLog();
        ExerciseLog nextLastLog = retrieveLatestLog(log, currentLastLog);

        exercise.setLastLog(nextLastLog);
        dao.persist(log);
        return support.map(log);
    }

    private ExerciseLog retrieveLatestLog(ExerciseLog log, ExerciseLog currentLastLog) {
        ExerciseLog result = null;
        if (currentLastLog == null) {
            result = log;
        } else {
            Date currentLastLogTimestamp = currentLastLog.getTimestamp();
            if (log.getTimestamp().after(currentLastLogTimestamp)) {
                result = log;
            } else {
                result = currentLastLog;
            }
        }
        return result;
    }
}
