package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.FactoryEntity;

@Mapper(uses = MachineWithoutFactoryMapper.class)
public interface FactoryMapper {
    
    Factory entityToDto(FactoryEntity entity);

    // FactoryEntity dtoToEntity(Factory dto);
}
