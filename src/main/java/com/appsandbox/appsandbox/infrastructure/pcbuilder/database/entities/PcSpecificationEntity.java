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
@Table(name = "pc_specifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcSpecificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    @OneToMany(mappedBy = "pcSpecification", cascade = CascadeType.REMOVE)
    private List<PcElementSpecificationEntity> pcElementSpecifications = new ArrayList<>();

}
