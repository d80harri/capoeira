package net.d80harri.capoeira.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
public class ExerciseLog extends CapoeiraEntity {
    private Date timestamp;
    private Effort effort;
    private Quality quality;

    @ManyToOne
    private Exercise exercise;

    public ExerciseLog() {
    }

    public ExerciseLog(Exercise exercise, Date timestamp, Quality quality, Effort effort) {
        this.exercise = exercise;
        this.timestamp = timestamp;
        this.effort = effort;
        this.quality = quality;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Effort getEffort() {
        return effort;
    }

    public void setEffort(Effort effort) {
        this.effort = effort;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
