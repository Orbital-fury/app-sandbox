package com.appsandbox.appsandbox.domain.mmm.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.enums.MmmFactoryType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Factory {

  private int id;
  private String name;
  private MmmFactoryType type;
  private String address;
  private List<MachineWithoutFactory> machines;

}
