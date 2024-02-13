package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.Data;

@Data
public class PcElementTypeConstraint {

    private final PcElementType pcElementType;
    private final List<PcConstraint> pcConstraints;
    
}
