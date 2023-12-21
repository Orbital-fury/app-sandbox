package com.appsandbox.appsandbox.infrastructure.database.entities;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.appsandbox.appsandbox.domain.enums.MachineState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "machines")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;
    @Column(name = "last_maintenance_date")
    private Date lastMaintenanceDate;
    @Enumerated(EnumType.STRING)
    private MachineState state;

}
