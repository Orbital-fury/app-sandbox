package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;

public class PcElementConstraintMapper {

    @Autowired
    private PcConstraintMapper pcConstraintMapper;

    public PcElementConstraint entityToDto(PcElementConstraintEntity pcElementConstraintEntity) {
        return new PcElementConstraint(
                pcElementConstraintEntity.getElementId(),
                pcElementConstraintEntity.getConstraintId(),
                pcElementConstraintEntity.getValue(),
                pcConstraintMapper.entityToDto(pcElementConstraintEntity.getPcConstraint()));
    }

    public PcElementConstraintEntity dtoToEntity(PcElementConstraint pcElementConstraint) {
        return new PcElementConstraintEntity(
                pcElementConstraint.getElementId(),
                pcElementConstraint.getConstraintId(),
                pcElementConstraint.getValue(),
                null,
                null);
    }

}
