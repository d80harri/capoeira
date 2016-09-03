package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.dal.data.ExerciseDependency;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ExerciseDependencyDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDependencyLogic extends SupportedBusinessLogic<ExerciseDependencyDto> {
    public ExerciseDependencyLogic(BusinessLogicSupport<ExerciseDependencyDto, ExerciseDependency> support) {
        super(support);
    }
}
