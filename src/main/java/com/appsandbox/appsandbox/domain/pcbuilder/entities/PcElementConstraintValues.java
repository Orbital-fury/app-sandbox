package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.Data;

@Data
public class PcElementConstraintValues {

    private final PcElementWithoutConstraintsAndSpecs pcElementInfo;
    private final List<String> constraintValues;

}
