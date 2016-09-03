package net.d80harri.capoeira.logic.core;

/**
 * Created by d80harri on 03.09.16.
 */
public interface IBusinessLogic<T extends CapoeiraDto> {
    T persist(T dto);
}
