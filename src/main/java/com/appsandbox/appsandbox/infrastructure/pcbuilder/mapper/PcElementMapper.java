package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutConstraintsAndSpecs;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;

public class PcElementMapper {

    @Autowired
    private PcElementConstraintMapper pcElementConstraintMapper;
    @Autowired
    private PcElementSpecificationMapper pcElementSpecificationMapper;

    public PcElementWithoutConstraintsAndSpecs entityToDtoWithoutConstraintsAndSpecs(PcElementEntity pcElementEntity) {
        return new PcElementWithoutConstraintsAndSpecs(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementEntity.getType());
    }

    public PcElement entityToDto(PcElementEntity pcElementEntity) {
        List<PcElementConstraint> pcElementConstraints = pcElementEntity.getPcElementConstraints().stream()
                .map(entity -> pcElementConstraintMapper.entityToDto(entity))
                .collect(Collectors.toList());
        List<PcElementSpecification> pcElementSpecifications = pcElementEntity.getPcElementSpecifications().stream()
                .map(entity -> pcElementSpecificationMapper.entityToDto(entity))
                .collect(Collectors.toList());
        return new PcElement(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementEntity.getType(),
                pcElementConstraints,
                pcElementSpecifications);
    }

    public PcElementEntity dtoToEntity(PcElement pcElement) {
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElement.getPcElementConstraints().stream()
                .map(dto -> pcElementConstraintMapper.dtoToEntity(dto))
                .collect(Collectors.toList());
        List<PcElementSpecificationEntity> pcElementSpecificationEntities = pcElement.getPcElementSpecifications()
                .stream()
                .map(dto -> pcElementSpecificationMapper.dtoToEntity(dto))
                .collect(Collectors.toList());
        return new PcElementEntity(
                pcElement.getId(),
                pcElement.getBrand(),
                pcElement.getModel(),
                pcElement.getPrice(),
                pcElement.getImg(),
                pcElement.getType(),
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
                pcElement.getType(),
                null,
                null);
    }

}
