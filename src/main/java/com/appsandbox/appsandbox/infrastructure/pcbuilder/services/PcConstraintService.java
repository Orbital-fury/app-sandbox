package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcConstraintRepository;

@Service
public class PcConstraintService {

    @Autowired
    private PcConstraintRepository pcConstraintRepository;

    public List<PcConstraintWithoutValue> getAllPcConstraintWithoutValue() {
        List<PcConstraintEntity> pcConstraintEntities = pcConstraintRepository.findAll();
        return pcConstraintEntities.stream()
                .map(PcConstraintWithoutValue::fromEntity)
                .collect(Collectors.toList());
    }

}
