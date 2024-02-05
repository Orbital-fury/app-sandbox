package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pc_elements_constraints")
@IdClass(PcElementConstraintId.class)
@Data
public class PcElementConstraintEntity {

    @Id
    private int elementId;
    @Id
    private int constraintId;
    @Id
    private String value;
    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private PcElementEntity pcElement;
    @ManyToOne
    @JoinColumn(name = "constraint_id", nullable = false)
    private PcConstraintEntity pcConstraint;

}
