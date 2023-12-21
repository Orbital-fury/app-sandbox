package com.appsandbox.appsandbox.infrastructure.database.entities;

import java.util.List;

import com.appsandbox.appsandbox.domain.enums.MachineType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MachineType type;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;
    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<MachineEntity> machines;

}
