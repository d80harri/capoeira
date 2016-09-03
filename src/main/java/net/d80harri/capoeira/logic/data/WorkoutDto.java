package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.logic.core.CapoeiraDto;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutDto extends CapoeiraDto {
    private String title;

    public WorkoutDto() {}

    public WorkoutDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
