package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.dal.data.Quality;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogDto extends CapoeiraDto {
    private Date timestamp;
    private Quality quality;
    private ToOne<ExerciseDto> exercise;

    public ExerciseLogDto() {}

    public ExerciseLogDto(Date timestamp, ToOne<ExerciseDto> exercise, Quality quality) {
        this.timestamp = timestamp;
        this.quality = quality;
        this.exercise = exercise;
    }

    public ExerciseLogDto(Date timestamp, ExerciseDto exercise, Quality quality) {
        this(timestamp, ToOne.valueOf(exercise), quality);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public ToOne<ExerciseDto> getExercise() {
        return exercise;
    }

    public void setExercise(ToOne<ExerciseDto> exercise) {
        this.exercise = exercise;
    }
}
