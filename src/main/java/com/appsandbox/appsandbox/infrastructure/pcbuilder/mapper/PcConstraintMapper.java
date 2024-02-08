package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;

public class PcConstraintMapper {

    public PcConstraint entityToDto(PcConstraintEntity pcConstraintEntity) {
        return new PcConstraint(
                pcConstraintEntity.getId(),
                pcConstraintEntity.getName(),
                pcConstraintEntity.getCode(),
                pcConstraintEntity.getType());
    }

    public PcConstraintEntity dtoToEntity(PcConstraint pcConstraint) {
        return new PcConstraintEntity(
                pcConstraint.getId(),
                pcConstraint.getName(),
                pcConstraint.getCode(),
                pcConstraint.getType(),
                null);
    }

}
