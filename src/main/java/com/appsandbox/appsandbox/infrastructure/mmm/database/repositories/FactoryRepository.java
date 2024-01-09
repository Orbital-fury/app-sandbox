package com.appsandbox.appsandbox.infrastructure.mmm.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.FactoryEntity;

@Repository
public interface FactoryRepository extends JpaRepository<FactoryEntity, Integer> {

}
