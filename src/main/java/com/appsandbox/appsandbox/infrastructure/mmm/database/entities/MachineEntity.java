package com.appsandbox.appsandbox.infrastructure.mmm.database.entities;

import java.util.Date;

import com.appsandbox.appsandbox.domain.mmm.enums.MachineState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "machines")
@Data
public class MachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @Column(name = "last_maintenance_date")
    private Date lastMaintenanceDate;
    @Enumerated(EnumType.STRING)
    private MachineState state;

}
