package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcElementWithoutSpecs extends PcElementWithoutConstraintsAndSpecs {

    private final List<PcConstraintWithValues> constraints;

    public PcElementWithoutSpecs(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcConstraintWithValues> pcElementConstraints) {
        super(id, brand, model, price, img, type);
        this.constraints = pcElementConstraints;
    }

}
