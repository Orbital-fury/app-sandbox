package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;

@Mapper(componentModel = "spring")
public interface FactoryMapper {
    Factory entityToDto(FactoryEntity entity);

    FactoryEntity dtoToEntity(Factory dto);
}
