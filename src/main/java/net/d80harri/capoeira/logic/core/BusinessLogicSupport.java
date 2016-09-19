package net.d80harri.capoeira.logic.core;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;
import net.d80harri.capoeira.dal.core.CapoeiraDao;
import net.d80harri.capoeira.mapper.IMapper;

/**
 * Created by d80harri on 03.09.16.
 */
public class BusinessLogicSupport<T extends CapoeiraDto, U extends CapoeiraEntity> {
    private final CapoeiraDao dao;
    private final IMapper<T, U> dto2EntityMapper;
    private final IMapper<U, T> entity2DtoMapper;

    public BusinessLogicSupport(CapoeiraDao dao, IMapper<T, U> dto2EntityMapper, IMapper<U, T> entity2DtoMapper) {
        this.dao = dao;
        this.dto2EntityMapper = dto2EntityMapper;
        this.entity2DtoMapper = entity2DtoMapper;
    }

    public T persist(T dto) {
        U entity = dto2EntityMapper.map(dto);
        dao.persist(entity);
        T persistedDto = entity2DtoMapper.map(entity);
        return persistedDto;
    }

    public CapoeiraDao getDao() {
        return dao;
    }

    public IMapper<T, U> getDto2EntityMapper() {
        return dto2EntityMapper;
    }

    public IMapper<U, T> getEntity2DtoMapper() {
        return entity2DtoMapper;
    }

    public U map(T dto) {
        return getDto2EntityMapper().map(dto);
    }

    public T map(U entity) {
        return getEntity2DtoMapper().map(entity);
    }
}
