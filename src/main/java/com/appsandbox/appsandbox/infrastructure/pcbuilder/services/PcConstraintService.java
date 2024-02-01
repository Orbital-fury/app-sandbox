package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;

@Service
public class PcConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;

    public List<PcConstraintWithoutValue> getAllPcConstraintWithoutValue() {
        List<PcConstraintEntity> pcConstraintEntities = pcConstraintRepository.findAll();
        return pcConstraintEntities.stream()
                .map(entity -> entity.toDto())
                .collect(Collectors.toList());
    }

    public PcConstraintWithoutValue getPcConstraint(int constraintId) {
        return pcConstraintRepository.findById(constraintId)
                .map(entity -> entity.toDto())
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + constraintId));
    }

    public PcConstraintWithoutValue save(PcConstraintWithoutValue newPcConstraint) {
        PcConstraintEntity pcConstraintEntity = newPcConstraint.toEntity();
        if (pcConstraintEntity != null) {
            return pcConstraintRepository.save(pcConstraintEntity).toDto();
        } else {
            throw new IllegalArgumentException("Impossible error! The PC constraint entity is null");
        }
    }

    public PcConstraintWithoutValue update(PcConstraintWithoutValue pcConstraint) {
        int pcConstraintId = pcConstraint.getId();
        pcConstraintRepository.findById(pcConstraintId)
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + pcConstraintId));
        return save(pcConstraint);
    }

    public PcConstraintWithoutValue delete(int pcConstraintId) {
        PcConstraintEntity pcConstraintEntity = pcConstraintRepository.findById(pcConstraintId)
                .orElseThrow(() -> new NoDataFoundException("PC constraint not found for id: " + pcConstraintId));
        pcConstraintRepository.delete(pcConstraintEntity);
        return pcConstraintEntity.toDto();
    }

}
