package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementType;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementTypeConstraint;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementTypeConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementTypeRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcConstraintMapper;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementTypeMapper;

@Service
public class PcElementTypeConstraintService {

    @Autowired
    private PcElementTypeConstraintRepository pcElementTypeConstraintRepository;
    @Autowired
    private PcElementTypeRepository pcElementTypeRepository;
    @Autowired
    private PcConstraintMapper pcConstraintMapper;
    @Autowired
    private PcElementTypeMapper pcElementTypeMapper;

    public List<PcConstraint> getPcElementTypeConstraints(int pcElementTypeId) {
        PcElementTypeEntity pcElementTypeEntity = pcElementTypeRepository.findById(pcElementTypeId)
                .orElseThrow(() -> new NoDataFoundException("PC element type not found for id:" + pcElementTypeId));
        return pcElementTypeConstraintRepository.findByPcElementType(pcElementTypeEntity).stream()
                .map(entity -> pcConstraintMapper.entityToDto(entity.getPcConstraint()))
                .collect(Collectors.toList());
    }

    public List<PcElementTypeConstraint> getAllPcElementTypeConstraints() {
        Map<PcElementTypeEntity, List<PcElementTypeConstraintEntity>> groupedByElementType = pcElementTypeConstraintRepository
                .findAll().stream()
                .collect(Collectors.groupingBy(PcElementTypeConstraintEntity::getPcElementType));

        return groupedByElementType.entrySet().stream()
                .map(entry -> {
                    PcElementType pcElementType = pcElementTypeMapper.entityToDto(entry.getKey());
                    List<PcConstraint> pcConstraints = entry.getValue().stream()
                            .map(PcElementTypeConstraintEntity::getPcConstraint)
                            .map(pcConstraintMapper::entityToDto)
                            .collect(Collectors.toList());
                    return new PcElementTypeConstraint(pcElementType, pcConstraints);
                })
                .collect(Collectors.toList());
    }

}
