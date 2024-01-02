package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.FactoryWithoutMachines;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;

@Mapper
public interface FactoryWithoutMachinesMapper {

    FactoryWithoutMachines entityToDto(FactoryEntity entity);

}
