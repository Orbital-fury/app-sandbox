package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcConstraint {

    private int id;
    private String name;
    private String code;
    private PcConstraintType type;

}
