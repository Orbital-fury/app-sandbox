package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;

import lombok.Data;

@Data
public class PcConstraintsWithoutValue {

    private final List<PcConstraintWithoutValue> pcConstraints;

}
