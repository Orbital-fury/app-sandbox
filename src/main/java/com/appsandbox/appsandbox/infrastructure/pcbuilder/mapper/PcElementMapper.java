package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementBasis;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementConstraintEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementSpecificationEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementConstraintRepository;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.repositories.PcElementSpecificationRepository;

@Service
public class PcElementMapper {

    @Autowired
    private PcElementConstraintRepository pcElementConstraintRepository;
    @Autowired
    private PcElementSpecificationRepository pcElementSpecificationRepository;

    public PcElementEntity dtoToEntity(PcElementBasis pcElementBasis) {
        int pcElementId = pcElementBasis.getId();
        List<PcElementConstraintEntity> elementConstraintEntities = pcElementConstraintRepository
                .findByElementId(pcElementId);
        List<PcElementSpecificationEntity> elementSpecificationEntities = pcElementSpecificationRepository
                .findByElementId(pcElementId);
        return new PcElementEntity(
                pcElementId,
                pcElementBasis.getBrand(),
                pcElementBasis.getModel(),
                pcElementBasis.getPrice(),
                pcElementBasis.getImg(),
                pcElementBasis.getType(),
                elementConstraintEntities,
                elementSpecificationEntities);
    }

    public PcElement entityToDto(PcElementEntity pcElementEntity, List<PcElementConstraint> pcElementConstraints,
            List<PcElementSpecification> pcElementSpecifications) {

        return new PcElement(pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementEntity.getType(),
                pcElementConstraints,
                pcElementSpecifications);
    }

    public PcElementBasis entityToDto(PcElementEntity pcElementEntity) {
        return new PcElementBasis(
                pcElementEntity.getId(),
                pcElementEntity.getBrand(),
                pcElementEntity.getModel(),
                pcElementEntity.getPrice(),
                pcElementEntity.getImg(),
                pcElementEntity.getType());
    }

}
