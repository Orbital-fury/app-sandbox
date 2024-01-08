package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.ModelWithoutBrand;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.ModelEntity;

@Mapper
public interface ModelWithoutBrandMapper {

    ModelWithoutBrand entityToDto(ModelEntity entity);

}
