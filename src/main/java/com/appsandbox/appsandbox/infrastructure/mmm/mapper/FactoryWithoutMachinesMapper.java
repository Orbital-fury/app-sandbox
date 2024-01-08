package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.FactoryWithoutMachines;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.FactoryEntity;

@Mapper
public interface FactoryWithoutMachinesMapper {

    FactoryWithoutMachines entityToDto(FactoryEntity entity);

}
