package com.appsandbox.appsandbox.infrastructure.database.entities;

import com.appsandbox.appsandbox.domain.entities.Factory;

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
@Table(name = "factories")
public class FactoryEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private String address;

    public FactoryEntity(Factory factory) {
        this(factory.getId(), factory.getName(), factory.getType(), factory.getAddress());
    }

    public Factory toDto() {
        return new Factory(this);
    }

}
