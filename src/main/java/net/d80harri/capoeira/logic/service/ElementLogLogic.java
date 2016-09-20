package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.core.CapoeiraDao;
import net.d80harri.capoeira.dal.data.Element;
import net.d80harri.capoeira.dal.data.ElementLog;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.SupportedBusinessLogic;
import net.d80harri.capoeira.logic.data.ElementLogDto;

import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ElementLogLogic extends SupportedBusinessLogic<ElementLogDto, ElementLog> {
    private final CapoeiraDao exerciseDao;

    public ElementLogLogic(BusinessLogicSupport<ElementLogDto, ElementLog> support, CapoeiraDao exerciseDao) {
        super(support);
        this.exerciseDao = exerciseDao;
    }

    @Override
    public ElementLogDto persist(ElementLogDto dto) {
        ElementLog log = support.map(dto);
        String exerciseId = dto.getWord().getId();
        Element element = exerciseDao.getById(Element.class, exerciseId);

        ElementLog currentLastLog = element.getLastLog();
        ElementLog nextLastLog = retrieveLatestLog(log, currentLastLog);

        element.setLastLog(nextLastLog);
        dao.persist(log);
        return support.map(log);
    }

    private ElementLog retrieveLatestLog(ElementLog log, ElementLog currentLastLog) {
        ElementLog result = null;
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
