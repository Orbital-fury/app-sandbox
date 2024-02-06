package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.util.ArrayList;
import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc_elements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcElementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private float price;
    private String img;
    @Column(name = "element_type")
    @Enumerated(EnumType.STRING)
    private PcElementType type;
    @OneToMany(mappedBy = "pcElement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PcElementConstraintEntity> pcElementConstraints = new ArrayList<>();
    @OneToMany(mappedBy = "pcElement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PcElementSpecificationEntity> pcElementSpecifications = new ArrayList<>();

    // public PcElement toDto(List<PcConstraint> pcConstraints, List<PcSpecification> pcSpecifications) {
    //     return new PcElement(id, brand, model, price, img, type, pcConstraints, pcSpecifications);
    // }

}
