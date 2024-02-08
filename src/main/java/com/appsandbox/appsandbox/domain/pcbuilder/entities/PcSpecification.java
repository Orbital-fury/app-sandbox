package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import lombok.Data;

@Data
public class PcSpecification {

    private final int id;
    private final String name;
    private final String code;
    private final List<PcElementSpecification> pcElementSpecifications;

}
