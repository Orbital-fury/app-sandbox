package com.appsandbox.appsandbox.infrastructure.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.database.entities.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {

    List<BrandEntity> findAll();

}
