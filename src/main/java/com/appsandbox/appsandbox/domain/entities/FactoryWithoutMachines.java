package com.appsandbox.appsandbox.domain.entities;

import com.appsandbox.appsandbox.domain.enums.FactoryType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FactoryWithoutMachines {

    private int id;
    private String name;
    private FactoryType type;
    private String address;

}
