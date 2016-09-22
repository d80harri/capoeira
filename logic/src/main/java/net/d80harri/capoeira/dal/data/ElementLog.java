package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by d80harri on 02.09.16.
 */
@Entity
public class ElementLog extends CapoeiraEntity {
    private Date timestamp;
    private Quality quality;

    @ManyToOne
    private Element element;

    public ElementLog() {
    }

    public ElementLog(Element element, Date timestamp, Quality quality) {
        this.element = element;
        this.timestamp = timestamp;
        this.quality = quality;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Element getWord() {
        return element;
    }

    public void setWord(Element element) {
        this.element = element;
    }
}
