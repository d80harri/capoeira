package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.dal.data.ExerciseLog;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ExerciseDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogic extends SupportedBusinessLogic<ExerciseDto> {
    public ExerciseLogic(BusinessLogicSupport<ExerciseDto, ?> support) {
        super(support);
    }


    public ExerciseLog getLastLog(String exerciseId) {
        throw new RuntimeException("NYI");
    }
}
