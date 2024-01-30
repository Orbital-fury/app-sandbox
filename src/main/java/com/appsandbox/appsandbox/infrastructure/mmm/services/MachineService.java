package com.appsandbox.appsandbox.infrastructure.mmm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.mmm.entities.Machine;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.mmm.database.entities.MachineEntity;
import com.appsandbox.appsandbox.infrastructure.mmm.database.repositories.MachineRepository;
import com.appsandbox.appsandbox.infrastructure.mmm.mapper.MachineMapper;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private MachineMapper machineMapper;

    public List<Machine> getAllMachines() {
        List<MachineEntity> entityList = machineRepository.findAll();
        List<Machine> machineList = new ArrayList<>();
        for (MachineEntity machineEntity : entityList) {
            Machine entityToDto = machineMapper.entityToDto(machineEntity);
            machineList.add(entityToDto);
        }
        return machineList;
    }

    public Machine getMachine(int id) {
        /*
         * Optional<MachineEntity> optMachineEntity = machineRepository.findById(id);
         * if (optMachineEntity.isPresent()) {
         * return machineMapper.entityToDto(optMachineEntity.get());
         * } else {
         * throw new NoDataFoundException("Machine with id=" + id + " not found!");
         * }
         */
        return machineRepository.findById(id)
                .map(machineMapper::entityToDto)
                .orElseThrow(() -> new NoDataFoundException("Machine not found for id:" + id));
    }

}
