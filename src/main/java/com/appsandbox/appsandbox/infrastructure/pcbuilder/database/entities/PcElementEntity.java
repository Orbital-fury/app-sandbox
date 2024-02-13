package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "element_type_id")
    private PcElementTypeEntity pcElementType;
    @OneToMany(mappedBy = "pcElement", cascade = CascadeType.REMOVE)
    private List<PcElementConstraintEntity> pcElementConstraints = new ArrayList<>();
    @OneToMany(mappedBy = "pcElement", cascade = CascadeType.REMOVE)
    private List<PcElementSpecificationEntity> pcElementSpecifications = new ArrayList<>();

}
