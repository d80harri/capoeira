package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.dal.data.Workout;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

import javax.persistence.ManyToOne;

/**
 * Created by d80harri on 03.09.16.
 */
public class WorkoutItemDto extends CapoeiraDto {
    private int seq;
    private ToOne<WorkoutDto> workout;
    private ToOne<ExerciseDto> exercise;

    public WorkoutItemDto() {}

    public WorkoutItemDto(int seq, ToOne<WorkoutDto> workout, ToOne<ExerciseDto> exercise) {
        this.seq = seq;
        this.workout = workout;
        this.exercise = exercise;
    }

    public WorkoutItemDto(int seq, WorkoutDto workout, ExerciseDto exercise) {
        this(seq, ToOne.valueOf(workout), ToOne.valueOf(exercise));
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public ToOne<WorkoutDto> getWorkout() {
        return workout;
    }

    public void setWorkout(ToOne<WorkoutDto> workout) {
        this.workout = workout;
    }

    public ToOne<ExerciseDto> getExercise() {
        return exercise;
    }

    public void setExercise(ToOne<ExerciseDto> exercise) {
        this.exercise = exercise;
    }
}
