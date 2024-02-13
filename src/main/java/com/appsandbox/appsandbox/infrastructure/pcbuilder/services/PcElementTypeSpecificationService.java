package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementTypeRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementTypeSpecificationRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcSpecificationMapper;

@Service
public class PcElementTypeSpecificationService {

    @Autowired
    private PcElementTypeSpecificationRepository pcElementTypeSpecificationRepository;
    @Autowired
    private PcElementTypeRepository pcElementTypeRepository;
    @Autowired
    private PcSpecificationMapper pcSpecificationMapper;

    public List<PcSpecification> getPcElementTypeSpecifications(int pcElementTypeId) {
        PcElementTypeEntity pcElementTypeEntity = pcElementTypeRepository.findById(pcElementTypeId)
                .orElseThrow(() -> new NoDataFoundException("PC element type not found for id:" + pcElementTypeId));
        return pcElementTypeSpecificationRepository.findByPcElementType(pcElementTypeEntity).stream()
                .map(entity -> pcSpecificationMapper.entityToDto(entity.getPcSpecification()))
                .collect(Collectors.toList());
    }

}
