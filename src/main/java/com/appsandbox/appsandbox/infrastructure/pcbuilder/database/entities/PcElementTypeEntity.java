package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc_element_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PcElementTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    @OneToMany(mappedBy = "pcElementType", cascade = CascadeType.REMOVE)
    private List<PcElementTypeConstraintEntity> pcElementTypeConstraints = new ArrayList<>();
    @OneToMany(mappedBy = "pcElementType")
    private List<PcElementEntity> pcElements = new ArrayList<>();

}
