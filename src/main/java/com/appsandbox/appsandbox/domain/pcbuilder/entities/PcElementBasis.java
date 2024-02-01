package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.Data;

@Data
public class PcElementBasis {

    private final int id;
    private final String brand;
    private final String model;
    private final float price;
    private final String img;
    private final PcElementType type;

}
