package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.ArrayList;
import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PcElement extends PcElementWithoutSpecs {

    private List<PcSpecificationWithValues> specifications = new ArrayList<>();

    public PcElement(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcConstraintWithValues> pcElementConstraints,
            List<PcSpecificationWithValues> pcElementSpecifications) {
        super(id, brand, model, price, img, type, pcElementConstraints);
        this.specifications = pcElementSpecifications;
    }

}
