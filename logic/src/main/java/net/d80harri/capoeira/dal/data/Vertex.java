package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
public class Vertex extends CapoeiraEntity {
    @ManyToOne
    private Element successor;
    @ManyToOne
    private Element predecessor;

    public Vertex() {}

    public Vertex(Element predecessor, Element successor) {
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public void setSuccessor(Element successor) {
        this.successor = successor;
    }

    public Element getSuccessor() {
        return successor;
    }

    public Element getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Element predecessor) {
        this.predecessor = predecessor;
    }
}
