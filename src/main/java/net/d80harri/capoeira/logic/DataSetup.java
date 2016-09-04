package net.d80harri.capoeira.logic;

import net.d80harri.capoeira.dal.CapoeiraDalBuilder;
import net.d80harri.capoeira.dal.Utils;
import net.d80harri.capoeira.dal.data.*;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.IBusinessLogic;
import net.d80harri.capoeira.logic.core.ToOne;
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
        // Exercises
        // ===============================================================================================
        ExerciseDto par_qdr = add(new ExerciseDto("Parallela - Queda de Rins", "Right leg and right hand on the floor - left hand to the floor - head to floor - bend left arm - left flank to left elbow - left leg underswitch - right leg to back (straddle) and bend right knee"));
        ExerciseDto qdr_neg_role = add(new ExerciseDto("Queda de Rins - Negativa - Rolé", "Esquiva to right - Queda de Rins with right leg facing forward, left leg bent to the back (to keep balance) - right leg bends, left leg moves forward into Negativa"));
        ExerciseDto esq_qdr_neg_role = add(new ExerciseDto("Esquiva - Queda de Rins - Negativa - Rolé", null));
        ExerciseDto ponte = add(new ExerciseDto("Ponte", null));
        ExerciseDto esq_ponte = add(new ExerciseDto("Esquiva - Ponte", null));
        ExerciseDto comp_esq_ponte = add(new ExerciseDto("Compasso - Esquiva - Ponte", null));
        ExerciseDto rast_pir_ginga = add(new ExerciseDto("Rasteira - Piruette - Ginga", null));
        ExerciseDto rast_pir_qdr_neg_role = add(new ExerciseDto("Rasteira - Piruette - Queda de Rins - Negativa - Rolé", null));
        ExerciseDto rast_au = add(new ExerciseDto("Rasteira - Aù", "Rasteira (with left leg) - jump left leg to back - weight on left leg - Aù"));
        ExerciseDto arm = add(new ExerciseDto("Armada", null));
        ExerciseDto arm_rast_au_qdr = add(new ExerciseDto("Armada - Rasteira - Aù - Queda de Rins", null));
        ExerciseDto frent_rast = add(new ExerciseDto("Frente - Rasteira", null));
        ExerciseDto armdup = add(new ExerciseDto("Armada dupla", null));
        ExerciseDto rast_mak = add(new ExerciseDto("Rasteira - Makako", null));
        ExerciseDto par_ponte = add(new ExerciseDto("Paralella - Ponte", null));
        ExerciseDto coc_qdr = add(new ExerciseDto("Cocorinha - Queda de Rins", "Keep both legs bent."));
        ExerciseDto neg_qdr = add(new ExerciseDto("Negativa - Queda de Rins", "Negativa (right leg extended) - Queda de Rins to the right - switch legs - Negativa other side"));

        // ===============================================================================================
        // Exercise Dependencies
        // ===============================================================================================
        add(new ExerciseDependencyDto(par_qdr, qdr_neg_role));
        add(new ExerciseDependencyDto(qdr_neg_role, esq_qdr_neg_role));
        add(new ExerciseDependencyDto(ponte, esq_ponte));
        add(new ExerciseDependencyDto(ponte, comp_esq_ponte));
        add(new ExerciseDependencyDto(ponte, comp_esq_ponte));
        add(new ExerciseDependencyDto(esq_ponte, comp_esq_ponte));
        add(new ExerciseDependencyDto(rast_pir_ginga, rast_pir_qdr_neg_role));
        add(new ExerciseDependencyDto(qdr_neg_role, rast_pir_qdr_neg_role));
        add(new ExerciseDependencyDto(rast_pir_ginga, rast_au));
        add(new ExerciseDependencyDto(arm, arm_rast_au_qdr));
        add(new ExerciseDependencyDto(rast_pir_ginga, arm_rast_au_qdr));
        add(new ExerciseDependencyDto(par_qdr, arm_rast_au_qdr));
        add(new ExerciseDependencyDto(rast_au, arm_rast_au_qdr));
        add(new ExerciseDependencyDto(esq_qdr_neg_role, arm_rast_au_qdr));
        add(new ExerciseDependencyDto(arm, armdup));
        add(new ExerciseDependencyDto(ponte, par_ponte));
        add(new ExerciseDependencyDto(coc_qdr, neg_qdr));
        add(new ExerciseDependencyDto(neg_qdr, par_qdr));

        // ===============================================================================================
        // Workouts
        // ===============================================================================================
        WorkoutDto workout1 = add(new WorkoutDto("Workout 1"));
        WorkoutDto workout2 = add(new WorkoutDto("Workout 2"));

        // ===============================================================================================
        // Workout Items
        // ===============================================================================================
        add(new WorkoutItemDto(0, workout1, par_qdr));
        add(new WorkoutItemDto(1, workout1, qdr_neg_role));
        add(new WorkoutItemDto(2, workout1, esq_qdr_neg_role));

        add(new WorkoutItemDto(0, workout2, ponte));
        add(new WorkoutItemDto(1, workout2, esq_ponte));
        add(new WorkoutItemDto(2, workout2, comp_esq_ponte));

        // ===============================================================================================
        // Exercise Logs
        // ===============================================================================================
        add(new ExerciseLogDto(createDate(2016, Month.AUGUST, 28), rast_pir_ginga, Quality.OPEN, null));
        add(new ExerciseLogDto(createDate(2016, Month.AUGUST, 28), esq_ponte, null, null));
        add(new ExerciseLogDto(createDate(2016, Month.AUGUST, 28), ponte, null, null));

        add(new ExerciseLogDto(createDate(2016, Month.AUGUST, 31), rast_pir_ginga, Quality.ROUGH, Effort.RELAXED));
        add(new ExerciseLogDto(createDate(2016, Month.AUGUST, 31), par_qdr, Quality.ROUGH, Effort.CHALLENGING));
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
