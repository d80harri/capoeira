package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.WorkoutItemDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutItemLogic extends SupportedBusinessLogic<WorkoutItemDto> {
    public WorkoutItemLogic(BusinessLogicSupport<WorkoutItemDto, ?> support) {
        super(support);
    }
}
