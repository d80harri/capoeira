package net.d80harri.capoeira.logic.core;

import net.d80harri.capoeira.dal.data.Exercise;

/**
 * Created by d80harri on 03.09.16.
 */
public interface IBusinessLogic<T extends CapoeiraDto> {
    T persist(T dto);
}
