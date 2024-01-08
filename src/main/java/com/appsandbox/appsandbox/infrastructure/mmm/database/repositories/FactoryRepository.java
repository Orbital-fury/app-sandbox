package com.appsandbox.appsandbox.infrastructure.mmm.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.FactoryEntity;

@Repository
public interface FactoryRepository extends JpaRepository<FactoryEntity, Integer> {

    FactoryEntity findById(int id);

    List<FactoryEntity> findAll();

}