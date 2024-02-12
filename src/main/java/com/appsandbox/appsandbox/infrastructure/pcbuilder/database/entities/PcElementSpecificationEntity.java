package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc_elements_specifications")
@IdClass(PcElementSpecificationId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcElementSpecificationEntity {

    @Id
    private int elementId;
    @Id
    private int specificationId;
    @Column(name = "s_value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "element_id")
    private PcElementEntity pcElement;
    @ManyToOne
    @JoinColumn(name = "specification_id")
    private PcSpecificationEntity pcSpecification;

}
