package com.appsandbox.appsandbox.domain.pcbuilder.entities;

import java.util.ArrayList;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;

import lombok.Data;

@Data
public class PcElementBasis {

    private final int id;
    private final String brand;
    private final String model;
    private final float price;
    private final String img;
    private final PcElementType type;

    public PcElementEntity toEntity() {
        return new PcElementEntity(this.getId(), this.getBrand(), this.getModel(), this.getPrice(), this.getImg(), this.getType(), new ArrayList<>(), new ArrayList<>());
    }

}
