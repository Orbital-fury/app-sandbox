package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "pc_constraints")
@Data
@ToString
public class PcConstraintEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String code;
    @Enumerated(EnumType.STRING)
    private PcConstraintType type;

}
