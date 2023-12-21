package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;

@Mapper(uses = MachineWithoutFactoryMapper.class)
public interface FactoryMapper {
    
    Factory entityToDto(FactoryEntity entity);

    // FactoryEntity dtoToEntity(Factory dto);
}
