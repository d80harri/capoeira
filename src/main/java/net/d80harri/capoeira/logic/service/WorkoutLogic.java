package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.WorkoutDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutLogic extends SupportedBusinessLogic<WorkoutDto> {
    public WorkoutLogic(BusinessLogicSupport<WorkoutDto, ?> support) {
        super(support);
    }
}
