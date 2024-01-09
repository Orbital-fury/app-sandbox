package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;

@Service
public class PcElementService {

    @Autowired
    private PcElementRepository pcElementRepository;
    @Autowired
    private PcElementConstraintService pcElementConstraintService;

    public List<PcElement> getAllPcElement() {
        List<PcElementEntity> pcElementEntities = pcElementRepository.findAll();
        List<PcElement> pcElements = new ArrayList<>();
        pcElementEntities.forEach(pcElementEntity -> pcElements.add(getPcConstraints(pcElementEntity)));
        return pcElements;
    }

    public PcElement getPcElement(int elementId) {
        Optional<PcElementEntity> optPcElementEntity = pcElementRepository.findById(elementId);
        if (optPcElementEntity.isPresent()) {
            PcElementEntity pcElementEntity = optPcElementEntity.get();
            return getPcConstraints(pcElementEntity);
        } else {
            throw new NoDataFoundException("PC element with id=" + elementId + " not found!");
        }

    }

    private PcElement getPcConstraints(PcElementEntity pcElementEntity) {
        int elementId = pcElementEntity.getId();
        List<PcConstraint> pcConstraints = pcElementConstraintService.getElementConstraints(elementId);
        return new PcElement(pcElementEntity.getId(), pcElementEntity.getBrand(), pcElementEntity.getModel(),
                pcElementEntity.getPrice(), pcElementEntity.getImg(), pcElementEntity.getType(), pcConstraints);
    }

}
