package com.appsandbox.appsandbox.domain.mmm.entities;

import java.util.Date;

import com.appsandbox.appsandbox.domain.mmm.enums.MachineState;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MachineWithoutModel {

  private int id;
  private String sn;
  private boolean needMaintenance;
  private Factory factory;
  private Date createdAt;
  private Date lastMaintenanceDate;
  private MachineState state;

}
