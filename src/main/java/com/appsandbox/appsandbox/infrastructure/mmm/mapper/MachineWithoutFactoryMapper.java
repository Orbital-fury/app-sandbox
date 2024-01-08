package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.MachineWithoutFactory;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.MachineEntity;

@Mapper
public interface MachineWithoutFactoryMapper {

    MachineWithoutFactory entityToDto(MachineEntity entity);

}
