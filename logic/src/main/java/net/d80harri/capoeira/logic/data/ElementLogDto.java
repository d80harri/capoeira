package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.dal.data.Quality;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ElementLogDto extends CapoeiraDto {
    private Date timestamp;
    private Quality quality;
    private ToOne<WordDto> exercise;

    public ElementLogDto() {}

    public ElementLogDto(Date timestamp, ToOne<WordDto> exercise, Quality quality) {
        this.timestamp = timestamp;
        this.quality = quality;
        this.exercise = exercise;
    }

    public ElementLogDto(Date timestamp, WordDto exercise, Quality quality) {
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

    public ToOne<WordDto> getWord() {
        return exercise;
    }

    public void setWord(ToOne<WordDto> exercise) {
        this.exercise = exercise;
    }
}
