package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities;

import java.util.ArrayList;
import java.util.List;

import com.appsandbox.appsandbox.domain.pcbuilder.enums.PcConstraintType;

import jakarta.persistence.CascadeType;
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
@Table(name = "pc_constraints")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PcConstraintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    @Enumerated(EnumType.STRING)
    private PcConstraintType type;
    @OneToMany(mappedBy = "pcConstraint", cascade = CascadeType.REMOVE)
    private List<PcElementConstraintEntity> pcElementConstraints = new ArrayList<>();
    @OneToMany(mappedBy = "pcConstraint", cascade = CascadeType.REMOVE)
    private List<PcElementTypeConstraintEntity> pcElementTypeConstraints = new ArrayList<>();

}
