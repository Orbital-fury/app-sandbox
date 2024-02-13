package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintId;

import java.util.List;


@Repository
public interface PcElementConstraintRepository extends JpaRepository<PcElementConstraintEntity, PcElementConstraintId> {

    List<PcElementConstraintEntity> findByElementId(int elementId);

    List<PcElementConstraintEntity> findByConstraintId(int constraintId);

    List<PcElementConstraintEntity> findByElementIdAndConstraintId(int elementId, int constraintId);
    
}
