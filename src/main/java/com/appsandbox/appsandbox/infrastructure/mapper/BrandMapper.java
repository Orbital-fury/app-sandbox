package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.appsandbox.appsandbox.domain.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.database.entities.BrandEntity;

@Mapper
public interface BrandMapper {
    
    Brand entityToDto(BrandEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "models", ignore = true)
    BrandEntity dtoToEntity(Brand dto);

}
