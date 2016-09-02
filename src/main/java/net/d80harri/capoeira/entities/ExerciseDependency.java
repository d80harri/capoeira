package net.d80harri.capoeira.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
public class ExerciseDependency extends CapoeiraEntity {
    @ManyToOne
    private Exercise successor;
    @ManyToOne
    private Exercise predecessor;

    public ExerciseDependency() {}

    public ExerciseDependency(Exercise predecessor, Exercise successor) {
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public void setSuccessor(Exercise successor) {
        this.successor = successor;
    }

    public Exercise getSuccessor() {
        return successor;
    }

    public Exercise getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Exercise predecessor) {
        this.predecessor = predecessor;
    }
}
