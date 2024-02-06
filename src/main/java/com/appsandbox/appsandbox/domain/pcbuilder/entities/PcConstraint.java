package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.Data;

@Data
public class PcConstraint {

    private final int id;
    private final String name;
    private final String code;
    private final PcConstraintType type;

}
