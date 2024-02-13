package com.appsandbox.appsandbox.domain.mmm.entities;

import com.appsandbox.appsandbox.domain.mmm.enums.MmmFactoryType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FactoryWithoutMachines {

    private int id;
    private String name;
    private MmmFactoryType type;
    private String address;

}
