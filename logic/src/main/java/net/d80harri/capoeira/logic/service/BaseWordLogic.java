package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.BaseWord;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.data.BaseWordDto;

/**
 * Created by d80harri on 20.09.16.
 */
public class BaseWordLogic extends WordLogic<BaseWordDto, BaseWord> {
    public BaseWordLogic(BusinessLogicSupport<BaseWordDto, BaseWord> support) {
        super(support);
    }
}
