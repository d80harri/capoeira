package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 31.08.16.
 */
@Entity
public class Exercise extends CapoeiraEntity {
    private String title;
    private String hints;

    @OneToMany(mappedBy = "predecessor")
    private final Set<ExerciseDependency> predecessors = new HashSet<>();
    @OneToMany(mappedBy = "successor")
    private final Set<ExerciseDependency> successors = new HashSet<>();
    @OneToMany(mappedBy = "exercise")
    private final Set<WorkoutItem> workoutItems = new HashSet<>();
    @OneToMany(mappedBy = "exercise")
    private final Set<ExerciseLog> logs = new HashSet<>();

    public Exercise() {}

    public Exercise(String id) {
        super(id);
    }

    public Exercise(String title, String hints) {
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

    public Set<ExerciseDependency> getPredecessors() {
        return this.predecessors;
    }

    public Set<ExerciseDependency> getSuccessors() {
        return successors;
    }

    public Set<ExerciseLog> getLogs() {
        return logs;
    }
}
