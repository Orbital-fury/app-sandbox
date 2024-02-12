package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.ArrayList;
import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PcElementWithoutSpecs extends PcElementWithoutConstraintsAndSpecs {

    private List<PcConstraintWithValues> constraints = new ArrayList<>();

    public PcElementWithoutSpecs(int id, String brand, String model, float price, String img, PcElementType type,
            List<PcConstraintWithValues> pcElementConstraints) {
        super(id, brand, model, price, img, type);
        this.constraints = pcElementConstraints;
    }

}
