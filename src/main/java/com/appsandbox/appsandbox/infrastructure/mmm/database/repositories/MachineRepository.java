package com.appsandbox.appsandbox.infrastructure.mmm.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.MachineEntity;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Integer> {

    List<MachineEntity> findAll();

    MachineEntity findById(int id);

}