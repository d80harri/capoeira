package net.d80harri.capoeira.logic.data;

import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.ToOne;

/**
 * Created by d80harri on 03.09.16.
 */
public class VertexDto extends CapoeiraDto {
    private ToOne<WordDto> successor;
    private ToOne<WordDto> predecessor;

    public VertexDto() {}

    public VertexDto(WordDto predecessor, WordDto successor) {
        this(ToOne.valueOf(successor), ToOne.valueOf(predecessor));
    }

    public VertexDto(ToOne<WordDto> predecessor, ToOne<WordDto> successor) {
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public ToOne<WordDto> getSuccessor() {
        return successor;
    }

    public void setSuccessor(ToOne<WordDto> successor) {
        this.successor = successor;
    }

    public ToOne<WordDto> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(ToOne<WordDto> predecessor) {
        this.predecessor = predecessor;
    }
}
