package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pc_elements")
@Data
public class PcElementEntity {

    @Id
    @GeneratedValue
    private int id;
    private String brand;
    private String model;
    private float price;
    private String img;
    @Column(name = "element_type")
    @Enumerated(EnumType.STRING)
    private PcElementType type;

}
