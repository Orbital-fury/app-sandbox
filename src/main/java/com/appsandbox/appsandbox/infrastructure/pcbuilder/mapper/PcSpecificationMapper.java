package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcSpecificationEntity;

@Service
public class PcSpecificationMapper {

    public PcSpecification entityToDto(PcSpecificationEntity pcSpecificationEntity) {
        return new PcSpecification(
                pcSpecificationEntity.getId(),
                pcSpecificationEntity.getName(),
                pcSpecificationEntity.getCode());
    }

    public PcSpecificationEntity dtoToEntity(PcSpecification pcSpecification) {
        return new PcSpecificationEntity(
                pcSpecification.getId(),
                pcSpecification.getName(),
                pcSpecification.getCode(),
                null);
    }

}
