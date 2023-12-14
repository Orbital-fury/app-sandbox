package com.appsandbox.appsandbox.infrastructure.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "factories")
public class FactoryEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private String address;
}
