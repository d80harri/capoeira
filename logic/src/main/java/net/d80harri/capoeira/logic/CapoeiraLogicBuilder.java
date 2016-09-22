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

    private final static IMapper<Vertex, VertexDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<Vertex, VertexDto>(VertexDto.class) {
        @Override
        protected void mapInto(Vertex from, VertexDto to) {
            to.setId(from.getId());
            to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
            to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
        }
    };

    private final Map<Class, IBusinessLogic> businessLogicMap = new HashMap<>();
    private final VertexLogic vertexLogic;
    private final ElementLogLogic elementLogLogic;
    private final BaseWordLogic baseWordLogic;

    public <T extends CapoeiraDto, U extends CapoeiraEntity> CapoeiraLogicBuilder(CapoeiraDalBuilder dalBuilder) {
        IMapper<WordDto, Word> exerciseDto2EntityMapper = new BaseMapper<WordDto, Word>(Word.class) {
            @Override
            protected void mapInto(WordDto from, Word to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        BaseMapper<Word, WordDto> exerciseEntity2DtoMapper = new BaseMapper<Word, WordDto>(WordDto.class) {
            @Override
            protected void mapInto(Word from, WordDto to) {
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
                to.setId(from.getId());
            }
        };

        IMapper<VertexDto, Vertex> exerciseDependencyDto2EntityMapper = new BaseMapper<VertexDto, Vertex>(Vertex.class) {
            @Override
            protected void mapInto(VertexDto from, Vertex to) {
                to.setId(from.getId());
                to.setPredecessor(dalBuilder.getSession().getReference(BaseWord.class, from.getPredecessor().getId()));
                to.setSuccessor(dalBuilder.getSession().getReference(BaseWord.class, from.getSuccessor().getId()));
            }
        };

        IMapper<Vertex, VertexDto> exerciseDependencyEntity2DtoMapper = new BaseMapper<Vertex, VertexDto>(VertexDto.class) {
            @Override
            protected void mapInto(Vertex from, VertexDto to) {
                to.setId(from.getId());
                to.setPredecessor(ToOne.valueOf(from.getPredecessor().getId()));
                to.setSuccessor(ToOne.valueOf(from.getSuccessor().getId()));
            }
        };

        IMapper<ElementLogDto,ElementLog> exerciseLogDto2EntityMapper = new BaseMapper<ElementLogDto, ElementLog>(ElementLog.class) {
            @Override
            protected void mapInto(ElementLogDto from, ElementLog to) {
                to.setTimestamp(from.getTimestamp());
                to.setWord(dalBuilder.getSession().getReference(Word.class, from.getWord().getId()));
                to.setQuality(from.getQuality());
                to.setId(from.getId());
            }
        };
        IMapper<ElementLog,ElementLogDto> exerciseLogEntity2DtoMapper = new BaseMapper<ElementLog, ElementLogDto>(ElementLogDto.class) {
            @Override
            protected void mapInto(ElementLog from, ElementLogDto to) {
                to.setId(from.getId());
                to.setWord(ToOne.valueOf(from.getWord().getId()));
                to.setQuality(from.getQuality());
                to.setTimestamp(from.getTimestamp());
            }
        };

        IMapper<BaseWordDto,BaseWord> baseWordDto2EntityMapper = new BaseMapper<BaseWordDto, BaseWord>(BaseWord.class){

            @Override
            protected void mapInto(BaseWordDto from, BaseWord to) {
                to.setId(from.getId());
                to.setHints(to.getHints());
                to.setTitle(from.getTitle());
            }
        };
        IMapper<BaseWord, BaseWordDto> baseWordEntity2DtoMapper = new BaseMapper<BaseWord, BaseWordDto>(BaseWordDto.class) {

            @Override
            protected void mapInto(BaseWord from, BaseWordDto to) {
                to.setId(from.getId());
                to.setTitle(from.getTitle());
                to.setHints(from.getHints());
            }
        };

        BusinessLogicSupport<WordDto, Word> exerciseBLSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseDto2EntityMapper, exerciseEntity2DtoMapper);
        BusinessLogicSupport<VertexDto, Vertex> exerciseDependencyLogicSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseDependencyDto2EntityMapper, exerciseDependencyEntity2DtoMapper);
        BusinessLogicSupport<ElementLogDto,ElementLog> exerciseLogLogicSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), exerciseLogDto2EntityMapper, exerciseLogEntity2DtoMapper);
        BusinessLogicSupport<BaseWordDto, BaseWord> baseWordLogicSupport = new BusinessLogicSupport<>(dalBuilder.getDao(), baseWordDto2EntityMapper, baseWordEntity2DtoMapper);

        this.vertexLogic = add(VertexDto.class, new VertexLogic(exerciseDependencyLogicSupport));
        this.elementLogLogic = add(ElementLogDto.class, new ElementLogLogic(exerciseLogLogicSupport, dalBuilder.getDao()));
        this.baseWordLogic = add(BaseWordDto.class, new BaseWordLogic(baseWordLogicSupport));
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
