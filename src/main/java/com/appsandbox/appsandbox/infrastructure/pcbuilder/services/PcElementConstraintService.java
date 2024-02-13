package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraintValues;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper.PcElementMapper;

@Service
public class PcElementConstraintService {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementMapper pcElementMapper;

    public List<PcElementConstraintValues> getPcElementAndConstraintValues(int pcConstraintId) {
        List<PcElementConstraintEntity> pcElementConstraintEntities = pcElementConstraintRepository
                .findByConstraintId(pcConstraintId);
    
        return pcElementConstraintEntities.stream()
                .filter(entity -> entity.getConstraintId() == pcConstraintId)
                .collect(Collectors.groupingBy(PcElementConstraintEntity::getPcElement,
                        Collectors.mapping(PcElementConstraintEntity::getValue, Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new PcElementConstraintValues(
                        pcElementMapper.entityToDtoWithoutConstraintsAndSpecs(entry.getKey()),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

}
