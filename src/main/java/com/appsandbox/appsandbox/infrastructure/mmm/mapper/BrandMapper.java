package com.appsandbox.appsandbox.infrastructure.mmm.mapper;

import org.mapstruct.Mapper;

import com.appsandbox.appsandbox.domain.mmm.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.BrandEntity;

@Mapper(uses = ModelWithoutBrandMapper.class)
public interface BrandMapper {

    Brand entityToDto(BrandEntity entity);

}
