package com.appsandbox.appsandbox.infrastructure.database.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.enums.FactoryType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private FactoryType type;
    private String address;
    @OneToMany(mappedBy = "factory", fetch = FetchType.LAZY)
    private List<MachineEntity> machines;

}
