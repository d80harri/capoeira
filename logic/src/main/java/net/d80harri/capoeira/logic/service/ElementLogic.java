package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.data.Element;
import net.d80harri.capoeira.dal.data.Word;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ElementDto;
import net.d80harri.capoeira.logic.data.WordDto;

/**
 * Created by d80harri on 20.09.16.
 */
public class ElementLogic<D extends ElementDto, E extends Element> extends SupportedBusinessLogic<D, E> {
    public ElementLogic(BusinessLogicSupport<D, E> support) {
        super(support);
    }
}
