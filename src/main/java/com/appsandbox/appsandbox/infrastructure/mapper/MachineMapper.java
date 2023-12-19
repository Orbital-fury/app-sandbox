package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.database.entities.MachineEntity;

@Mapper
public interface MachineMapper {
    Machine entityToDto(MachineEntity entity);

    MachineEntity dtoToEntity(Machine dto);
}
