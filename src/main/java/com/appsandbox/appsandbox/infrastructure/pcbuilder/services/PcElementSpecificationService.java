package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementSpecificationRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementSpecificationMapper;

@Service
public class PcElementSpecificationService {

    @Autowired
    private PcElementSpecificationRepository pcElementSpecificationRepository;
    @Autowired
    private PcElementSpecificationMapper pcElementSpecificationMapper;

    public List<PcElementSpecificationEntity> getElementSpecificationEntities(int pcElementId) {
        return pcElementSpecificationRepository.findByElementId(pcElementId);
    }

    public List<PcElementSpecification> getElementSpecifications(int elementId) {
        List<PcElementSpecificationEntity> elementSpecificationEntities = pcElementSpecificationRepository
                .findByElementId(elementId);
        return elementSpecificationEntities.stream()
                .map(entity -> pcElementSpecificationMapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

}
