package net.d80harri.capoeira.dal.service;

import net.d80harri.capoeira.dal.core.DaoSupport;
import net.d80harri.capoeira.dal.core.SupportedDao;
import net.d80harri.capoeira.dal.data.BaseWord;
import net.d80harri.capoeira.dal.data.Word;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseDao extends SupportedDao<Word> {
    public ExerciseDao(DaoSupport daoSupport) {
        super(Word.class, daoSupport);
    }
}
