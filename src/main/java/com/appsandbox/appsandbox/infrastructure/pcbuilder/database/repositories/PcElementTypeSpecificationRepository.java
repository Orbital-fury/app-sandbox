package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeSpecificationEntity;


@Repository
public interface PcElementTypeSpecificationRepository extends JpaRepository<PcElementTypeSpecificationEntity, Integer> {

    List<PcElementTypeSpecificationEntity> findByPcElementType(PcElementTypeEntity pcElementType);
    
}
