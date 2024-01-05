package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.BrandWithoutModels;
import com.appsandbox.appsandbox.infrastructure.database.entities.BrandEntity;

@Mapper
public interface BrandWithoutModelsMapper {

    BrandWithoutModels entityToDto(BrandEntity entity);

}
