package com.appsandbox.appsandbox.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.entities.Brand;
import com.appsandbox.appsandbox.infrastructure.database.entities.BrandEntity;
import com.appsandbox.appsandbox.infrastructure.database.repositories.BrandRepository;
import com.appsandbox.appsandbox.infrastructure.mapper.BrandMapper;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandMapper brandMapper;

    public List<Brand> getAllBrands() {
        List<BrandEntity> entityList = brandRepository.findAll();
        List<Brand> dtoList = new ArrayList<>();
        for (BrandEntity entity : entityList) {
            Brand entityToDto = brandMapper.entityToDto(entity);
            dtoList.add(entityToDto);
        }
        return dtoList;
    }

}
