package com.appsandbox.appsandbox.infrastructure.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String website;
    @Column(name = "hq_address")
    private String hqAddress;
    @OneToMany(mappedBy = "brand")
    private List<ModelEntity> models;

}
