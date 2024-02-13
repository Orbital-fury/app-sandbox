package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PcElementWithoutConstraintsAndSpecs {

    private int id;
    private String brand;
    private String model;
    private float price;
    private String img;
    private PcElementType type;

}
