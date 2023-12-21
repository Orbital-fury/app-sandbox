package com.appsandbox.appsandbox.domain.entities;

import com.appsandbox.appsandbox.domain.enums.MachineType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {

  private int id;
  private String name;
  private MachineType type;
  private Brand brand;

}
