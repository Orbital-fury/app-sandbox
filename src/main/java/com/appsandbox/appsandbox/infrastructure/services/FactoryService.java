package com.appsandbox.appsandbox.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.entities.Factory;
import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;
import com.appsandbox.appsandbox.infrastructure.database.repositories.FactoryRepository;

@Service
public class FactoryService {

    private FactoryRepository factoryRepository;

    public FactoryService(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    public List<Factory> getAllFactories() {
        List<FactoryEntity> entityList = factoryRepository.findAll();

        List<Factory> factoryList = entityList.stream()
                .map(FactoryEntity::toDto)
                .collect(Collectors.toList());

        return factoryList;
    }

}
