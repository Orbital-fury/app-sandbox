package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import java.util.List;


@Repository
public interface PcElementConstraintRepository extends JpaRepository<PcElementConstraintEntity, Integer> {

    List<PcElementConstraintEntity> findByElementId(int elementId);

    List<PcElementConstraintEntity> findByElementIdAndConstraintId(int elementId, int constraintId);
    
}
