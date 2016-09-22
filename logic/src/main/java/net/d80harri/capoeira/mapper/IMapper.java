package net.d80harri.capoeira.mapper;

/**
 * Created by d80harri on 03.09.16.
 */
public interface IMapper<T, R> {
    R map(T value) throws MappingException;
}
