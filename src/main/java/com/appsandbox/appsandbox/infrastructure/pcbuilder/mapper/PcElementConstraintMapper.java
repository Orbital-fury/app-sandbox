package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;

@Service
public class PcElementConstraintMapper {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;

    public List<PcElementConstraintEntity> dtoToEntity(PcElementConstraint pcElementConstraint) {
        return pcElementConstraintRepository.findByConstraintId(pcElementConstraint.getId());
    }

    public PcElementConstraint entityToDto(List<PcElementConstraintEntity> pcElementConstraintEntities) {
        if (pcElementConstraintEntities.isEmpty()) {
            return null;
        }
        PcConstraintEntity pcConstraintEntity = pcElementConstraintEntities.get(0).getPcConstraint();
        int firstConstraintId = pcConstraintEntity.getId();
        for (PcElementConstraintEntity entity : pcElementConstraintEntities) {
            if (entity.getConstraintId() != firstConstraintId) {
                throw new IllegalStateException("Constraint ids are not all identical !!");
            }
        }
        
        return null;
    }

}
