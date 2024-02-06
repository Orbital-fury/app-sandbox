package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;

import lombok.Data;

@Data
public class PcConstraints {

    private final List<PcConstraint> pcConstraints;

}
