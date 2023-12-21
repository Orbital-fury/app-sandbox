package com.appsandbox.appsandbox.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(BrandService.class);

    public List<Brand> getAllBrands() {
        List<BrandEntity> entityList = brandRepository.findAll();
        log.info("****************");
        List<Brand> dtoList = new ArrayList<>();
        for (BrandEntity entity : entityList) {
            log.info(entity.getName());
            Brand entityToDto = brandMapper.entityToDto(entity);
            dtoList.add(entityToDto);
        }
        log.info("****************");
        return dtoList;
    }

}
