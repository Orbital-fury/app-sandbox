package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.MachineWithoutFactory;
import com.appsandbox.appsandbox.infrastructure.database.entities.MachineEntity;

@Mapper
public interface MachineWithoutFactoryMapper {

    MachineWithoutFactory entityToDto(MachineEntity entity);

}
