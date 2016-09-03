package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.CapoeiraDalBuilder;
import net.d80harri.capoeira.dal.Utils;
import net.d80harri.capoeira.dal.data.Effort;
import net.d80harri.capoeira.dal.data.ExerciseLog;
import net.d80harri.capoeira.dal.data.Quality;
import net.d80harri.capoeira.logic.CapoeiraLogicBuilder;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.data.ExerciseDto;
import net.d80harri.capoeira.logic.data.ExerciseLogDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogLogicIT {

    private ExerciseLogLogic target;
    private Session session;
    private Transaction tx;
    private CapoeiraLogicBuilder builder;

    @Before
    public void setup() {
        SessionFactory sessionFactory = Utils.createSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        builder = new CapoeiraLogicBuilder(new CapoeiraDalBuilder(session));
    }

    @After
    public void tearDown() {
        if (tx != null) {
            tx.commit();
        }
        if (session != null) {
            session.close();
        }
    }

    @Test
    public void testUpdateMeasurementsWhenExerciseLogIsCreated() {
        ExerciseDto e1 = persist(new ExerciseDto("ex1", "ex1 hints"));

        // TODO: assert that e1.getLastLog() is null

        ExerciseLogDto log = persist(new ExerciseLogDto(new Date(),e1,Quality.BROKEN, Effort.MAX_EFFORT));

        // TODO: assert that e1.getLastLog() is log
        // TODO: insert log whose timestamp is older than an already existant timestamp and assert that e1.getLastLog has not changed

    }

    public <T extends CapoeiraDto> T persist(T dto) {
        return builder.persist(dto);
    }

}
