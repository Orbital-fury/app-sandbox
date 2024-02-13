package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeEntity;

@Service
public class PcElementTypeMapper {

    public PcElementTypeEntity dtoToEntity(PcElementType pcElementType) {
        return new PcElementTypeEntity(
                pcElementType.getId(),
                pcElementType.getName(),
                pcElementType.getCode(),
                null,
                null);
    }

    public PcElementType entityToDto(PcElementTypeEntity pcElementTypeEntity) {
        return new PcElementType(
                pcElementTypeEntity.getId(),
                pcElementTypeEntity.getName(),
                pcElementTypeEntity.getCode());
    }

}
