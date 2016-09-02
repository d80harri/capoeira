package net.d80harri.capoeira;

import net.d80harri.capoeira.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d80harri on 02.09.16.
 */
public class DataSetup {

    private final SimpleDao dao;

    private final List<CapoeiraEntity> allEntities = new ArrayList<>();

    public DataSetup(SimpleDao dao) {
        this.dao = dao;
    }

    public void setup() {
        createEntities();

        allEntities.forEach(dao::persist);
    }

    private <T extends CapoeiraEntity> T add(T entity) {
        allEntities.add(entity);
        return entity;
    }

    private void createEntities() {
        // ===============================================================================================
        // Exercises
        // ===============================================================================================
        Exercise qdr = add(new Exercise("Queda de Rins", "Right leg and right hand on the floor - left hand to the floor - head to floor - bend left arm - left flank to left elbow - left leg underswitch - right leg to back (straddle) and bend right knee"));
        Exercise qdr_neg_role = add(new Exercise("Queda de Rins - Negativa - Rolé", "Esquiva to right - Queda de Rins with right leg facing forward, left leg bent to the back (to keep balance) - right leg bends, left leg moves forward into Negativa"));
        Exercise esq_qdr_neg_role = add(new Exercise("Esquiva - Queda de Rins - Negativa - Rolé", null));
        Exercise ponte = add(new Exercise("Ponte", null));
        Exercise esq_ponte = add(new Exercise("Esquiva - Ponte", null));
        Exercise comp_esq_ponte = add(new Exercise("Compasso - Esquiva - Ponte", null));
        Exercise rast_pir_ginga = add(new Exercise("Rasteira - Piruette - Ginga", null));
        Exercise rast_pir_qdr_neg_role = add(new Exercise("Rasteira - Piruette - Queda de Rins - Negativa - Rolé", null));
        Exercise rast_au = add(new Exercise("Rasteira - Aù", "Rasteira (with left leg) - jump left leg to back - weight on left leg - Aù"));
        Exercise arm = add(new Exercise("Armada", null));
        Exercise arm_rast_au_qdr = add(new Exercise("Armada - Rasteira - Aù - Queda de Rins", null));
        Exercise frent_rast = add(new Exercise("Frente - Rasteira", null));
        Exercise armdup = add(new Exercise("Armada dupla", null));
        Exercise rast_mak = add(new Exercise("Rasteira - Makako", null));
        Exercise par_ponte = add(new Exercise("Paralella - Ponte", null));

        // ===============================================================================================
        // Exercise Dependencies
        // ===============================================================================================
        add(new ExerciseDependency(qdr, qdr_neg_role));
        add(new ExerciseDependency(qdr_neg_role, esq_qdr_neg_role));
        add(new ExerciseDependency(ponte, esq_ponte));
        add(new ExerciseDependency(ponte, comp_esq_ponte));
        add(new ExerciseDependency(ponte, comp_esq_ponte));
        add(new ExerciseDependency(esq_ponte, comp_esq_ponte));
        add(new ExerciseDependency(rast_pir_ginga, rast_pir_qdr_neg_role));
        add(new ExerciseDependency(qdr_neg_role, rast_pir_qdr_neg_role));
        add(new ExerciseDependency(rast_pir_ginga, rast_au));
        add(new ExerciseDependency(arm, arm_rast_au_qdr));
        add(new ExerciseDependency(rast_pir_ginga, arm_rast_au_qdr));
        add(new ExerciseDependency(qdr, arm_rast_au_qdr));
        add(new ExerciseDependency(rast_au, arm_rast_au_qdr));
        add(new ExerciseDependency(esq_qdr_neg_role, arm_rast_au_qdr));
        add(new ExerciseDependency(arm, armdup));
        add(new ExerciseDependency(ponte, par_ponte));

        // ===============================================================================================
        // Workouts
        // ===============================================================================================
        Workout workout1 = add(new Workout("Workout 1"));
        Workout workout2 = add(new Workout("Workout 2"));

        // ===============================================================================================
        // Workout Items
        // ===============================================================================================
        add(new WorkoutItem(0, workout1, qdr));
        add(new WorkoutItem(1, workout1, qdr_neg_role));
        add(new WorkoutItem(2, workout1, esq_qdr_neg_role));

        add(new WorkoutItem(0, workout2, ponte));
        add(new WorkoutItem(1, workout2, esq_ponte));
        add(new WorkoutItem(2, workout2, comp_esq_ponte));


    }
}
