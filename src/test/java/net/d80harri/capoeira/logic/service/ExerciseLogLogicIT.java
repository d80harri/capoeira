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
import net.d80harri.capoeira.util.DateUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Created by d80harri on 03.09.16.
 */
public class ExerciseLogLogicIT {

    private ExerciseLogLogic target;
    private ExerciseLogic exerciseLogic;

    private Session session;
    private Transaction tx;
    private CapoeiraLogicBuilder builder;

    @Before
    public void setup() {
        SessionFactory sessionFactory = Utils.createSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        builder = new CapoeiraLogicBuilder(new CapoeiraDalBuilder(session));
        exerciseLogic = builder.getLogic(ExerciseDto.class);
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

        ExerciseLog lastLog = exerciseLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog).isNull();

        ExerciseLogDto expectedLastLog = persist(new ExerciseLogDto(new Date(),e1,Quality.BROKEN, Effort.MAX_EFFORT));
        lastLog = exerciseLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());

        persist(new ExerciseLogDto(DateUtils.addDays(DateUtil.now(), -1), e1, Quality.OPEN, Effort.CHALLENGING));
        lastLog = exerciseLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());

        expectedLastLog = persist(new ExerciseLogDto(DateUtils.addDays(DateUtil.now(), 1), e1, Quality.OPEN, Effort.CHALLENGING));
        lastLog = exerciseLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());
    }

    public <T extends CapoeiraDto> T persist(T dto) {
        return builder.persist(dto);
    }

}
