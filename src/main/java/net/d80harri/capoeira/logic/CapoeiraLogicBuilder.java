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

/**
 * Created by d80harri on 03.09.16.
 */
public class CapoeiraLogicBuilder {

    private final static IMapper<Vertex, ExerciseDependencyDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<Vertex, ExerciseDependencyDto>(ExerciseDependencyDto.class) {
        @Override
        protected void mapInto(Vertex from, ExerciseDependencyDto to) {
            to.setId(from.getId());
            to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
            to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
        }
    };

    private final Map<Class, IBusinessLogic> businessLogicMap = new HashMap<>();
    private final ExerciseLogic exerciseLogic;
    private final ExerciseDependencyLogic exerciseDependencyLogic;
    private final ExerciseLogLogic exerciseLogLogic;

    public <T extends CapoeiraDto, U extends CapoeiraEntity> CapoeiraLogicBuilder(CapoeiraDalBuilder dalBuilder) {
        IMapper<ExerciseDto, Word> exerciseDto2EntityMapper = new BaseMapper<ExerciseDto, Word>(Word.class) {
            @Override
            protected void mapInto(ExerciseDto from, Word to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        BaseMapper<Word, ExerciseDto> exerciseEntity2DtoMapper = new BaseMapper<Word, ExerciseDto>(ExerciseDto.class) {
            @Override
            protected void mapInto(Word from, ExerciseDto to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        IMapper<ExerciseDependencyDto, Vertex> exerciseDependencyDto2EntityMapper = new BaseMapper<ExerciseDependencyDto, Vertex>(Vertex.class) {
            @Override
            protected void mapInto(ExerciseDependencyDto from, Vertex to) {
                to.setId(from.getId());
                to.setPredecessor(dalBuilder.getSession().getReference(BaseWord.class, from.getPredecessor().getId()));
                to.setSuccessor(dalBuilder.getSession().getReference(BaseWord.class, from.getSuccessor().getId()));
            }
        };

        IMapper<Vertex, ExerciseDependencyDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<Vertex, ExerciseDependencyDto>(ExerciseDependencyDto.class) {
            @Override
            protected void mapInto(Vertex from, ExerciseDependencyDto to) {
                to.setId(from.getId());
                to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
                to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
            }
        };

        IMapper<ExerciseLogDto,ElementLog> exerciseLogDto2EntityMapper = new BaseMapper<ExerciseLogDto, ElementLog>(ElementLog.class) {
            @Override
            protected void mapInto(ExerciseLogDto from, ElementLog to) {
                to.setTimestamp(from.getTimestamp());
                to.setWord(dalBuilder.getSession().getReference(BaseWord.class, from.getExercise().getId()));
                to.setQuality(from.getQuality());
                to.setId(from.getId());
            }
        };
        IMapper<ElementLog,ExerciseLogDto> exerciseLogEntity2DtoMapper = new BaseMapper<ElementLog, ExerciseLogDto>(ExerciseLogDto.class) {
            @Override
            protected void mapInto(ElementLog from, ExerciseLogDto to) {
                to.setId(from.getId());
                to.setExercise(ToOne.valueOf(from.getWord().getId()));
                to.setQuality(from.getQuality());
                to.setTimestamp(from.getTimestamp());
            }
        };

        BusinessLogicSupport<ExerciseDto, Word> exerciseBLSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseDto2EntityMapper, exerciseEntity2DtoMapper);
        BusinessLogicSupport<ExerciseDependencyDto, Vertex> exerciseDependencyLogicSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseDependencyDto2EntityMapper, exerciseDependencyEntity2DtoMapper);
        BusinessLogicSupport<ExerciseLogDto,ElementLog> exerciseLogLogicSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseLogDto2EntityMapper, exerciseLogEntity2DtoMapper);

        this.exerciseLogic = add(ExerciseDto.class, new ExerciseLogic(exerciseBLSupport));
        this.exerciseDependencyLogic = add(ExerciseDependencyDto.class, new ExerciseDependencyLogic(exerciseDependencyLogicSupport));
        this.exerciseLogLogic = add(ExerciseLogDto.class, new ExerciseLogLogic(exerciseLogLogicSupport, dalBuilder.getDao()));
    }

    public <U extends CapoeiraDto, T extends IBusinessLogic<U>> T getLogic(Class<U> type) {
        T result = (T) businessLogicMap.get(type);
        if (result == null) {
            throw new IllegalStateException("No instance of businesslogic for " + type.getName() + " found");
        }
        return result;
    }

    public void persist(CapoeiraDto dto1, CapoeiraDto dto2, CapoeiraDto... moreDtos) {
        persist(dto1);
        persist(dto2);

        for (CapoeiraDto i : moreDtos) {
            persist(i);
        }
    }

    public <T extends CapoeiraDto> T persist(T dto) {
        IBusinessLogic<T> logic = (IBusinessLogic<T>) getLogic(dto.getClass());
        return logic.persist(dto);
    }

    private <U extends CapoeiraDto, T extends IBusinessLogic<U>> T add(Class<U> type, T logic) {
        businessLogicMap.put(type, logic);
        return logic;
    }

}
