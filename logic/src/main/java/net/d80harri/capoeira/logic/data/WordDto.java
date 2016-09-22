package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.logic.core.CapoeiraDto;

/**
 * Created by d80harri on 03.09.16.
 */
public abstract class WordDto extends ElementDto {
    public WordDto() {
    }

    public WordDto(String title, String hints) {
        super(title, hints);
    }
}
