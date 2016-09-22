package net.d80harri.capoeira.logic.service;

import net.d80harri.capoeira.dal.CapoeiraDalBuilder;
import net.d80harri.capoeira.dal.Utils;
import net.d80harri.capoeira.dal.data.ElementLog;
import net.d80harri.capoeira.dal.data.Quality;
import net.d80harri.capoeira.logic.CapoeiraLogicBuilder;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.data.BaseWordDto;
import net.d80harri.capoeira.logic.data.WordDto;
import net.d80harri.capoeira.logic.data.ElementLogDto;
import net.d80harri.capoeira.util.DateUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.DateUtil;
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

    private ElementLogLogic target;
    private WordLogic baseWordLogic;

    private Session session;
    private Transaction tx;
    private CapoeiraLogicBuilder builder;

    @Before
    public void setup() {
        SessionFactory sessionFactory = Utils.createSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        builder = new CapoeiraLogicBuilder(new CapoeiraDalBuilder(session));
        baseWordLogic = builder.getLogic(BaseWordDto.class);
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
    public void testUpdateMeasurementsWhenElementLogIsCreated() {
        WordDto e1 = persist(new BaseWordDto("ex1", "ex1 hints"));

        ElementLog lastLog = baseWordLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog).isNull();

        ElementLogDto expectedLastLog = persist(new ElementLogDto(new Date(),e1,Quality.IMPOSSIBLE));
        lastLog = baseWordLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());

        persist(new ElementLogDto(DateUtils.addDays(DateUtil.now(), -1), e1, Quality.UNKNOWN));
        lastLog = baseWordLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());

        expectedLastLog = persist(new ElementLogDto(DateUtils.addDays(DateUtil.now(), 1), e1, Quality.UNKNOWN));
        lastLog = baseWordLogic.getLastLog(e1.getId());
        Assertions.assertThat(lastLog.getId()).isEqualTo(expectedLastLog.getId());
    }

    public <T extends CapoeiraDto> T persist(T dto) {
        return builder.persist(dto);
    }

}
