package com.appsandbox.appsandbox.domain.entities;

import com.appsandbox.appsandbox.infrastructure.database.entities.FactoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Factory {

  private int id;
  private String name;
  private String type;
  private String address;

  public Factory(FactoryEntity factoryEntity) {
    this(factoryEntity.getId(), factoryEntity.getName(), factoryEntity.getType(), factoryEntity.getAddress());
  }

  public FactoryEntity toEntity(Factory factory) {
    return new FactoryEntity(factory);
  }

}
