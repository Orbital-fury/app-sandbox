package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementTypeSpecification;

import lombok.Data;

@Data
public class PcElementTypesSpecifications {

    private final List<PcElementTypeSpecification> pcElementTypeSpecifications;
    
}
