package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
public class Workout extends CapoeiraEntity {
    private String title;

    @OneToMany(mappedBy = "workout")
    private final Set<WorkoutItem> items = new HashSet<>();

    public Workout() {}

    public Workout(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<WorkoutItem> getItems() {
        return items;
    }
}
