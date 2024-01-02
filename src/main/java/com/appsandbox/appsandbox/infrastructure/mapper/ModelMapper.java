package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Model;
import com.appsandbox.appsandbox.infrastructure.database.entities.ModelEntity;

@Mapper
public interface ModelMapper {

    Model entityToDto(ModelEntity entity);

}
