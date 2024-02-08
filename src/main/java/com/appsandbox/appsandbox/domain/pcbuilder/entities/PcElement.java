package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcElement extends PcElementWithoutSpecs {

    private final List<PcSpecificationWithValues> specifications;

    public PcElement(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcConstraintWithValues> pcElementConstraints, List<PcSpecificationWithValues> pcElementSpecifications) {
        super(id, brand, model, price, img, type, pcElementConstraints);
        this.specifications = pcElementSpecifications;
    }

}
