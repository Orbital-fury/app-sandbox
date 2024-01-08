package com.appsandbox.appsandbox.domain.mmm.entities;

import com.appsandbox.appsandbox.domain.mmm.enums.MachineType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {

  private int id;
  private String name;
  private MachineType type;
  private BrandWithoutModels brand;

}
