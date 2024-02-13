package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithValues;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutConstraintsAndSpecs;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutSpecs;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecificationWithValues;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;

@Service
public class PcElementMapper {

    @Autowired
    private PcElementConstraintMapper pcElementConstraintMapper;
    @Autowired
    private PcElementSpecificationMapper pcElementSpecificationMapper;
    @Autowired
    private PcElementTypeMapper pcElementTypeMapper;

    public PcElementWithoutConstraintsAndSpecs entityToDtoWithoutConstraintsAndSpecs(PcElementEntity pcElementEntity) {
        return new PcElementWithoutConstraintsAndSpecs(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementTypeMapper.entityToDto(pcElementEntity.getPcElementType()));
    }

    public PcElementWithoutSpecs entityToDtoWithoutSpecs(PcElementEntity pcElementEntity) {
        List<PcConstraintWithValues> pcElementConstraints = pcElementConstraintMapper
                .entitiesToDtos(pcElementEntity.getPcElementConstraints());
        return new PcElementWithoutSpecs(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementTypeMapper.entityToDto(pcElementEntity.getPcElementType()),
                pcElementConstraints);
    }

    public PcElement entityToDto(PcElementEntity pcElementEntity) {
        List<PcConstraintWithValues> pcElementConstraints = pcElementConstraintMapper
                .entitiesToDtos(pcElementEntity.getPcElementConstraints());
        List<PcSpecificationWithValues> pcElementSpecifications = pcElementSpecificationMapper
                .entitiesToDtos(pcElementEntity.getPcElementSpecifications());
        return new PcElement(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementTypeMapper.entityToDto(pcElementEntity.getPcElementType()),
                pcElementConstraints,
                pcElementSpecifications);
    }

    public PcElementEntity dtoToEntity(PcElement pcElement) {

        int pcElementId = pcElement.getId();
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElementConstraintMapper
                .dtosToEntities(pcElementId, pcElement.getConstraints());
        List<PcElementSpecificationEntity> pcElementSpecificationEntities = pcElementSpecificationMapper
                .dtoToEntities(pcElementId, pcElement.getSpecifications());
        return new PcElementEntity(
                pcElementId,
                pcElement.getBrand(),
                pcElement.getModel(),
                pcElement.getPrice(),
                pcElement.getImg(),
                pcElementTypeMapper.dtoToEntity(pcElement.getType()),
                pcElementConstraintEntities,
                pcElementSpecificationEntities);
    }

    public PcElementEntity dtoToEntity(PcElementWithoutConstraintsAndSpecs pcElement) {
        return new PcElementEntity(
                pcElement.getId(),
                pcElement.getBrand(),
                pcElement.getModel(),
                pcElement.getPrice(),
                pcElement.getImg(),
                pcElementTypeMapper.dtoToEntity(pcElement.getType()),
                null,
                null);
    }

}
