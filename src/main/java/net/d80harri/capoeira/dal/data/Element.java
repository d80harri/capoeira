package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 19.09.16.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Element extends CapoeiraEntity {
    @OneToMany(mappedBy = "predecessor")
    private final Set<Vertex> predecessors = new HashSet<>();
    @OneToMany(mappedBy = "successor")
    private final Set<Vertex> successors = new HashSet<>();
    @OneToMany(mappedBy = "element")
    private final Set<ElementLog> logs = new HashSet<>();
    private String title;
    private String hints;
    @ManyToOne
    private ElementLog lastLog;

    public Element() {
    }

    public Element(String id) {
        super(id);
    }

    public Element(String title, String hints) {
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

    public Set<Vertex> getPredecessors() {
        return this.predecessors;
    }

    public Set<Vertex> getSuccessors() {
        return successors;
    }

    public Set<ElementLog> getLogs() {
        return logs;
    }

    public ElementLog getLastLog() {
        return lastLog;
    }

    public void setLastLog(ElementLog lastLog) {
        this.lastLog = lastLog;
    }
}
