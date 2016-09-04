package net.d80harri.capoeira.logic.core;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;
import net.d80harri.capoeira.dal.core.IDao;

/**
 * Created by d80harri on 03.09.16.
 */
public class SupportedBusinessLogic<T extends CapoeiraDto, U extends CapoeiraEntity> implements IBusinessLogic<T> {
    protected final BusinessLogicSupport<T, U> support;
    protected final IDao<U> dao;

    public SupportedBusinessLogic(BusinessLogicSupport<T, U> support) {
        this.support = support;
        this.dao = support.getDao();
    }

    @Override
    public T persist(T dto) {
        return support.persist(dto);
    }
}
