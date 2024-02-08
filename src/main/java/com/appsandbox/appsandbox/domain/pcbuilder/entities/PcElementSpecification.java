package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PcElementSpecification {

    private int elementId;
    private int specificationId;
    private String value;
    private PcElement pcElement;
    private PcSpecification pcSpecification;

}
