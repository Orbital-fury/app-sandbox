package com.appsandbox.appsandbox.infrastructure.mmm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.mmm.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.FactoryEntity;
import com.appsandbox.appsandbox.infrastructure.mmm.database.repositories.FactoryRepository;
import com.appsandbox.appsandbox.infrastructure.mmm.mapper.FactoryMapper;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;
    @Autowired
    private FactoryMapper factoryMapper;

    public List<Factory> getAllFactories() {
        List<FactoryEntity> entityList = factoryRepository.findAll();
        List<Factory> factoryList = new ArrayList<>();
        for (FactoryEntity factoryEntity : entityList) {
            Factory entityToDto = factoryMapper.entityToDto(factoryEntity);
            factoryList.add(entityToDto);
        }
        return factoryList;
    }

    public Factory getFactory(int id) {
        Optional<FactoryEntity> optFactoryEntity = factoryRepository.findById(id);
        if (optFactoryEntity.isPresent()) {
            return factoryMapper.entityToDto(optFactoryEntity.get());
        } else {
            throw new NoDataFoundException("Factory with id=" + id + " not found!!!");
        }

    }

}
