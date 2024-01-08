package com.appsandbox.appsandbox.infrastructure.pcbuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementRepository;

@Service
public class PcElementService {

    @Autowired
    private PcElementRepository pcElementRepository;
    @Autowired
    private PcElementConstraintService pcElementConstraintService;

    public List<PcElementEntity> getAllPcElementEntities() {
        return pcElementRepository.findAll();
    }

    public PcElement getPcElement(int elementId) {
        Optional<PcElementEntity> optPcElementEntity = pcElementRepository.findById(elementId);
        if (optPcElementEntity.isEmpty()) {
            return null;
        } else {
            PcElementEntity pcElementEntity = optPcElementEntity.get();
            List<PcConstraint> pcConstraints = pcElementConstraintService.getElementConstraints(elementId);
            return new PcElement(pcElementEntity.getId(), pcElementEntity.getBrand(), pcElementEntity.getModel(),
                    pcElementEntity.getPrice(), pcElementEntity.getImg(), pcElementEntity.getType(), pcConstraints);
        }

    }

}
