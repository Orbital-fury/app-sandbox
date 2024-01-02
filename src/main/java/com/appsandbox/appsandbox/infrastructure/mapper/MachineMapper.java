package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.database.entities.MachineEntity;

@Mapper(uses = FactoryWithoutMachinesMapper.class)
public interface MachineMapper {

    Machine entityToDto(MachineEntity entity);

}
