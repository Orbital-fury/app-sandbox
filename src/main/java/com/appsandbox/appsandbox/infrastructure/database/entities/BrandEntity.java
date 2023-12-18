package com.appsandbox.appsandbox.infrastructure.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "machines")
public class BrandEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String website;
    private String hqAddress;
    
}
