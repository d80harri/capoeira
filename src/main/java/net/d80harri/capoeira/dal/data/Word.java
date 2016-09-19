package net.d80harri.capoeira.dal.data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 19.09.16.
 */
@Entity
public class Word extends Element {
    public Word(String id) {
        super(id);
    }

    public Word(String title, String hints) {
        super(title, hints);
    }

    public Word() {
    }
}
