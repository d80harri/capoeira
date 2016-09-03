package net.d80harri.capoeira.logic;

import net.d80harri.capoeira.dal.CapoeiraDalBuilder;
import net.d80harri.capoeira.dal.core.CapoeiraEntity;
import net.d80harri.capoeira.dal.data.*;
import net.d80harri.capoeira.logic.core.BusinessLogicSupport;
import net.d80harri.capoeira.logic.core.CapoeiraDto;
import net.d80harri.capoeira.logic.core.IBusinessLogic;
import net.d80harri.capoeira.logic.core.ToOne;
import net.d80harri.capoeira.logic.data.*;
import net.d80harri.capoeira.logic.service.*;
import net.d80harri.capoeira.mapper.BaseMapper;
import net.d80harri.capoeira.mapper.IMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by d80harri on 03.09.16.
 */
public class CapoeiraLogicBuilder {

    private final static IMapper<ExerciseDependency, ExerciseDependencyDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<ExerciseDependency, ExerciseDependencyDto>(ExerciseDependencyDto.class) {
        @Override
        protected void mapInto(ExerciseDependency from, ExerciseDependencyDto to) {
            to.setId(from.getId());
            to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
            to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
        }
    };

    private final Map<Class, IBusinessLogic> businessLogicMap = new HashMap<>();
    private final ExerciseLogic exerciseLogic;
    private final ExerciseDependencyLogic exerciseDependencyLogic;
    private final WorkoutLogic workoutLogic;
    private final WorkoutItemLogic workoutItemLogic;
    private final ExerciseLogLogic exerciseLogLogic;

    public <T extends CapoeiraDto, U extends CapoeiraEntity> CapoeiraLogicBuilder(CapoeiraDalBuilder dalBuilder) {
        IMapper<ExerciseDto, Exercise> exerciseDto2EntityMapper = new BaseMapper<ExerciseDto, Exercise>(Exercise.class) {
            @Override
            protected void mapInto(ExerciseDto from, Exercise to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        BaseMapper<Exercise, ExerciseDto> exerciseEntity2DtoMapper = new BaseMapper<Exercise, ExerciseDto>(ExerciseDto.class) {
            @Override
            protected void mapInto(Exercise from, ExerciseDto to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        IMapper<ExerciseDependencyDto, ExerciseDependency> exerciseDependencyDto2EntityMapper = new BaseMapper<ExerciseDependencyDto, ExerciseDependency>(ExerciseDependency.class) {
            @Override
            protected void mapInto(ExerciseDependencyDto from, ExerciseDependency to) {
                to.setId(from.getId());
                to.setPredecessor(dalBuilder.getSession().getReference(Exercise.class, from.getPredecessor().getId()));
                to.setSuccessor(dalBuilder.getSession().getReference(Exercise.class, from.getSuccessor().getId()));
            }
        };

        IMapper<ExerciseDependency, ExerciseDependencyDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<ExerciseDependency, ExerciseDependencyDto>(ExerciseDependencyDto.class) {
            @Override
            protected void mapInto(ExerciseDependency from, ExerciseDependencyDto to) {
                to.setId(from.getId());
                to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
                to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
            }
        };

        IMapper<WorkoutDto,Workout> workoutDto2EntityMapper = new BaseMapper<WorkoutDto, Workout>(Workout.class) {
            @Override
            protected void mapInto(WorkoutDto from, Workout to) {
                to.setId(from.getId());
                to.setTitle(from.getTitle());
            }
        };
        IMapper<Workout,WorkoutDto> workoutEntity2DtoMapper = new BaseMapper<Workout, WorkoutDto>(WorkoutDto.class) {
            @Override
            protected void mapInto(Workout from, WorkoutDto to) {
                to.setId(from.getId());
                to.setTitle(from.getTitle());
            }
        };
        IMapper<WorkoutItem,WorkoutItemDto> workoutItemEntity2DtoMapper  = new BaseMapper<WorkoutItem, WorkoutItemDto>(WorkoutItemDto.class) {

            @Override
            protected void mapInto(WorkoutItem from, WorkoutItemDto to) {
                to.setId(from.getId());
                to.setExercise(ToOne.valueOf(from.getExercise().getId()));
                to.setSeq(from.getSeq());
                to.setWorkout(ToOne.valueOf(from.getWorkout().getId()));
            }
        };
        IMapper<WorkoutItemDto,WorkoutItem> workoutItemDto2EntityMapper = new BaseMapper<WorkoutItemDto, WorkoutItem>(WorkoutItem.class) {
            @Override
            protected void mapInto(WorkoutItemDto from, WorkoutItem to) {
                to.setId(from.getId());
                to.setSeq(from.getSeq());
                to.setExercise(dalBuilder.getSession().getReference(Exercise.class, from.getExercise().getId()));
                to.setWorkout(dalBuilder.getSession().getReference(Workout.class, from.getWorkout().getId()));
            }
        };
        IMapper<ExerciseLogDto,ExerciseLog> exerciseLogDto2EntityMapper = new BaseMapper<ExerciseLogDto, ExerciseLog>(ExerciseLog.class) {
            @Override
            protected void mapInto(ExerciseLogDto from, ExerciseLog to) {
                to.setTimestamp(from.getTimestamp());
                to.setExercise(dalBuilder.getSession().getReference(Exercise.class, from.getExercise().getId()));
                to.setQuality(from.getQuality());
                to.setEffort(from.getEffort());
                to.setId(from.getId());
            }
        };
        IMapper<ExerciseLog,ExerciseLogDto> exerciseLogEntity2DtoMapper = new BaseMapper<ExerciseLog, ExerciseLogDto>(ExerciseLogDto.class) {
            @Override
            protected void mapInto(ExerciseLog from, ExerciseLogDto to) {
                to.setId(from.getId());
                to.setExercise(ToOne.valueOf(from.getExercise().getId()));
                to.setEffort(from.getEffort());
                to.setQuality(from.getQuality());
                to.setTimestamp(from.getTimestamp());
            }
        };

        BusinessLogicSupport<ExerciseDto, Exercise> exerciseBLSupport = new BusinessLogicSupport<>(dalBuilder.getExerciseDao(), exerciseDto2EntityMapper, exerciseEntity2DtoMapper);
        BusinessLogicSupport<ExerciseDependencyDto, ExerciseDependency> exerciseDependencyLogicSupport = new BusinessLogicSupport<>(dalBuilder.getExerciseDependencyDao(), exerciseDependencyDto2EntityMapper, exerciseDependencyEntity2DtoMapper);
        BusinessLogicSupport<WorkoutDto, Workout> workoutLogicSupport = new BusinessLogicSupport<>(dalBuilder.getWorkoutDao(), workoutDto2EntityMapper, workoutEntity2DtoMapper);
        BusinessLogicSupport<WorkoutItemDto, WorkoutItem> workoutItemLogicSupport = new BusinessLogicSupport<>(dalBuilder.getWorkoutItemDao(), workoutItemDto2EntityMapper, workoutItemEntity2DtoMapper);
        BusinessLogicSupport<ExerciseLogDto,ExerciseLog> exerciseLogLogicSupport = new BusinessLogicSupport<>(dalBuilder.getExerciseLogDao(), exerciseLogDto2EntityMapper, exerciseLogEntity2DtoMapper);

        this.exerciseLogic = add(ExerciseDto.class, new ExerciseLogic(exerciseBLSupport));
        this.exerciseDependencyLogic = add(ExerciseDependencyDto.class, new ExerciseDependencyLogic(exerciseDependencyLogicSupport));
        this.workoutLogic = add(WorkoutDto.class, new WorkoutLogic(workoutLogicSupport));
        this.workoutItemLogic = add(WorkoutItemDto.class, new WorkoutItemLogic(workoutItemLogicSupport));
        this.exerciseLogLogic = add(ExerciseLogDto.class, new ExerciseLogLogic(exerciseLogLogicSupport));
    }

    public <U extends CapoeiraDto, T extends IBusinessLogic<U>> T getLogic(Class<U> type) {
        T result = (T) businessLogicMap.get(type);
        if (result == null) {
            throw new IllegalStateException("No instance of businesslogic for " + type.getName() + " found");
        }
        return result;
    }

    private <U extends CapoeiraDto, T extends IBusinessLogic<U>> T add(Class<U> type, T logic) {
        businessLogicMap.put(type, logic);
        return logic;
    }
}
