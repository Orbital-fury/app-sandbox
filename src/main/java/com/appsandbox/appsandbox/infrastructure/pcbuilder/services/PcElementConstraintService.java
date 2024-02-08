package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementConstraintMapper;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementConstraintMapper pcElementConstraintMapper;

    public List<PcElementConstraintEntity> getElementConstraintEntities(int pcElementId) {
        return pcElementConstraintRepository.findByElementId(pcElementId);
    }

    public List<PcElementConstraint> getElementConstraints(int elementId) {
        List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository
                .findByElementId(elementId);
        return elementConstraintEntities.stream()
                .map(entity -> pcElementConstraintMapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

}
