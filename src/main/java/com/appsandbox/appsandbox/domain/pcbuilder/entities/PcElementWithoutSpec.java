package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PcElementWithoutSpec {

    private int id;
    private String brand;
    private String model;
    private float price;
    private String img;
    private PcElementType type;

}
