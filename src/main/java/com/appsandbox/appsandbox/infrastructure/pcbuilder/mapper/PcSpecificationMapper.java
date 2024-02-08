package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcSpecificationEntity;

@Mapper(uses = PcElementSpecificationMapper.class)
public interface PcSpecificationMapper {

    @Mapping(target = "pcElementSpecifications", source = "pcElementSpecifications", qualifiedByName = "toPcElementSpecificationDto")
    PcSpecification entityToDto(PcSpecificationEntity pcSpecificationEntity);

    @Mapping(target = "pcElementSpecifications", source = "pcElementSpecifications", qualifiedByName = "toPcElementSpecificationEntity")
    PcSpecificationEntity dtoToEntity(PcSpecification pcSpecification);

}
