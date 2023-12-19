package com.appsandbox.appsandbox.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Machine {

  private int id;
  private Model model;
  private String sn;
  private boolean needMaintenance;
  private Factory factory;
  private String createdAt;
  private String lastMaintenanceDate;
  private String state;

}
