package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pc_elements_specifications")
@IdClass(PcElementSpecificationId.class)
@Data
public class PcElementSpecificationEntity {

    @Id
    private int elementId;
    @Id
    private int specificationId;
    @Column(name = "s_value")
    private String value;

}
