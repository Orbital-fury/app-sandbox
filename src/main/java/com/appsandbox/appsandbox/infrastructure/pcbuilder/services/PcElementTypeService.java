package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementTypeRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementTypeMapper;

@Service
public class PcElementTypeService {

    @Autowired
    private PcElementTypeRepository pcElementTypeRepository;
    @Autowired
    private PcElementTypeMapper pcElementTypeMapper;

    public List<PcElementType> getAllPcElementTypes() {
        return pcElementTypeRepository.findAll().stream()
                .map(entity -> pcElementTypeMapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

}
