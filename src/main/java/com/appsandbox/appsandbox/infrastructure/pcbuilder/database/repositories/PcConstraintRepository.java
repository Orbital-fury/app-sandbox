package com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;

@Repository
public interface PcConstraintRepository extends JpaRepository<PcConstraintEntity, Integer> {

    List<PcConstraintEntity> findAllByIdIn(List<Integer> ids);

}
