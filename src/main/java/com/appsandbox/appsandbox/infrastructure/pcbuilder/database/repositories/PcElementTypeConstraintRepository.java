package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementTypeEntity;


@Repository
public interface PcElementTypeConstraintRepository extends JpaRepository<PcElementTypeConstraintEntity, Integer> {

    List<PcElementTypeConstraintEntity> findByPcElementType(PcElementTypeEntity pcElementType);
    
}
