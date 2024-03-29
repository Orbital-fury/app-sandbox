package com.appsandbox.appsandbox.infrastructure.mmm.database.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.mmm.enums.MmmFactoryType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MmmFactoryType type;
    private String address;
    @OneToMany(mappedBy = "factory", fetch = FetchType.LAZY)
    private List<MachineEntity> machines;

}
