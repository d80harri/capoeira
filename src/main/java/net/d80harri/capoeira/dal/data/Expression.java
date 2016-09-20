package net.d80harri.capoeira.dal.data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by d80harri on 20.09.16.
 */
@Entity
public class Expression extends Element {
    @OneToMany(mappedBy = "expression")
    private Set<ExpressionItem> items = new HashSet<>();

    public Set<ExpressionItem> getItems() {
        return items;
    }

    public void setItems(Set<ExpressionItem> items) {
        this.items = items;
    }
}
