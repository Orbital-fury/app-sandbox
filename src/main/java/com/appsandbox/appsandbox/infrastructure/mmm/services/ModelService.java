package com.appsandbox.appsandbox.infrastructure.mmm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.mmm.entities.Model;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoContentException;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.ModelEntity;
import com.appsandbox.appsandbox.infrastructure.mmm.database.repositories.ModelRepository;
import com.appsandbox.appsandbox.infrastructure.mmm.mapper.ModelMapper;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Model> getAllModels() {
        List<ModelEntity> entityList = modelRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoContentException("No models of machine have been retrieved");
        }
        List<Model> modelList = new ArrayList<>();
        for (ModelEntity modelEntity : entityList) {
            Model entityToDto = modelMapper.entityToDto(modelEntity);
            modelList.add(entityToDto);
        }
        return modelList;
    }

}
