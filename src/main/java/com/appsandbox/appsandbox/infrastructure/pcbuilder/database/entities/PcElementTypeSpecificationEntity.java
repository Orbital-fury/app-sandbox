package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc_element_types_specifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PcElementTypeSpecificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "element_type_id")
    private PcElementTypeEntity pcElementType;
    @ManyToOne
    @JoinColumn(name = "specification_id")
    private PcSpecificationEntity pcSpecification;

}
