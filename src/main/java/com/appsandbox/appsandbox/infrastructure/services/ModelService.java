package com.appsandbox.appsandbox.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.entities.Model;
import com.appsandbox.appsandbox.infrastructure.database.entities.ModelEntity;
import com.appsandbox.appsandbox.infrastructure.database.repositories.ModelRepository;
import com.appsandbox.appsandbox.infrastructure.mapper.ModelMapper;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Model> getAllModels() {
        List<ModelEntity> entityList = modelRepository.findAll();
        List<Model> modelList = new ArrayList<>();
        for (ModelEntity modelEntity : entityList) {
            Model entityToDto = modelMapper.entityToDto(modelEntity);
            modelList.add(entityToDto);
        }
        return modelList;
    }

}
