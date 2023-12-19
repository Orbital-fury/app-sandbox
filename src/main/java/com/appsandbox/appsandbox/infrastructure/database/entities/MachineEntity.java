package com.appsandbox.appsandbox.infrastructure.database.entities;

import java.util.Date;

import com.appsandbox.appsandbox.domain.enums.MachineState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "machines")
public class MachineEntity {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ModelEntity model;
    @Column(name = "serial_number")
    private String sn;
    @Column(name = "need_maintenance")
    private boolean needMaintenance;
    @ManyToOne
    @JoinColumn(name = "factory_id", nullable = true)
    private FactoryEntity factory;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "last_maintenance_date")
    private Date lastMaintenanceDate;
    private MachineState state;

}
