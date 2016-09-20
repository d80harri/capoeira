package net.d80harri.capoeira.dal.data;

import net.d80harri.capoeira.dal.core.CapoeiraEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by d80harri on 20.09.16.
 */
@Entity
public class ExpressionItem extends CapoeiraEntity {
    @ManyToOne
    private Expression expression;
    @ManyToOne
    private Word word;
    private int seqNr;

    public ExpressionItem() {
    }

    public ExpressionItem(Expression expression, Word word, int seqNr) {
        this.expression = expression;
        this.word = word;
        this.seqNr = seqNr;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getSeqNr() {
        return seqNr;
    }

    public void setSeqNr(int seqNr) {
        this.seqNr = seqNr;
    }

}
