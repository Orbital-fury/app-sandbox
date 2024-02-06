package com.appsandbox.appsandbox.infrastructure.pcbuilder.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElement;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementBasis;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementConstraint;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementSpecification;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.database.entities.PcElementEntity;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementConstraintService;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementSpecificationService;

@Service
public class PcElementMapper {

        @Autowired
        private PcElementConstraintService pcElementConstraintService;
        @Autowired
        private PcElementSpecificationService pcElementSpecificationService;

        public PcElementEntity dtoToEntity(PcElementBasis pcElementBasis) {
                int pcElementId = pcElementBasis.getId();
                return new PcElementEntity(
                                pcElementId,
                                pcElementBasis.getBrand(),
                                pcElementBasis.getModel(),
                                pcElementBasis.getPrice(),
                                pcElementBasis.getImg(),
                                pcElementBasis.getType(),
                                pcElementConstraintService.getElementConstraintEntities(pcElementId),
                                pcElementSpecificationService.getElementSpecificationEntities(pcElementId));
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

        public PcElement entityToDto(PcElementEntity pcElementEntity) {
                List<PcElementConstraint> pcElementConstraints = pcElementConstraintService
                                .getElementConstraints(pcElementEntity.getId());
                List<PcElementSpecification> pcElementSpecifications = pcElementSpecificationService
                                .getElementSpecifications(
                                                pcElementEntity.getId());

                return new PcElement(pcElementEntity.getId(),
                                pcElementEntity.getBrand(),
                                pcElementEntity.getModel(),
                                pcElementEntity.getPrice(),
                                pcElementEntity.getImg(),
                                pcElementEntity.getType(),
                                pcElementConstraints,
                                pcElementSpecifications);
        }

        public PcElementBasis entityToDtoBasis(PcElementEntity pcElementEntity) {
                return new PcElementBasis(
                                pcElementEntity.getId(),
                                pcElementEntity.getBrand(),
                                pcElementEntity.getModel(),
                                pcElementEntity.getPrice(),
                                pcElementEntity.getImg(),
                                pcElementEntity.getType());
        }

}
