package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"SEQ", "WORKOUT_ID"}))
public class WorkoutItem extends CapoeiraEntity {
    private int seq;
    @ManyToOne
    private Workout workout;
    @ManyToOne
    private Exercise exercise;

    public WorkoutItem() {
    }

    public WorkoutItem(int seq, Workout workout, Exercise exercise) {
        this.seq = seq;
        this.workout = workout;
        this.exercise = exercise;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
