package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pc_specifications")
@Data
public class PcSpecificationEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String code;

}
