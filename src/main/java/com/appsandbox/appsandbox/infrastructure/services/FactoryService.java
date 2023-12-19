package com.appsandbox.appsandbox.infrastructure.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.infrastructure.database.repositories.FactoryRepository;
import com.appsandbox.appsandbox.infrastructure.mapper.FactoryMapper;

@Service
public class FactoryService {

    Logger log = LoggerFactory.getLogger(FactoryService.class);

    @Autowired
    private FactoryRepository factoryRepository;
    @Autowired
    private FactoryMapper factoryMapper;

    // public List<Factory> getAllFactories() {
    // List<FactoryEntity> entityList = factoryRepository.findAll();
    // log.info("factory list :" + entityList.toString());
    // List<Factory> factoryList = new ArrayList<>();
    // for (FactoryEntity factoryEntity : entityList) {
    // Factory entityToDto = factoryMapper.entityToDto(factoryEntity);
    // log.info("factoryEntity :" + factoryEntity.toString());
    // log.info("factory dto created :" + entityToDto.toString());
    // factoryList.add(entityToDto);
    // }

    // return factoryList;
    // }

}
