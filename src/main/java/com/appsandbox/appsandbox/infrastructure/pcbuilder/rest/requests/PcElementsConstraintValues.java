package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraintValues;

import lombok.Data;

@Data
public class PcElementsConstraintValues {

    private final List<PcElementConstraintValues> pcElements;

}
