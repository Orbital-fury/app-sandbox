package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PcConstraintWithoutValue {

    private int id;
    private String name;
    private String code;
    private PcConstraintType type;

    public static PcConstraintWithoutValue fromEntity(PcConstraintEntity pcConstraintEntity) {
        return new PcConstraintWithoutValue(pcConstraintEntity.getId(), pcConstraintEntity.getName(),
                pcConstraintEntity.getCode(), pcConstraintEntity.getType());
    }

}
