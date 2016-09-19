package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.logic.core.CapoeiraDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDto extends CapoeiraDto {
    private String title;
    private String hints;

    public ExerciseDto() {}

    public ExerciseDto(String title, String hints) {
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
