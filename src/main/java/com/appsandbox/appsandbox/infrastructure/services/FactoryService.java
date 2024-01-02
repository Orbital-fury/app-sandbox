package com.appsandbox.appsandbox.infrastructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;
import com.appsandbox.appsandbox.infrastructure.database.repositories.FactoryRepository;
import com.appsandbox.appsandbox.infrastructure.mapper.FactoryMapper;

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

    public Optional<Factory> getFactory(int id) {
        Optional<FactoryEntity> factory = factoryRepository.findById(id);
        if (factory.isPresent()) {
            return Optional.ofNullable(factoryMapper.entityToDto(factory.get()));
        } else {
            return Optional.empty();
        }
    }

}
