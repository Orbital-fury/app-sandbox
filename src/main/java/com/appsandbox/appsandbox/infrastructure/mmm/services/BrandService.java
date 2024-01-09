package com.appsandbox.appsandbox.infrastructure.mmm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.mmm.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoContentException;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.BrandEntity;
import com.appsandbox.appsandbox.infrastructure.mmm.database.repositories.BrandRepository;
import com.appsandbox.appsandbox.infrastructure.mmm.mapper.BrandMapper;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandMapper brandMapper;

    public List<Brand> getAllBrands() {
        List<BrandEntity> entityList = brandRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoContentException("No brands of machine have been retrieved");
        }
        List<Brand> dtoList = new ArrayList<>();
        for (BrandEntity entity : entityList) {
            Brand entityToDto = brandMapper.entityToDto(entity);
            dtoList.add(entityToDto);
        }
        return dtoList;
    }

}
