package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.ModelWithoutBrand;
import com.appsandbox.appsandbox.infrastructure.database.entities.ModelEntity;

@Mapper
public interface ModelWithoutBrandMapper {

    ModelWithoutBrand entityToDto(ModelEntity entity);

}
