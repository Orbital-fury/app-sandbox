package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementBasis;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcSpecification;
import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcElementType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pc_elements")
@Data
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

    public PcElement toDto(List<PcConstraint> pcConstraints, List<PcSpecification> pcSpecifications) {
        return new PcElement(id, brand, model, price, img, type, pcConstraints, pcSpecifications);
    }

    public PcElementBasis toDtoWithoutSpec() {
        return new PcElementBasis(id, brand, model, price, img, type);
    }

}
