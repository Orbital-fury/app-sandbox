package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.BrandWithoutModels;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.BrandEntity;

@Mapper
public interface BrandWithoutModelsMapper {

    BrandWithoutModels entityToDto(BrandEntity entity);

}
