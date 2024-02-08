package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcConstraintMapper;

@Service
public class PcConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;
    @Autowired
    private PcConstraintMapper pcConstraintMapper;

    public List<PcConstraint> getAllPcConstraints() {
        List<PcConstraintEntity> pcConstraintEntities = pcConstraintRepository.findAll();
        return pcConstraintEntities.stream()
                .map(entity -> pcConstraintMapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

    public PcConstraint getPcConstraint(int constraintId) {
        return pcConstraintRepository.findById(constraintId)
                .map(entity -> pcConstraintMapper.entityToDto(entity))
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + constraintId));
    }

    public PcConstraint savePcConstraint(@NonNull PcConstraint newPcConstraint) {
        PcConstraintEntity pcConstraintEntity = pcConstraintMapper.dtoToEntity(newPcConstraint);
        pcConstraintRepository.save(pcConstraintEntity);
        return newPcConstraint;
    }

    public PcConstraint updatePcConstraint(@NonNull PcConstraint pcConstraint) {
        int pcConstraintId = pcConstraint.getId();
        pcConstraintRepository.findById(pcConstraintId)
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + pcConstraintId));
        return savePcConstraint(pcConstraint);

    }

    @Transactional
    public PcConstraint deletePcConstraint(int pcConstraintId) {
        PcConstraintEntity pcConstraintEntity = pcConstraintRepository.findById(pcConstraintId)
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + pcConstraintId));
        pcConstraintRepository.delete(pcConstraintEntity);
        return pcConstraintMapper.entityToDto(pcConstraintEntity);
    }

}
