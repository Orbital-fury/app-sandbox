package com.appsandbox.appsandbox.infrastructure.mmm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoContentException;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.MachineEntity;
import com.appsandbox.appsandbox.infrastructure.mmm.database.repositories.MachineRepository;
import com.appsandbox.appsandbox.infrastructure.mmm.mapper.MachineMapper;

@Service
public class MachineService {

    Logger log = LoggerFactory.getLogger(MachineService.class);

    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private MachineMapper machineMapper;

    public List<Machine> getAllMachines() {
        List<MachineEntity> entityList = machineRepository.findAll();
        if (entityList.isEmpty()) {
            log.info("******************");
            log.info("empty list");
            log.info("******************");
            throw new NoContentException("No machines have been retrieved");
        }
        List<Machine> machineList = new ArrayList<>();
        for (MachineEntity machineEntity : entityList) {
            Machine entityToDto = machineMapper.entityToDto(machineEntity);
            machineList.add(entityToDto);
        }
        log.info("******************");
        log.info("List bien créée, on a continué la méthode");
        log.info("******************");
        return machineList;
    }

    public Machine getMachine(int id) {
        Optional<MachineEntity> optMachineEntity = machineRepository.findById(id);
        if (optMachineEntity.isPresent()) {
            return machineMapper.entityToDto(optMachineEntity.get());
        } else {
            throw new NoDataFoundException("Machine with id=" + id + " not found!");
        }

    }

}
