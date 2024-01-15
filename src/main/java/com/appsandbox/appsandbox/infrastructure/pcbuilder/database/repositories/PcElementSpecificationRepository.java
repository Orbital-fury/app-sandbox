package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;

@Repository
public interface PcElementSpecificationRepository extends JpaRepository<PcElementSpecificationEntity, Integer> {

    List<PcElementSpecificationEntity> findByElementId(int elementId);

    List<PcElementSpecificationEntity> findByElementIdAndSpecificationId(int elementId, int specificationId);

}
