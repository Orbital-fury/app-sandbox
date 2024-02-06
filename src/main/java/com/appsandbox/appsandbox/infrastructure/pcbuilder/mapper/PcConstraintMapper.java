package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;

@Service
public class PcConstraintMapper {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;

    public PcConstraintEntity dtoToEntity(PcConstraintWithoutValue pcConstraint) {
        int pcConstraintId = pcConstraint.getId();
        List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository
                .findByConstraintId(pcConstraintId);
        return new PcConstraintEntity(
                pcConstraintId,
                pcConstraint.getName(),
                pcConstraint.getCode(),
                pcConstraint.getType(),
                elementConstraintEntities);
    }

    public PcConstraintWithoutValue entityToDtoWithoutValue(PcConstraintEntity pcConstraintEntity) {
        return new PcConstraintWithoutValue(
                pcConstraintEntity.getId(),
                pcConstraintEntity.getName(),
                pcConstraintEntity.getCode(),
                pcConstraintEntity.getType());
    }

}
