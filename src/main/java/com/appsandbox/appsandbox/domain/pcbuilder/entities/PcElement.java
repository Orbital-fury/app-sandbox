package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PcElement {

    private int id;
    private String brand;
    private String model;
    private float price;
    private String img;
    private PcElementType type;
    private List<PcConstraint> constraints;
    private List<PcSpecification> specifications;

    public boolean canBeAddedRegardingConstraints(List<PcConstraint> pcConstraints) {
        List<PcConstraint> constraintsOfPcElement = this.constraints;
        // SAME, MAX, CAPACITY, LIMIT

        return true;
    }


}
