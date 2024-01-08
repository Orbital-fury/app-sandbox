package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.Model;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.ModelEntity;

@Mapper(uses = BrandWithoutModelsMapper.class)
public interface ModelMapper {

    Model entityToDto(ModelEntity entity);

}
