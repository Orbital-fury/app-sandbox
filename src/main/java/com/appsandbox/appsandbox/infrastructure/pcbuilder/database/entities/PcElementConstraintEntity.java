package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc_elements_constraints")
@IdClass(PcElementConstraintId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcElementConstraintEntity {

    @Id
    private int elementId;
    @Id
    private int constraintId;
    @Id
    private String value;

}