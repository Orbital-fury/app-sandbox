package com.appsandbox.appsandbox.infrastructure.mmm.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {

}
