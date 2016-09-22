package net.d80harri.capoeira.mapper;

import org.hibernate.engine.spi.Mapping;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by d80harri on 03.09.16.
 */
public abstract class BaseMapper<T, R> implements IMapper<T, R> {
    private final Class<R> targetType;

    public BaseMapper(Class<R> targetType) {
        this.targetType = targetType;
    }

    @Override
    public R map(T value) throws MappingException {
        R result;

        Constructor<R> ctor;
        try {
            ctor = targetType.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new MappingException(targetType.getName() + " does not define a default contstructor.");
        }
        try {
            result = ctor.newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new MappingException("Something went wrong when trying to instantiate instance of " + targetType.getName());
        }

        mapInto(value, result);
        return result;
    }

    protected abstract void mapInto(T from, R to);
}
