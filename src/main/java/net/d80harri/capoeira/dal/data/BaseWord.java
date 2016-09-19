package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 31.08.16.
 */
@Entity
public class BaseWord extends Word {

    public BaseWord() {}

    public BaseWord(String id) {
        super(id);
    }

    public BaseWord(String title, String hints) {
        super(title, hints);
    }

}
