package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Element;
import net.d80harri.capoeira.dal.data.ElementLog;
import net.d80harri.capoeira.dal.data.Word;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ElementDto;
import net.d80harri.capoeira.logic.data.WordDto;

/**
 * Created by d80harri on 03.09.16.
 */
public abstract class WordLogic<D extends ElementDto, E extends Element> extends ElementLogic<D, E> {
    public WordLogic(BusinessLogicSupport<D, E> support) {
        super(support);
    }


    public ElementLog getLastLog(String exerciseId) {
        Element element = this.dao.getById(Element.class, exerciseId);
        return element.getLastLog();
    }
}
