package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.MachineEntity;

@Mapper(uses = FactoryWithoutMachinesMapper.class)
public interface MachineMapper {

    Machine entityToDto(MachineEntity entity);

}
