package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcSpecificationEntity;

@Repository
public interface PcSpecificationRepository extends JpaRepository<PcSpecificationEntity, Integer> {

}
