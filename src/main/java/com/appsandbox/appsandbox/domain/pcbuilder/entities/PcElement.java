package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcElement extends PcElementWithoutConstraintsAndSpecs {

    private final List<PcElementConstraint> pcElementConstraints;
    private final List<PcElementSpecification> pcElementSpecifications;

    public PcElement(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcElementConstraint> pcElementConstraints, List<PcElementSpecification> pcElementSpecifications) {
        super(id, brand, model, price, img, type);
        this.pcElementConstraints = pcElementConstraints;
        this.pcElementSpecifications = pcElementSpecifications;
    }

}
