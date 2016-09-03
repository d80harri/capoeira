package net.d80harri.capoeira.logic.core;

/**
 * Created by d80harri on 03.09.16.
 */
public class SupportedBusinessLogic<T extends CapoeiraDto> implements IBusinessLogic<T> {
    private final BusinessLogicSupport<T, ?> support;

    public SupportedBusinessLogic(BusinessLogicSupport<T, ?> support) {
        this.support = support;
    }

    @Override
    public T persist(T dto) {
        return support.persist(dto);
    }
}
