package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PcElement extends PcElementBasis {

    private final List<PcConstraint> constraints;
    private final List<PcSpecification> specifications;

    public PcElement(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcConstraint> constraints, List<PcSpecification> specifications) {
        super(id, brand, model, price, img, type);
        this.constraints = constraints;
        this.specifications = specifications;
    }

}
