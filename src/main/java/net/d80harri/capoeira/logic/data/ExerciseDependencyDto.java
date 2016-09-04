package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.dal.data.Exercise;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

import javax.persistence.ManyToOne;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDependencyDto extends CapoeiraDto {
    private ToOne<ExerciseDto> successor;
    private ToOne<ExerciseDto> predecessor;

    public ExerciseDependencyDto() {}

    public ExerciseDependencyDto(ExerciseDto predecessor, ExerciseDto successor) {
        this(ToOne.valueOf(successor), ToOne.valueOf(predecessor));
    }

    public ExerciseDependencyDto(ToOne<ExerciseDto> predecessor, ToOne<ExerciseDto> successor) {
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public ToOne<ExerciseDto> getSuccessor() {
        return successor;
    }

    public void setSuccessor(ToOne<ExerciseDto> successor) {
        this.successor = successor;
    }

    public ToOne<ExerciseDto> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(ToOne<ExerciseDto> predecessor) {
        this.predecessor = predecessor;
    }
}
