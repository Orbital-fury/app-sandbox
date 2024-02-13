package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;

import lombok.Data;

@Data
public class PcSpecifications {

    private final List<PcSpecification> pcSpecifications;

}
