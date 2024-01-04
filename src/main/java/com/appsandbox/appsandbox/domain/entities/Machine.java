package com.appsandbox.appsandbox.domain.entities;

import java.util.Date;

import com.appsandbox.appsandbox.domain.enums.MachineState;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Machine {

  @Schema(name = "Machine ID", example = "1", required = true)
  private int id;
  private Model model;
  private String sn;
  private boolean needMaintenance;
  private FactoryWithoutMachines factory;
  private Date createdAt;
  private Date lastMaintenanceDate;
  private MachineState state;

}
