package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import lombok.Data;

@Data
public class PcElementConstraint {

    private final int elementId;
    private final int constraintId;
    private final String value;
    private final PcConstraint pcConstraint;

}
