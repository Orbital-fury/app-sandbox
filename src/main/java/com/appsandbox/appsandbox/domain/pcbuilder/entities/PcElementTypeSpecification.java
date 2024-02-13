package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.Data;

@Data
public class PcElementTypeSpecification {

    private final PcElementType pcElementType;
    private final List<PcSpecification> pcSpecifications;

}
