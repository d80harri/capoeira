package net.d80harri.capoeira.dal.core;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by d80harri on 31.08.16.
 */
@MappedSuperclass
public abstract class CapoeiraEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    public CapoeiraEntity() {}

    public CapoeiraEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
