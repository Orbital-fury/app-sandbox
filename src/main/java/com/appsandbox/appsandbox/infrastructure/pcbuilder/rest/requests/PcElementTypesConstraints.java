package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementTypeConstraint;

import lombok.Data;

@Data
public class PcElementTypesConstraints {

    private final List<PcElementTypeConstraint> pcElementTypeConstraints;

}
