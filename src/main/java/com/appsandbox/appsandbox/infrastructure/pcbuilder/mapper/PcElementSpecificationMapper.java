package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;

@Mapper(uses = { PcElementMapper.class, PcSpecificationMapper.class })
public interface PcElementSpecificationMapper {

    @Mapping(target = "pcSpecification.pcElementSpecifications", ignore = true)
    @Mapping(target = "pcElement.pcElementConstraints", ignore = true)
    @Mapping(target = "pcElement.pcElementSpecifications", ignore = true)
    PcElementSpecification entityToDto(PcElementSpecificationEntity pcElementSpecificationEntity);

    @Mapping(target = "pcSpecification.pcElementSpecifications", ignore = true)
    @Mapping(target = "pcElement.pcElementConstraints", ignore = true)
    @Mapping(target = "pcElement.pcElementSpecifications", ignore = true)
    PcElementSpecificationEntity dtoToEntity(PcElementSpecification pcElementSpecification);

    @Named("toPcElementSpecificationDto")
    default List<PcElementSpecification> toPcElementSpecificationDto(List<PcElementSpecificationEntity> source) {
        return source
                .stream()
                .map(this::entityToDto)
                .peek(dto -> {
                    dto.setPcElement(null);
                    dto.setPcSpecification(null);
                })
                .collect(Collectors.toList());
    }

    @Named("toPcElementSpecificationEntity")
    default List<PcElementSpecificationEntity> toPcElementSpecificationEntity(List<PcElementSpecification> source) {
        return source
                .stream()
                .map(this::dtoToEntity)
                .peek(entity -> {
                    entity.setPcElement(null);
                    entity.setPcSpecification(null);
                })
                .collect(Collectors.toList());
    }

}
