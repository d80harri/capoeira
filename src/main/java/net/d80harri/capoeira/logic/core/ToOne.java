package net.d80harri.capoeira.logic.core;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.logic.data.ExerciseDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ToOne<T extends CapoeiraDto> {
    private final String id;
    private final T dto;

    public ToOne(String id, T dto) {
        this.id = id;
        this.dto = dto;
    }

    public String getId() {
        return id;
    }

    public T getDto() {
        return dto;
    }

    public static <T extends CapoeiraDto> ToOne<T> valueOf(T dto) {
        ToOne<T> result = null;

        if (dto != null) {
            result = new ToOne<>(dto.getId(), dto);
        }

        return result;
    }

    public static <T extends CapoeiraDto> ToOne<T> valueOf(String id) {
        return new ToOne<T>(id, null);
    }
}
