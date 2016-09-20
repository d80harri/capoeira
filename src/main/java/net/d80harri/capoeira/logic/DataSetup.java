package net.d80harri.capoeira.logic;

import net.d80harri.capoeira.dal.CapoeiraDalBuilder;
import net.d80harri.capoeira.dal.Utils;
import net.d80harri.capoeira.dal.data.*;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.IBusinessLogic;
import net.d80harri.capoeira.logic.data.*;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by d80harri on 03.09.16.
 */
public class DataSetup {

    private final List<CapoeiraDto> allDtos = new ArrayList<>();
    private final CapoeiraLogicBuilder builder;

    public DataSetup(CapoeiraLogicBuilder builder) {
        this.builder = builder;
    }

    public void setup() {
        createEntities();

        allDtos.forEach(this::persist);
    }

    private <T extends CapoeiraDto> T add(T dto) {
        return persist(dto);
    }

    private <T extends CapoeiraDto> T persist(T dto) {
        Class<T> type = (Class<T>)dto.getClass();
        IBusinessLogic<T> logic = builder.getLogic(type);
        return logic.persist(dto);
    }

    private Date createDate(int year, Month august, int dayOfMonth) {
        return Date.from(LocalDate.of(year, august, dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    private void createEntities() {
        // ===============================================================================================
        // Words
        // ===============================================================================================
        BaseWordDto par_qdr = add(new BaseWordDto("Parallela - Queda de Rins", "Right leg and right hand on the floor - left hand to the floor - head to floor - bend left arm - left flank to left elbow - left leg underswitch - right leg to back (straddle) and bend right knee"));
        BaseWordDto esq_qdr_neg_role = add(new BaseWordDto("Esquiva - Queda de Rins - Negativa - Rolé", null));
        BaseWordDto ponte = add(new BaseWordDto("Ponte", null));
        BaseWordDto esq_ponte = add(new BaseWordDto("Esquiva - Ponte", null));
        BaseWordDto comp_esq_ponte = add(new BaseWordDto("Compasso - Esquiva - Ponte", null));
        BaseWordDto rast_pir_ginga = add(new BaseWordDto("Rasteira - Piruette - Ginga", null));
        BaseWordDto rast_pir_qdr_neg_role = add(new BaseWordDto("Rasteira - Piruette - Queda de Rins - Negativa - Rolé", null));
        BaseWordDto rast_au = add(new BaseWordDto("Rasteira - Aù", "Rasteira (with left leg) - jump left leg to back - weight on left leg - Aù"));
        BaseWordDto arm = add(new BaseWordDto("Armada", null));
        BaseWordDto arm_rast_au_qdr = add(new BaseWordDto("Armada - Rasteira - Aù - Queda de Rins", null));
        BaseWordDto frent_rast = add(new BaseWordDto("Frente - Rasteira", null));
        BaseWordDto armdup = add(new BaseWordDto("Armada dupla", null));
        BaseWordDto rast_mak = add(new BaseWordDto("Rasteira - Makako", null));
        BaseWordDto par_ponte = add(new BaseWordDto("Paralella - Ponte", null));
        BaseWordDto coc_qdr = add(new BaseWordDto("Cocorinha - Queda de Rins", "Keep both legs bent."));
        BaseWordDto neg_qdr = add(new BaseWordDto("Negativa - Queda de Rins", "Negativa (right leg extended) - Queda de Rins to the right - switch legs - Negativa other side"));

        // ===============================================================================================
        // Expressions
        // ===============================================================================================
        BaseWordDto qdr_neg_role = add(new BaseWordDto("Queda de Rins - Negativa - Rolé", "Esquiva to right - Queda de Rins with right leg facing forward, left leg bent to the back (to keep balance) - right leg bends, left leg moves forward into Negativa"));

        // ===============================================================================================
        // Vertices
        // ===============================================================================================
        add(new VertexDto(par_qdr, qdr_neg_role));
        add(new VertexDto(qdr_neg_role, esq_qdr_neg_role));
        add(new VertexDto(ponte, esq_ponte));
        add(new VertexDto(ponte, comp_esq_ponte));
        add(new VertexDto(ponte, comp_esq_ponte));
        add(new VertexDto(esq_ponte, comp_esq_ponte));
        add(new VertexDto(rast_pir_ginga, rast_pir_qdr_neg_role));
        add(new VertexDto(qdr_neg_role, rast_pir_qdr_neg_role));
        add(new VertexDto(rast_pir_ginga, rast_au));
        add(new VertexDto(arm, arm_rast_au_qdr));
        add(new VertexDto(rast_pir_ginga, arm_rast_au_qdr));
        add(new VertexDto(par_qdr, arm_rast_au_qdr));
        add(new VertexDto(rast_au, arm_rast_au_qdr));
        add(new VertexDto(esq_qdr_neg_role, arm_rast_au_qdr));
        add(new VertexDto(arm, armdup));
        add(new VertexDto(ponte, par_ponte));
        add(new VertexDto(coc_qdr, neg_qdr));
        add(new VertexDto(neg_qdr, par_qdr));

        // ===============================================================================================
        // Logs
        // ===============================================================================================
        add(new ElementLogDto(createDate(2016, Month.AUGUST, 28), rast_pir_ginga, Quality.UNKNOWN));
        add(new ElementLogDto(createDate(2016, Month.AUGUST, 28), esq_ponte, null));
        add(new ElementLogDto(createDate(2016, Month.AUGUST, 28), ponte, null));

        add(new ElementLogDto(createDate(2016, Month.AUGUST, 31), rast_pir_ginga, Quality.POSSIBLE));
        add(new ElementLogDto(createDate(2016, Month.AUGUST, 31), par_qdr, Quality.POSSIBLE));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SessionFactory sessionFactory = Utils.createSessionFactory();

        try {
            Utils.withinSession(sessionFactory, s -> {
                DataSetup setup = new DataSetup(new CapoeiraLogicBuilder(new CapoeiraDalBuilder(s)));
                Utils.withinTransaction(s, setup::setup);
            });
        } finally {
            sessionFactory.close();
        }
        long stop = System.currentTimeMillis();

        System.out.println(start - stop);
    }
}
