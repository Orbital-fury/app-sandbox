package com.appsandbox.appsandbox.infrastructure.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.database.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {

    List<ModelEntity> findAll();

}
