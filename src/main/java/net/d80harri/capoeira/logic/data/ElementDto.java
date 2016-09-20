package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.dal.data.ElementLog;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

/**
 * Created by d80harri on 20.09.16.
 */
public class ElementDto extends CapoeiraDto {
    private String title;
    private String hints;

    public ElementDto() {}

    public ElementDto(String title, String hints) {
        this.title = title;
        this.hints = hints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

}
