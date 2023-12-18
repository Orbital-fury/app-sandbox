package com.appsandbox.appsandbox.infrastructure.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "machines")
public class MachineEntity {

    @Id
    @GeneratedValue
    private int id;
    private int modelId;
    private String sn;
    private boolean needMaintenance;
    private int factoryId;
    private String createdAt;
    private String lastMaintenanceDate;
    private String state;

    // public FactoryEntity(Factory factory) {
    //     this(factory.getId(), factory.getName(), factory.getType(), factory.getAddress());
    // }

    // public Factory toDto() {
    //     return new Factory(this);
    // }

}
