package com.appsandbox.appsandbox.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.database.entities.BrandEntity;

@Mapper(uses = ModelWithoutBrandMapper.class)
public interface BrandMapper {

    Brand entityToDto(BrandEntity entity);

}
