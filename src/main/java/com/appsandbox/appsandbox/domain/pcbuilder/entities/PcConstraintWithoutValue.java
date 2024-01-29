package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PcConstraintWithoutValue {

    private int id;
    private String name;
    private String code;
    private PcConstraintType type;

    public PcConstraintEntity toEntity() {
        return new PcConstraintEntity(this.id, this.name, this.code, this.type);
    }

}
