package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Element;
import net.d80harri.capoeira.dal.data.ElementLog;
import net.d80harri.capoeira.dal.data.Word;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ExerciseDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogic extends SupportedBusinessLogic<ExerciseDto, Word> {
    public ExerciseLogic(BusinessLogicSupport<ExerciseDto, Word> support) {
        super(support);
    }


    public ElementLog getLastLog(String exerciseId) {
        Element element = this.dao.getById(exerciseId);
        return element.getLastLog();
    }
}
