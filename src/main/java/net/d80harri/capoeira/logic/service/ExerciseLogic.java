package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.dal.data.ExerciseLog;
import net.d80harri.capoeira.dal.service.ExerciseDao;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ExerciseDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogic extends SupportedBusinessLogic<ExerciseDto, Exercise> {
    public ExerciseLogic(BusinessLogicSupport<ExerciseDto, Exercise> support) {
        super(support);
    }


    public ExerciseLog getLastLog(String exerciseId) {
        Exercise exercise = this.dao.getById(exerciseId);
        return exercise.getLastLog();
    }
}
